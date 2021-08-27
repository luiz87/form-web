package org.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.senai.db.Conexao;
import org.senai.model.Pessoa;

public class PessoaDao {

	public boolean adicionar(Pessoa objP) {
		String lsTecnologia = "";
		if (objP.getTecnologia() != null) {
			for (String t : objP.getTecnologia()) {
				lsTecnologia += t + ",";
			}
		}
		try {
			Connection cont = Conexao.conectar();

			String sql = "insert into pessoas (nome_completo , telefone , dt_nascimento , email , sexo , tecnologia , escolaridade , uf , senha) "
					+ "values(?,?,?,?,?,?,?,?,'123') ";
			PreparedStatement pst = cont.prepareStatement(sql);

			pst.setString(1, sql);
			pst.setString(1, objP.getNomeCompleto());
			pst.setString(2, objP.getTelefone());
			pst.setString(3, objP.getDtNascimento());
			pst.setString(4, objP.getEmail());
			pst.setString(5, objP.getSexo());
			pst.setString(6, lsTecnologia);
			pst.setString(7, objP.getEscolaridade());
			pst.setString(8, objP.getUf());

			pst.execute();
			pst.close();
			cont.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Pessoa> listarPessoa() {
		List<Pessoa> ls = new ArrayList<>();
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("select * from pessoas order by id");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setNomeCompleto(rs.getString("nome_completo"));
				p.setEmail(rs.getString("email"));
				p.setId(rs.getInt("id"));
				ls.add(p);
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public Pessoa getPessoa(int id) {
		Pessoa p = new Pessoa();
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("select * from pessoas where id = ? ");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p.setNomeCompleto(rs.getString("nome_completo"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setDtNascimento(rs.getString("dt_nascimento"));
				p.setSexo(rs.getString("sexo"));
				p.setTecnologia(rs.getString("tecnologia").split(","));
				p.setEscolaridade(rs.getString("escolaridade"));
				p.setUf(rs.getString("uf"));
				p.setSenha(rs.getString("senha"));
				p.setId(rs.getInt("id"));
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public boolean alterar(Pessoa objP) {
		String lsTecnologia = "";
		if (objP.getTecnologia() != null) {
			for (String t : objP.getTecnologia()) {
				lsTecnologia += t + ",";
			}
		}

		try {
			Connection cont = Conexao.conectar();

			String sql = " update pessoas  set nome_completo = ?, telefone = ?, dt_nascimento = ?, email = ?,"
					+ "sexo = ?, tecnologia = ?, escolaridade = ?, uf = ? where id = ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, objP.getNomeCompleto());
			pst.setString(2, objP.getTelefone());
			pst.setString(3, objP.getDtNascimento());
			pst.setString(4, objP.getEmail());
			pst.setString(5, objP.getSexo());
			pst.setString(6, lsTecnologia);
			pst.setString(7, objP.getEscolaridade());
			pst.setString(8, objP.getUf());
			pst.setInt(9, objP.getId());

			pst.execute();
			pst.close();
			cont.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean apagar(int id) {
		try {
			Connection cont = Conexao.conectar();

			String sql = " delete from pessoas where  id = ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setInt(1, id);

			pst.execute();
			pst.close();
			cont.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Pessoa validarLogin(String login, String senha) {
		Pessoa p = new Pessoa();
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement(
					"select * from pessoas WHERE email = '" + login + "' AND senha = '" + senha + "'");
			ResultSet rs = pst.executeQuery();
			rs.next();
			p.setId(rs.getInt("id"));
			cont.close();
			p = getPessoa(p.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;

	}
	
	public boolean alterarSenha(Pessoa objP) {
	
		try {
			Connection cont = Conexao.conectar();

			String sql = " update pessoas  set senha = ? where id = ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, objP.getSenha());
			pst.setInt(2, objP.getId());

			pst.execute();
			pst.close();
			cont.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

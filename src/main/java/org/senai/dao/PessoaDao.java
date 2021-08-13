package org.senai.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.senai.db.Conexao;
import org.senai.model.Pessoa;

public class PessoaDao {

	public boolean adicionar(Pessoa objP) {
		String lsTecnologia = "";
		for (String t : objP.getTecnologia()) {
			lsTecnologia += t + ",";
		}
		try {
			Connection cont = Conexao.conectar();

			String sql = "insert into pessoas (nome_completo , telefone , dt_nascimento , email , sexo , tecnologia , escolaridade ) "
					+ "values('" + objP.getNomeCompleto() + "', '" + objP.getTelefone() + "', '"
					+ objP.getDtNascimento() + "', '" + objP.getEmail() + "', '" + objP.getSexo() + "', '"
					+ lsTecnologia + "', '" + objP.getEscolaridade() + "') ";
			PreparedStatement pst = cont.prepareStatement(sql);
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

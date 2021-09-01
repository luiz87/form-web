package org.senai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.dao.PessoaDao;
import org.senai.model.Pessoa;

import com.google.gson.Gson;

@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter saida = res.getWriter();
		Map msg = new HashMap<>();

		Pessoa objP = new Pessoa();

		String acao = req.getParameter("acao");

		if (acao != null && acao.equals("apagar")) {
			objP.setId(Integer.parseInt(req.getParameter("id")));
		} else {
			objP.setNomeCompleto(req.getParameter("nomecompleto"));
			objP.setTelefone(req.getParameter("telefone"));

			Date dtNascimento;
			try {
				dtNascimento = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dtNascimento"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtNascimento);
				objP.setDtNascimento(cal);
			} catch (ParseException e) {
				e.printStackTrace();
				msg.put("msg", "Data de nascimento inválida");
			}

			objP.setEmail(req.getParameter("email"));
			objP.setSexo(req.getParameter("sexo"));
			objP.setTecnologia(req.getParameterValues("tecnologia"));
			objP.setEscolaridade(req.getParameter("escolaridade"));
			objP.setUf(req.getParameter("uf"));
			objP.setId(Integer.parseInt(req.getParameter("id")));
		}

		PessoaDao objDao = new PessoaDao();

		boolean validar = false;
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");

		if (objP.getId() > 0) {
			if (acao != null && acao.equals("apagar")) {
				validar = objDao.apagar(objP.getId());
				msg.put("msg", "Sucesso ao apagar");
			} else {
				validar = objDao.alterar(objP);
				msg.put("msg", "Sucesso ao alterar");
			}
		} else {
			if(objP.getEmail().equals("")) {
				msg.put("msg", "Necessário preencher o e-mail.");
			}
			if (!msg.containsKey("msg")) {
				if (objDao.verificarEmail(objP.getEmail())) {
					validar = objDao.adicionar(objP);
					msg.put("msg", "Sucesso ao gravar");
				} else {
					// vamos tratar o erro.
					msg.put("msg", "Erro ao gravar, email já existe");
				}
			} 

		}

		saida.print(new Gson().toJson(msg));

	}

	private DateTimeFormatter SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

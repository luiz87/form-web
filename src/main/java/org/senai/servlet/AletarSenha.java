package org.senai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.dao.PessoaDao;
import org.senai.model.Pessoa;

@WebServlet("/alterarSenha")
public class AletarSenha extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String senhaAtual = req.getParameter("senhaAtual");
		String novaSenha = req.getParameter("novaSenha");
		String confirmarSenha = req.getParameter("confirmarSenha");
		
		// regras de negocio sobre a alteração da senha
//		senhaAtual tem que ser igual a senha do banco
//		novaSenha e confirmarSenha devem ser iguais
		Pessoa p = (Pessoa) req.getSession().getAttribute("usuario");
		PrintWriter out = res.getWriter();
		if (novaSenha.equals(confirmarSenha) && p.getSenha().equals(senhaAtual)) {
			// chamar um método para alterar a senha.
			p.setSenha(novaSenha);
			PessoaDao dao = new PessoaDao();
			dao.alterarSenha(p);
			out.print("Ok ao alterar a senha. ");
		} else {
			
			out.print("Não é possível alterar a senha. ");
		}

	}

}

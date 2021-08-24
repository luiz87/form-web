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

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		PessoaDao dao = new PessoaDao();
		Pessoa p = dao.validarLogin(login, senha);

		if (p.getId() > 0) {
			res.sendRedirect("formCadastro.jsp");
			req.getSession().setAttribute("usuario", p);
		} else {
			res.sendRedirect("login.jsp");
		}

	}
}

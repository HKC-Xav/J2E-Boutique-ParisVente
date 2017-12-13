package com.parisventes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.parisventes.bean.BDD;
import com.parisventes.bean.Personne;

//Cookie cookie = new Cookie("E-mail", mail);
//cookie.setMaxAge(10);
//response.addCookie(cookie);
//response.addCookie(new Cookie("Password", pass));

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");
		Boolean isLog = false;
		BDD bdd = new BDD(BDD.FILEPERS);
		HttpSession session = request.getSession(true);
		Personne user = new Personne();
		user = user.findByMail(bdd.readFile(), mail);
		if (user.getEmail() != null && user.getEmail().equals(mail)) {
			if (user.getPassword().equals(pass)) {
				isLog = true;
				session.setAttribute("isLog", isLog);
				session.setAttribute("user", user);
			}
		}
		doGet(request, response);
	}

}

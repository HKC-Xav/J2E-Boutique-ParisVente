package com.parisventes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
		String deco = request.getParameter("delog");
		Boolean isLog = false;
		HttpSession session = request.getSession(true);
		if (pass.equals("123456")) {
			isLog = true;
			session.setAttribute("email", mail);
			session.setAttribute("isLog", isLog);
		}
		
		if (deco.equals("true")) {
			session.invalidate();
		}
		doGet(request, response);
	}

}

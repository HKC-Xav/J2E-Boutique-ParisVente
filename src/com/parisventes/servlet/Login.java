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


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.invalidate();
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass");
		String age = request.getParameter("age");
		request.setAttribute("age", age);
//		Cookie cookie = new Cookie("E-mail", mail);
//		cookie.setMaxAge(10);
//		response.addCookie(cookie);
//		response.addCookie(new Cookie("Password", pass));
		HttpSession session = request.getSession(true);
		session.setAttribute("email", mail);
		String[] str = {"Vaness", "Chairat", "Sam"};
		request.setAttribute("str", str);
		doGet(request, response);
	}

}

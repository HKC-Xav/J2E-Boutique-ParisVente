package com.parisventes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.bean.Article;
import com.parisventes.bean.BDD;

@WebServlet("/home")
public class Home<ReadFile> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Article articles = new Article();
		BDD bdd = new BDD(BDD.FILEPATH);
		
		request.setAttribute("html", articles.findAll(bdd.readFile()));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

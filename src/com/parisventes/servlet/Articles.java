package com.parisventes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.bean.Article;
import com.parisventes.bean.BDD;

@WebServlet("/article")
public class Articles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Articles() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Article a = new Article();
		String html = a.findArticle(BDD.readFiles(BDD.FILEPATH),BDD.findById(Integer.parseInt(id)));
		
		request.setAttribute("html", html );
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

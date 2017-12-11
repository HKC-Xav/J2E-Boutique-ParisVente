package com.parisventes.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.bean.BDD;

@WebServlet("/home")
public class Home<ReadFile> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}

	public String readFile(HttpServletRequest request, HttpServletResponse response) {
		List<String> allLines = null;
		String html;
		String allHtml = "";
		try {
			allLines = Files.readAllLines(Paths.get(BDD.FILEPATH));
			for (String line : allLines) {
				String[] arr = line.split("\\|");
				
				html = "<article><h4>";
				html += arr[1] + "</h4><fieldset disabled=\"disabled\"><figure><a href=\""+request.getContextPath()+"/article?id="+arr[0]+"\"><img src=\"";
				html += request.getContextPath() + arr[2] + "\" alt=\"\"> </a> <figcaption>";
				html += arr[3] + "</figcaption> </figure> </fieldset> <span class=\"article-prix\"> ";
				html += arr[4] + "€</span></article>";
				allHtml += html;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allHtml;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("html", readFile(request, response));
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

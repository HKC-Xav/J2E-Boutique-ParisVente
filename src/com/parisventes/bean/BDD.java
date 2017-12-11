package com.parisventes.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class BDD {
	public static final String FILEPATH = "C:\\Users\\Administrateur\\Desktop\\Formation POE\\J2EE\\ParisVente\\WebContent\\articles.txt";
	private List<String> allLines = null;
	private String filename;
	
	public BDD() {
	}
	
	public BDD(String filename) {
		filename = this.filename;
	}
	
	public List<String> readFile(HttpServletRequest request) {
		try {
			this.allLines = Files.readAllLines(Paths.get(this.filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;
	}
	
	private String readArticle(HttpServletRequest request) {
		BDD bdd = new BDD(FILEPATH);
		String html="";
		for (String line: bdd.readFile(request)) {
			String[] arr = line.split("\\|");
			html = "<article><h4>";
			html += arr[1] + "</h4><fieldset disabled=\"disabled\"><figure><a href=\""+request.getContextPath()+"/article?id="+arr[0]+"\"><img src=\"";
			html += request.getContextPath() + arr[2] + "\" alt=\"\"> </a> <figcaption>";
			html += arr[3] + "</figcaption> </figure> </fieldset> <span class=\"article-prix\"> ";
			html += arr[4] + "€</span></article>";
		}
		return html;
	}
	
//	public Article splitLine(String line) {
//	String[] arr = line.split("\\|");
//	Article a = new Article();
//	a.setDescription(arr[1]);
//	a.setLinkimg(arr[2]);
//	a.setPrice(arr[3]);
//	a.setTitle(arr[4]);
//	return a;
//	}
}
package com.parisventes.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Article {

	private Integer id;
	private String title;
	private String linkimg;
	private String description;
	private Float price;
	private HttpServletRequest request;

	public Article() {

	}

	public String findAll(List<String> allLines) {
		String html = new String();
		for (String line : allLines) {
			Article article = this.splitLine(line);
			html += "<article><h4>";
			html += article.title + "</h4><figure><a href=\"" + this.request.getContextPath() +"/article?id="+article.id+ "\"><img src=\"";
			html += this.request.getContextPath() + article.linkimg+ "\" alt=\"\"></a><figcaption>";
			html += article.description + "</figcaption></figure><span>";
			html += article.price + "€</span></article>";
		}
		return html;
	}
	
	public String findById(List<String> allLines, Integer id) {
		String html = new String();
		for (int i = 0; i < allLines.size(); i++) {

			Article article = this.splitLine(allLines.get(i));
			if (article.id == id) {
				html = "<article><h4>";
				html += article.title + "</h4><figure><img src=\"";
				html += request.getContextPath() + article.linkimg + "\" alt=\"\"><figcaption>";
				html += article.description + "</figcaption></figure><span>";
				html += article.price + "€</span></article>";
				return html;
			}else {
				html = "Aucun article n'existe avec cet identifiant";
			}
		}
		
		return html;
	}
	public Article splitLine(String line) {
		String[] arr = line.split("\\|");
		Article a = new Article();
		a.id = Integer.parseInt(arr[0]);
		a.description = arr[1];
		a.linkimg = arr[2];
		a.title = arr[3];
		a.price = Float.parseFloat(arr[4]);
		return a;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkimg() {
		return linkimg;
	}

	public void setLinkimg(String linkimg) {
		this.linkimg = linkimg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}

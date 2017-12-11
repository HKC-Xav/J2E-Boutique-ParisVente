package com.parisventes.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Article {

	private Integer id;
	private String title;
	private String linkimg;
	private String description;
	private Float price;

	public Article() {

	}

	public String findAll(List<String> allLines) {
		String html = "";
		for (String line : allLines) {
			Article a = this.splitLine(line);
			html = "<article><h4>";
			html += a.description + "</h4><fieldset disabled=\"disabled\"><figure><a href=\"" + request.getContextPath()
					+ "/article?id=" + a.id + "\"><img src=\"";
			html += request.getContextPath() + a.linkimg + "\" alt=\"\"> </a> <figcaption>";
			html += a.price + "</figcaption> </figure> </fieldset> <span class=\"article-prix\"> ";
			html += a.title + "€</span></article> ";
		}
		return html;
	}

	public String findArticle(List<String> allLines, Integer id) {
		String html = "";
		for (String line : allLines) {
			Article a = this.splitLine(line);
			if (id == a.id) {
				html = "<article><h4>";
				html += a.description + "</h4><fieldset disabled=\"disabled\"><figure><a href=\""
						+ request.getContextPath() + "/article?id=" + a.id + "\"><img src=\"";
				html += request.getContextPath() + a.linkimg + "\" alt=\"\"> </a> <figcaption>";
				html += a.price + "</figcaption> </figure> </fieldset> <span class=\"article-prix\"> ";
				html += a.title + "€</span></article> ";
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
		a.price = Float.parseFloat(arr[3]);
		a.title = arr[4];
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

}

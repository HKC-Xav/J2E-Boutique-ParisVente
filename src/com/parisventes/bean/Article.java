package com.parisventes.bean;

import java.util.ArrayList;
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
	
	
	
	public List<Article> findAll(List<String> allLines) {
		List<Article> list = new ArrayList<Article>();
		for (String line : allLines) {
			Article article = this.splitLine(line);
			list.add(article);
		}
		return list;
	}
	
	public Article findById(List<String> allLines, Integer id) {
		Article article = new Article();
		for (String line : allLines) {
			Article art = this.splitLine(line);
			if (art.id == id) {
				article = art;
			}
		}
		return article;
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

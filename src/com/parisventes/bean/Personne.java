package com.parisventes.bean;

import java.util.ArrayList;
import java.util.List;

public class Personne {
	
	public Personne() {}
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	
	public List<Personne> findAll(List<String> allLines) {
		List<Personne> list = new ArrayList<Personne>();
		for (String i : allLines) {
			Personne personne = this.splitLine(i);
			list.add(personne);
		}
		return list;
	}
	
	public Personne findByMail(List<String> allLines, String mail) {
		for (String i : allLines) {
			Personne p = this.splitLine(i);
			if (p.email.equals(mail)) {
				return p;
			}
		}
		return null;
	}
	
	public Personne splitLine(String i) {
		String [] arr = i.split("\\|");
		Personne p = new Personne();
		try {
		p.id = Integer.parseInt(arr[0]);
		p.firstname=arr[1];
		p.lastname=arr[2];
		p.email=arr[3];
		p.phone=arr[4];
		p.password=arr[5];
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



}

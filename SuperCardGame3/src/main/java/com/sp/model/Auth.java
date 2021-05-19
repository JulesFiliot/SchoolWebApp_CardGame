package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Auth {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String password;
	
	public Auth() {
	}

	public Auth(String name, String password) {
		super();
		this.name=name;
		this.password=password;
		
	}
	
	public Auth(int id, String name, String password, int money) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "USER [" + this.id + "]: name:" + this.name;
	}
}

package com.scg.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Auth {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name = "currentAuth";
	
	public Auth(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}

package com.scg.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Auth {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer uid;
	private String name = "currentUser";
	
	public Auth() {
		super();
		this.id=1;
		this.uid=0;
	}
	
	public Auth(Integer uid) {
		super();
		this.id = 1;
		this.uid=uid;
	}
	
	public Integer getId() {
		return this.uid;
	}
	
	public void setId(Integer id) {
		this.uid = id;
	}
}

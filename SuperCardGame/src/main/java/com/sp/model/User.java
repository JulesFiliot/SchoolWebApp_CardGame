package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private int money;
	
	public User() {
	}

	public User(int id, String name, int money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "USER [" + this.id + "]: name:" + this.name + ", Bank account : " + this.money;
	}
}

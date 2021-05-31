package com.scg.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.scg.user.repository.UserRepository;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7614571566539600298L;
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String password;
	private int money;
	
	public User() {
	}

	public User(String name, String password) {
		super();
		this.name=name;
		this.password=password;
		this.money = 500;
		
	}
	
	public User(int id, String name, String password, int money) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.money = money;
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
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "USER [" + this.id + "]: name:" + this.name +", password : "+ this.password +", Bank account : " + this.money;
	}
}

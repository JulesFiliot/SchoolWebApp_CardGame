package com.scg.play.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Play {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private int pari;
	private int IdP1;
	private int IdP2;
	
	
	public Play(String name, Integer pari) {
		super();
		this.name = name;
		this.pari = pari;
		this.IdP1 = 0;
		this.IdP2 = 0;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getPari() {
		return this.pari;
	}
	
	public void setPari(int pari) {
		this.pari = pari;
	}
}

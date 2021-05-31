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
	
	
	public Play() {
	}
	
	public Play(int id, String name, int pari) {
		super();
		this.id = id;
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
	
	
	public Integer getIdP1() {
		return IdP1;
	}

	public void setIdP1(Integer IdP1) {
		this.IdP1 = IdP1;
	}
	
	
	public Integer getIdP2() {
		return IdP2;
	}

	public void setIdP2(Integer IdP2) {
		this.IdP2 = IdP2;
	}
	
	
	@Override
	public String toString() {
		return "Play ["+this.id+"]: name:"+this.name+", pari:"+this.pari;
	}
}

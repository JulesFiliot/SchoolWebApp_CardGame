package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String description;
	private String family;
	private int hp;
	private int energy;
	private int defense;
	private int attack;
	private String imgSrc;
	private int price;
	private Integer ownerId = 0;
	
	public Card() {
	}

	public Card(int id,String name, String description, String family, int hp, int energy, int defense, int attack, String imgSrc,int price, int ownerId) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.family = family;
		this.hp = hp;
		this.energy = energy;
		this.defense = defense;
		this.attack = attack;
		this.imgSrc = imgSrc;
		this.price = price;
		this.ownerId = ownerId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getOwnerId() {
		return this.ownerId;
	}
	
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Card ["+this.id+"]: name:"+this.name+", description:"+this.description+", family:"+this.family+", hp:"+this.hp+", energy:"+this.energy+", defense:"+this.defense+", attack:"+this.attack+" imgSrc:"+this.imgSrc;
	}
}

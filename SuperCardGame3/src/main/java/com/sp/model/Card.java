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
	private String superPowerName;
	private int superPowerValue;
	private String imgUrl;
	private Integer ownerId = 0;
	
	public Card() {
	}

	public Card(int id,String name, String superPowerName, int superPowerValue, String imgUrl, int ownerId) {
		super();
		this.id=id;
		this.name = name;
		this.superPowerName = superPowerName;
		this.superPowerValue = superPowerValue;
		this.imgUrl = imgUrl;
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

	public String getSuperPowerName() {
		return superPowerName;
	}

	public void setSuperPowerName(String superPowerName) {
		this.superPowerName = superPowerName;
	}

	public int getSuperPowerValue() {
		return superPowerValue;
	}

	public void setSuperPowerValue(int superPowerValue) {
		this.superPowerValue = superPowerValue;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Card ["+this.id+"]: name:"+this.name+", superPowerName:"+this.superPowerName+", superPowerValue:"+this.superPowerValue+" imgUrl:"+this.imgUrl;
	}
}

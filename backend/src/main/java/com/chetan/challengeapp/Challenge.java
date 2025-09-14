package com.chetan.challengeapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  id;
	private String month;
	private String description;
	public Challenge(long id, String month, String description) {
		super();
		this.id = id;
		this.month = month;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Challenge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

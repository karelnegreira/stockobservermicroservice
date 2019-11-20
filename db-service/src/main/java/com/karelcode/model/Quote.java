package com.karelcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "quotes")
public class Quote {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
private int id;
	@Column(name = "user_name")
private String username;
	@Column(name = "quote")
private String quote;

	public Quote() {}
	
public Quote(String username2, String quote2) {
	// TODO Auto-generated constructor stub
	this.username = username2;
	this.quote = quote2;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getQuote() {
	return quote;
}
public void setQuote(String quote) {
	this.quote = quote;
}



}

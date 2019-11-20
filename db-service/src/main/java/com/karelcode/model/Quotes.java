package com.karelcode.model;

import java.util.List;

public class Quotes {
	private String userName;
	private List<String>quotes;
	
	
	public Quotes() {
		
	}
	public Quotes(String userName, List<String> quotes) {
		//super();
		this.userName = userName;
		this.quotes = quotes;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	@Override
	public String toString() {
		return "Quotes [username=" + userName + ", quotes=" + quotes + "]";
	}
	
	

}

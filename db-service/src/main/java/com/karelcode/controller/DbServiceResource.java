package com.karelcode.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karelcode.model.Quote;
import com.karelcode.model.Quotes;
import com.karelcode.repo.quotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private quotesRepository quotesRepository;
	public DbServiceResource(quotesRepository quotesRepository) {
		// TODO Auto-generated constructor stub
		this.quotesRepository = quotesRepository;
	}
	
@GetMapping("/{username}")
public List<String>getQuotes(@PathVariable("username")final String username){
 return quotesRepository.findByUsername(username)
	.stream()//lamda functions aggregated in JAVA 8
	.map(Quote::getQuote) 
	.collect(Collectors.toList());
}

private List<String>getQuoteByUserName(@PathVariable("username")String username){
	 return quotesRepository.findByUsername(username)
			.stream()
			.map(Quote::getQuote)
			.collect(Collectors.toList());
}

@PostMapping("/add")
public List<String>add(@RequestBody final Quotes quotes){
	quotes.getQuotes()
	.stream()
	.map(quote->new Quote(quotes.getUsername(), quote))
	.forEach(quote->quotesRepository.save(quote));
	return getQuoteByUserName(quotes.getUsername());
}

@PostMapping("/delete/{username}")
public List<String>delete(@PathVariable("username")final String username)
{
List<Quote>quotes = quotesRepository.findByUsername(username);
int id = 0;
for(int counter = 0; counter<quotes.size(); counter++) {
 id = quotes.get(counter).getId();
quotesRepository.deleteById(id);
}
return getQuoteByUserName(username);
}
}

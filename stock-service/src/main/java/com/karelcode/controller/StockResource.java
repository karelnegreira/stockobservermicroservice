package com.karelcode.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.karelcode.controller.StockResource.Quote;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

@RestController
@RequestMapping("rest/stock")
public class StockResource {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{username}")
	public List<Quote> getStock(@PathVariable("username")final String username){
		ResponseEntity<List<String>>quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + username, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<String>>() {
				});
		List<String> quotes = quoteResponse.getBody();
		return quotes
		.stream()
		.map(quote->{
			Stock stock = getStockPrice(quote);
			return new Quote(quote, stock.getQuote().getPrice());
		})
		.collect(Collectors.toList());
	}
	
	private Stock getStockPrice(String quote) {
		try {
			return YahooFinance.get(quote);//retrieve values of stock from Yahoo Finance API
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Stock(quote);//returns empty
		}
	}
	/**/
	private class Quote{
		private String quote;
		private BigDecimal price;
		public Quote() {}
		public Quote(String quote, BigDecimal price) {
			this.quote = quote;
			this.price = price;
		}
		public String getQuote() {
			return quote;
		}
		public void setQuote(String quote) {
			this.quote = quote;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Quote [quote=" + quote + ", price=" + price + "]";
		}
		
		
		
	}

}

package com.payconique.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payconique.demo.controller.def.StockReturn;
import com.payconique.demo.controller.service.StockService;

@RestController
public class StackController {
	
	
	/* GET /api/stocks (get a list of stocks)
	POST /api/stocks (create a stock)
	GET /api/stocks/1 (get one stock from the list)
	PUT /api/stocks/1 (update the price of a single stock)*/
	
	@Autowired
	public StockService stockService;
	
	@GetMapping(value = "/api/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockReturn> getAllStocks() {
		
		return stockService.findAllListOfStocks();		
	}
	
	@PostMapping(value = "/api/stocks", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addStock(StockReturn stockInput) {
		stockService.insertStock(stockInput);
	}
	
	@GetMapping(value = "/api/stocks/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public StockReturn getStockById(@PathVariable("id") Long id) {
		return stockService.findByStockId(id);
	}
	
	@PutMapping(value = "/api/stocks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateStock(@PathVariable("id") Long id
			, @RequestParam(name = "stockPrice", required = false) Double stockPrice) {
		return stockService.updateStock(id, stockPrice);
	}

}

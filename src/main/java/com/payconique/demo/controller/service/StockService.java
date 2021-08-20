package com.payconique.demo.controller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.payconique.demo.controller.def.StockReturn;
import com.payconique.demo.controller.model.StockEntity;
import com.payconique.demo.controller.model.StockJpaRepository;

@Service
public class StockService {
	
	private final StockJpaRepository stockJpaRepo;
	
	public StockService(StockJpaRepository stockJpaRepo) {
		super();
		this.stockJpaRepo = stockJpaRepo;
	}

	public List<StockReturn> findAllListOfStocks(){
		
		List<StockReturn> stockObtained  = new ArrayList<StockReturn>();
		
		stockJpaRepo.findAll().stream()
			.map(d -> {
				stockObtained.add(StockReturn.builder()
				.id(d.getStockId())
				.name(d.getName())
				.currentPrice(d.getCurrentPrice())
				.lastUpdate(d.getLastUpdate())
				.build());
				return d;
			}).collect(Collectors.toList());
		
		return stockObtained;
	}

	public void insertStock(StockReturn stockInput) {		
		StockEntity newStockEntry = StockEntity.builder()
		.stockId(stockInput.getId())
		.name(stockInput.getName())
		.currentPrice(stockInput.getCurrentPrice())
		.lastUpdate(stockInput.getLastUpdate())
		.build();
		
		stockJpaRepo.saveAndFlush(newStockEntry);
	}

	public StockReturn findByStockId(Long id) {
		StockEntity obtainedStockEntity  = stockJpaRepo.findById(id).get();
		
		return StockReturn.builder()
		.id(obtainedStockEntity.getStockId())
		.name(obtainedStockEntity.getName())
		.currentPrice(obtainedStockEntity.getCurrentPrice())
		.lastUpdate(obtainedStockEntity.getLastUpdate())
		.build();
	}

	public boolean updateStock(Long id , Double stockPrice) {
		
		StockEntity obtainedStockEntity  = stockJpaRepo.findById(id).get();
		
		if(Objects.nonNull(obtainedStockEntity)) {
			obtainedStockEntity.setCurrentPrice(stockPrice);
			stockJpaRepo.saveAndFlush(obtainedStockEntity);
			return true;
		}
		
		return false;		
	}
}

package com.payconique.demo.controller.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {

	
	
	//@Query("select s from STOCK s")
	//public List<StockEntity> findAllStocks();
}

package com.payconique.demo.controller.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "STOCK")
//@NamedQuery(name = "STOCK.findAll", query = "SELECT s FROM STOCK s")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StockEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id       
    @Column(name = "id")
	protected Long stockId;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "CURRENT_PRICE")
	protected Double currentPrice;
	
	@Column(name = "LAST_UPDATE")
	protected Date lastUpdate;
}

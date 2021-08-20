package com.payconique.demo.controller.def;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id" })
@JsonSerialize(as = StockReturn.class)
public class StockReturn {
	
	protected Long id;
	
	protected String name;
		
	protected Double currentPrice;
		
	protected Date lastUpdate;
}

package com.example.ITBook.domain;

import java.util.List;

import lombok.Data;

@Data
public class PayInfo {
	
	private List<Long> isbn;
	private List<Integer> quantity;
	private List<Integer> price;
	private List<String> thumb;
	private List<String> theme;
	
	private int genreCnt;
	private int totalCnt;
	private int totalMil;
	private int totalFee;
	private int delivery;

}

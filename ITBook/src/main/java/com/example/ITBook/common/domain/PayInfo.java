package com.example.ITBook.common.domain;

import java.util.List;

import lombok.Data;

/*
 * 다중 건  결제 정보
 * */

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

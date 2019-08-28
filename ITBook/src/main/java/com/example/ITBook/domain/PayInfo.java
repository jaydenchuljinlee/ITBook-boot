package com.example.ITBook.domain;

import java.util.List;

import lombok.Data;

@Data
public class PayInfo {
	
	private List<Long> isbn;
	private List<Long> quantity;
	private int genreCnt;
	private int totalCnt;
	private int totalMil;
	private int totalFee;
	private int delivery;

}

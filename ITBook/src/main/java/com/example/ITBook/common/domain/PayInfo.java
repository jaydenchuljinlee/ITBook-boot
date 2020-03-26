package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 다중 건  결제 정보
 * */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
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

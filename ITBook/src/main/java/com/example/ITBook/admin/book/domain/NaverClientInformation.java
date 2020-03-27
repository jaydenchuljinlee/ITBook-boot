package com.example.ITBook.admin.book.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 네이버 크롤링 클라이언트 정보
* */
public class NaverClientInformation {

	private static final String clientID = "e90Jx0pP7AhAib2iVaiR";
	private static final String clientSecret = "FPpwynOGlO";
	private String queryUrl = "https://openapi.naver.com/v1/search/book_adv.xml?d_isbn=";
	
	UrlInformation urlinformation;

	public NaverClientInformation(String isbn) throws Exception {
		this.queryUrl += isbn; 
		this.urlinformation = new UrlInformation(this.queryUrl, clientID, clientSecret);
	}

	// 도큐먼트 정보
	public String getDocument() throws IOException {

		//도큐먼트 정보를 BufferedReader 형태로 받아옴
		BufferedReader br = new BufferedReader(new InputStreamReader(this.urlinformation.urlConn.getInputStream(),"UTF-8"));
	    
        StringBuffer result = new StringBuffer();
        String msg = null;

        // 한 줄씩 StringBuffer에 담아서 return
        while ((msg = br.readLine()) != null) {
            result.append(msg);
        }
        
        return result.toString();
	}
}

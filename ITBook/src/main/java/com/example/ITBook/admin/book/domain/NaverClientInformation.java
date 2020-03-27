package com.example.ITBook.admin.book.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* ���̹� ũ�Ѹ� Ŭ���̾�Ʈ ����
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

	// ��ť��Ʈ ����
	public String getDocument() throws IOException {

		//��ť��Ʈ ������ BufferedReader ���·� �޾ƿ�
		BufferedReader br = new BufferedReader(new InputStreamReader(this.urlinformation.urlConn.getInputStream(),"UTF-8"));
	    
        StringBuffer result = new StringBuffer();
        String msg = null;

        // �� �پ� StringBuffer�� ��Ƽ� return
        while ((msg = br.readLine()) != null) {
            result.append(msg);
        }
        
        return result.toString();
	}
}

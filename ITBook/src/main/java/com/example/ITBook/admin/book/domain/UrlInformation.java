package com.example.ITBook.admin.book.domain;

import java.net.URL;
import java.net.URLConnection;

/*
* url connection information
* */
public class UrlInformation {
	
	URL url;
	URLConnection urlConn;

	// �޾ƿ� ���̹� Ŭ���̾�Ʈ ������
	public UrlInformation(String queryUrl,String clientID, String clientSecret) throws Exception{
		this.url = new URL(queryUrl);
		this.urlConn = url.openConnection();
		
		this.urlConn.setRequestProperty("X-Naver-Client-ID", clientID);
        this.urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	}
	
	
}

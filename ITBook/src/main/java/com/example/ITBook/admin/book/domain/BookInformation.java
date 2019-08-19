package com.example.ITBook.admin.book.domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;

public class BookInformation {

	String url;
	
	Document document;
	
	String originalTitle;
	StringBuffer translator;
	String page;
	StringBuffer author;
	
	Element content;
	String info;
	String contents;
	String authorInfo;
	
	JsonObject jsonObject;
	
	public BookInformation(String url) throws IOException {
		this.url = url;
		this.document = Jsoup.connect(this.url).timeout(10000).get();
		
		this.author  = new StringBuffer();	
		
		createBookInfo(this.document);
	}
	
	public JsonObject getBookJsonObject() {
		return this.jsonObject;
	}

	private void createBookInfo(Document document) throws IOException {
		
		Elements infoBox = document.select(".book_info_inner");
		Elements originalTitleElements = infoBox.select(".tit_ori");
		
		//저자
		Elements authors = infoBox.select("[class^='N=a:bil.author']");
		
		appendAuthorLoop(authors);
		
		checkForeignBooks(originalTitleElements,infoBox);
		
		creatBookContent(document);
		
		createJsonObejct();
		
	}

	private void createJsonObejct() {
		
		this.jsonObject = new JsonObject();
		
		jsonObject.addProperty("author"			, author.toString());
		jsonObject.addProperty("originalTitle"	, originalTitle);
		jsonObject.addProperty("page"			, page);
		jsonObject.addProperty("info"			, info);
		jsonObject.addProperty("contents"		, contents);
		jsonObject.addProperty("authorInfo"		, authorInfo);
		
				
		if (isTranslatorNull()) {
			jsonObject.addProperty("translator", translator.toString());
		}
		
	}

	private boolean isTranslatorNull() {
		
		return translator != null;
	}

	private void creatBookContent(Document document) throws IOException {

		Element content = document.getElementById("content");
		
		this.info 		= content.select("#bookIntroContent p").html();
		this.contents 	= content.select("#tableOfContentsContent p").html();
		this.authorInfo 	= content.select("#authorIntroContent p").html();
		
	}

	private void checkForeignBooks(Elements originalTitleElements, Elements infoBox) {

		//해외 책인지 아닌지 체크
		
		if (isPresent(originalTitleElements)) {
			//원제
			this.originalTitle = originalTitleElements.first().childNodes().get(1).toString().trim();
			
			appendTranslatorLoog(infoBox);
			
			//페이지
			this.page = infoBox.select(".tit_ori+div").first().childNodes().get(2).toString().trim();
		} else {
			//페이지
			this.page = infoBox.select("div").get(4).childNodes().get(2).toString().trim();
		}
		
	}

	private void appendTranslatorLoog(Elements infoBox) {

		//역자
		this.translator = new StringBuffer();
		Elements translators = infoBox.select("[class^='N=a:bil.translator']");
		
		for (int i = 0; i < translators.size(); i++) {
			
			if (i != 0) {
				this.translator.append(", ");
			}
			
			this.translator.append(translators.get(i).text());
		}
		
	}

	private boolean isPresent(Elements originalTitleElements) {
		
		return originalTitleElements.size() > 0;
	}

	private void appendAuthorLoop(Elements authors) {

		for (int i = 0,loop = authors.size(); i < loop; i++) {
			
			if (i != 0) {
				this.author.append(", ");
			}
			
			this.author.append(authors.get(i).text());
		}
		
	}
	
	
	
}

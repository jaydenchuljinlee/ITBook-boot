package com.example.ITBook.admin.book.domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;

/*
 * isbn ũ�Ѹ� å ����
 * */
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
	
	/*
	 * ������ url�� ���� ũ�Ѹ� å ���� ����
	 * @parma : url
	 * */
	public BookInformation(String url) throws IOException {
		this.url = url;
		this.document = Jsoup.connect(this.url).timeout(10000).get();
		
		this.author  = new StringBuffer();
		
		createBookInfo(this.document);
	}
	
	/*
	 * 
	 * */
	public JsonObject getBookJsonObject() {
		return this.jsonObject;
	}

	/*
	 * ��ť��Ʈ ��ü�� �Ľ��Ͽ� å ���� ����
	 * @param : ��ť��Ʈ ��ü
	 * */
	private void createBookInfo(Document document) throws IOException {
		
		Elements infoBox = document.select(".book_info_inner");
		Elements originalTitleElements = infoBox.select(".tit_ori");
		
		//����
		Elements authors = infoBox.select("[class^='N=a:bil.author']");
		
		appendAuthorLoop(authors);
		
		checkForeignBooks(originalTitleElements,infoBox);
		
		creatBookContent(document);
		
		createJsonObejct();
		
	}

	/*
	 * �Ľ��� ��ť��Ʈ ��ü�� json ��ü�� ��ȯ
	 * */
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

	/*
	 * ��ť��Ʈ ��ü�� �Ľ��Ͽ� info, contents,authorInfo ������ �����
	 * @param : ��ť��Ʈ ��ü
	 * */
	private void creatBookContent(Document document) throws IOException {

		Element content = document.getElementById("content");
		
		this.info 		= content.select("#bookIntroContent p").html();
		this.contents 	= content.select("#tableOfContentsContent p").html();
		this.authorInfo 	= content.select("#authorIntroContent p").html();
		
	}

	/*
	 * ��ť��Ʈ ��ü�� �Ľ��Ͽ� info, contents,authorInfo ������ �����
	 * @param : originalTitleElements(���� å ��ť��Ʈ),infoBox(å ������ ����)
	 * */
	private void checkForeignBooks(Elements originalTitleElements, Elements infoBox) {

		//�ؿ� å���� �ƴ��� üũ
		if (isPresent(originalTitleElements)) {
			//����
			this.originalTitle = originalTitleElements.first().childNodes().get(1).toString().trim();
			
			appendTranslatorLoog(infoBox);
			
			//������
			this.page = infoBox.select(".tit_ori+div").first().childNodes().get(2).toString().trim();
		} else {
			//������
			this.page = infoBox.select("div").get(4).childNodes().get(2).toString().trim();
		}
		
	}

	/*
	 * å ������ ���� ���� ���� ���� �Ľ�
	 * @param : infoBox(å ������ ����)
	 * */
	private void appendTranslatorLoog(Elements infoBox) {

		//����
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

	/*
	 * ���� ������ stringBuffer�� ,�� �����ڷ��ؼ� �߰�
	 * @param : authors(���� ����)
	 * */
	private void appendAuthorLoop(Elements authors) {

		for (int i = 0,loop = authors.size(); i < loop; i++) {
			
			if (i != 0) {
				this.author.append(", ");
			}
			
			this.author.append(authors.get(i).text());
		}
		
	}
	
	
	
}

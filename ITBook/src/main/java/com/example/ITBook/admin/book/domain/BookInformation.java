package com.example.ITBook.admin.book.domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;

/*
 * isbn 크롤링 책 정보
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
	 * 가져온 url을 통해 크롤링 책 정보 생성
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
	 * 도큐먼트 객체를 파싱하여 책 정보 생성
	 * @param : 도큐먼트 객체
	 * */
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

	/*
	 * 파싱한 도큐먼트 객체를 json 객체로 변환
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
	 * 도큐먼트 객체를 파싱하여 info, contents,authorInfo 변수에 담아줌
	 * @param : 도큐먼트 객체
	 * */
	private void creatBookContent(Document document) throws IOException {

		Element content = document.getElementById("content");

		this.info 		= content.select("#bookIntroContent p").html();
		this.contents 	= content.select("#tableOfContentsContent p").html();
		this.authorInfo 	= content.select("#authorIntroContent p").html();

	}

	/*
	 * 도큐먼트 객체를 파싱하여 info, contents,authorInfo 변수에 담아줌
	 * @param : originalTitleElements(원본 책 도큐먼트),infoBox(책 콘텐츠 정보)
	 * */
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

	/*
	 * 책 콘텐츠 정보 내에 역자 정보 파싱
	 * @param : infoBox(책 콘텐츠 정보)
	 * */
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

	/*
	 * 저자 정보를 stringBuffer에 ,를 구분자로해서 추가
	 * @param : authors(저자 정보)
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

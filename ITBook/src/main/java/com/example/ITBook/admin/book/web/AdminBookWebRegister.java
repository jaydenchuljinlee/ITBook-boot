package com.example.ITBook.admin.book.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ITBook.admin.book.domain.NaverClientInformation;
import com.google.gson.JsonObject;

@Controller
public class AdminBookWebRegister {

	@RequestMapping(value= "adminBookRegister")
	public String adminBookRegister() throws Exception {
		
		return "book/bookRegister.adminTiles";
	}
	
	@RequestMapping(value= "adminBookSearch", produces = "application/xml; charset=utf8")
	@ResponseBody
	public String adminBookSearch(@RequestParam String isbn) throws Exception {

		NaverClientInformation naverDocument = new NaverClientInformation(isbn);

        return naverDocument.getDocument();
	}
	
	/**
	 * å �� ���� ��������
	 * @param url : ���̹� å �� ������ url
	 * @return : �� ���� JSON
	 * @throws Exception
	 */
	@RequestMapping(value= "adminBookSearchDetail", produces = "application/json; charset=utf8")
	@ResponseBody
	public String adminBookSearchDetail(@RequestParam String url) throws Exception {
		Document document = Jsoup.connect(url).timeout(10000).get();
		
		String originalTitle 	= null;
		StringBuffer translator = null;
		String page 			= null;
		StringBuffer author 	= new StringBuffer();
		
		Elements infoBox = document.select(".book_info_inner");
		Elements originalTitleElements = infoBox.select(".tit_ori");
		
		//����
		Elements authors = infoBox.select("[class^='N=a:bil.author']");
		
		for (int i = 0; i < authors.size(); i++) {
			
			if (i != 0) {
				author.append(", ");
			}
			
			author.append(authors.get(i).text());
		}
		
		//�ؿ� å���� �ƴ��� üũ
		if (originalTitleElements.size() > 0) {
			//����
			originalTitle = originalTitleElements.first().childNodes().get(1).toString().trim();
			
			//����
			translator = new StringBuffer();
			Elements translators = infoBox.select("[class^='N=a:bil.translator']");
			
			for (int i = 0; i < translators.size(); i++) {
				
				if (i != 0) {
					translator.append(", ");
				}
				
				translator.append(translators.get(i).text());
			}
			
			//������
			page = infoBox.select(".tit_ori+div").first().childNodes().get(2).toString().trim();
		} else {
			//������
			page = infoBox.select("div").get(4).childNodes().get(2).toString().trim();
		}
		
		Element content = document.getElementById("content");
		
		String info 		= content.select("#bookIntroContent p").html();
		String contents 	= content.select("#tableOfContentsContent p").html();
		String authorInfo 	= content.select("#authorIntroContent p").html();
		
		String reviewUrl = url.replace("book_detail.php", "publisher_review.nhn");
		Document reviewDocument = Jsoup.connect(reviewUrl).timeout(10000).get();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("author"			, author.toString());
		jsonObject.addProperty("originalTitle"	, originalTitle);
		jsonObject.addProperty("page"			, page);
		jsonObject.addProperty("info"			, info);
		jsonObject.addProperty("contents"		, contents);
		jsonObject.addProperty("authorInfo"		, authorInfo);
		
		if (translator != null) {
			jsonObject.addProperty("translator", translator.toString());
		}
		
		return jsonObject.toString();
	}
}

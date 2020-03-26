# 책 관련 정보
책 객체 생성, 책 정보 등록, 책 정보 조회, 책 정보 변경

객체 생성
------------

- 책 정보를 등록하기 위해 mapping할 책 객체를 
```java

package com.example.ITBook.common.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

/*
 * 책 정보 DB 테이블
 * */
@NoArgsConstructor @AllArgsConstructor @Builder
@Data @EqualsAndHashCode(callSuper = false)
@Entity @Table(name = "book")
public class Book  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition = "BIGINT",length = 21)
	private Long isbn;
	
	@Column(columnDefinition = "INT",length = 11)
	private int price;
	@Column(columnDefinition = "INT",length = 11)
	private int page;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scode")
	private Scategory s_category;
	
	@Size(max = 11)
	private int quantity;
	
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String image;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String theme;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String original;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String publish;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String author;
	@Column(columnDefinition = "VARCHAR",length = 50)
	private String translator;
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime publishdate;
	
	@Column(columnDefinition = "TEXT")
	private String intro;
	@Column(columnDefinition = "TEXT")
	private String contents;
	@Column(columnDefinition = "TEXT")
	private String authorinfo;
}
```

책 정보 등록
------------

- 책 정보는 네이버 책 서비스의 크롤링을 통해 가져왔습니다.
- 순서는 책을 관리하는 페이지에서 isbn에 대한 요청 
  -> 네이버 클라이언트 정보를 가지고 네이버 책 서비스 검색 
  -> 검색 결과를 Document 형식의 JSON String 객체로 리턴
  -> 상세정보를 다시 검색하기 위해 검색했던 URL 정보를 가지고 다시 검색
  -> 상세정보 관련 Document 형식의 JSON String 객체를 리턴
  -> 정보를 종합하여 앞의 책 객체에 등록
- 먼저 책 관리 Controller 입니다. [AdminBookWebRegister.java]

```java

package com.example.ITBook.admin.book.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ITBook.admin.book.domain.BookInformation;
import com.example.ITBook.admin.book.domain.NaverClientInformation;
import com.example.ITBook.admin.book.service.AdminBookService;
import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.exception.BookIsbnDuplicationException;
import com.example.ITBook.common.exception.BookIsbnNotFoundException;
import com.example.ITBook.common.exception.FailedConnectionException;

/*
* 책 등록 관련 컨트롤러
* */
@Controller
@SessionAttributes("user")
@RequestMapping("/admin/book")
public class AdminBookWebRegister {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookWebRegister.class);
	
	@Autowired
	private AdminBookService adminBookService;

	/*
	 * @info	: 책 등록 메인 페이지
	 * */
	@RequestMapping(value= "/register")
	public String adminBookRegister() throws Exception {

		return "book/bookRegister.adminTiles";
	}

	/**
	 * 책 검색 크롤링
	 * @param isbn : 검색한 isbn
	 * @return : 크롤링한 도큐먼트
	 * @throws Exception
	 */
	@RequestMapping(value= "/search", produces = "application/xml; charset=utf8")
	@ResponseBody
	public String adminBookSearch(@RequestParam String isbn) throws Exception{

		NaverClientInformation naverDocument = new NaverClientInformation(isbn);

		/*
		 * if (naverDocument.getDocument() == null) {
		 *
		 * throw new BookIsbnNotFoundException(isbn); }
		 */

		return naverDocument.getDocument();

	}

	/**
	 * 책 상세 정보 가져오기
	 * @param url : 네이버 책 상세 페이지 url
	 * @return : 상세 정보 JSON
	 * @throws Exception
	 */
	@RequestMapping(value= "/search/detail", produces = "application/json; charset=utf8")
	@ResponseBody
	public String adminBookSearchDetail(@RequestParam String url) throws Exception{

		BookInformation bookInfo = new BookInformation(url);

		return bookInfo.getBookJsonObject().toString();

	}

	/**
	 * 책 검색 크롤링
	 * @param book : 책 객체, category1 : 대분류, category2 : 소분류, hash : 해시태그
	 * @return : 해당페이지 redirect + 등록 여부
	 * @throws Exception
	 */
	@RequestMapping(value = "/register/success",method = RequestMethod.POST)
	public String BookRegisterSuccess(@ModelAttribute Book book,
									  @RequestParam long category1
			,@RequestParam long category2
			,@RequestParam(required=false) List<Long> hash
			,Model model) throws Exception{

		if (adminBookService.selectBookByIsbn(book).isPresent()) {
			throw new BookIsbnDuplicationException(book.getIsbn().toString());
		}

		adminBookService.insertBook(book,category1,category2,hash);

		return "redirect:adminBookMain";
	}

	/*
	 * @info	: 책 등록 공통 부분인 부모 카테고리 리스트
	 * 
	 *  */
	@ModelAttribute("categoryList_1")
	public List<Bcategory> categoryList_1(ModelMap model) throws Exception {
		return adminBookService.selectParentCategoryList();
	}
}
```
- Controller에서 네이버 책 서비스를 검색할 로직을 Class화 시켜 놨습니다.
- [NaverClientInformation.java]
```java

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


```

- [UrlInformation.java]
```java

package com.example.ITBook.admin.book.domain;

import java.net.URL;
import java.net.URLConnection;

/*
* url connection information
* */
public class UrlInformation {
	
	URL url;
	URLConnection urlConn;

	// 받아온 네이버 클라이언트 데이터
	public UrlInformation(String queryUrl,String clientID, String clientSecret) throws Exception{
		this.url = new URL(queryUrl);
		this.urlConn = url.openConnection();
		
		this.urlConn.setRequestProperty("X-Naver-Client-ID", clientID);
        this.urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	}
	
	
}


```

- [BookInformation.java]
```java

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


```


책 관련 정보
-
책 객체 생성, 책 정보 등록, 책 정보 조회, 책 정보 변경

책 정보 변경
-
- 책정보를 변경하기 위해 책 객체와 상위 카테고리/하위 카테고리 정보를 가져 와서
  -> service에서 업데이트할 정보를 처리하고
  -> repository를 통해 기존에 저장 돼있는 책 객체를 지우고 다시 저장해줍니다.(JPA 기본 특성상 update가 따로 지원해주지 않기 때문에 고칠 예정)
  
- 책 관리 -> 상세보기 or 정보변경 controller [AdminBookWebRegister.java] 
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
- 책 관리 -> 상세보기 or 정보변경 service [AdminBookDetailServiceImpl.java] 
```java

package com.example.ITBook.admin.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ITBook.admin.book.repository.AdminBigCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookCategoryRepository;
import com.example.ITBook.admin.book.repository.AdminBookHashtageRepository;
import com.example.ITBook.admin.book.repository.AdminBookRegisterRepository;
import com.example.ITBook.admin.book.repository.AdminBookRepository;
import com.example.ITBook.admin.book.repository.AdminSmallCategoryRepository;
import com.example.ITBook.common.domain.Bcategory;
import com.example.ITBook.common.domain.Book;
import com.example.ITBook.common.domain.pk.BookCategoryPK;
import com.example.ITBook.common.domain.Bookcategory;
import com.example.ITBook.common.domain.Scategory;
import com.example.ITBook.common.domain.pk.CategoryPK;

@Service
public class AdminBookDetailServiceImpl implements AdminBookDetailService {
	private static final Logger logger = LoggerFactory.getLogger(AdminBookDetailServiceImpl.class);
	
	@Autowired
	private AdminBigCategoryRepository bCategoryRepository;
	@Autowired
	private AdminSmallCategoryRepository sCategoryRepository;
	@Autowired
	private AdminBookRegisterRepository bookRegisterRepository;
	@Autowired
	private AdminBookCategoryRepository bookCategoryRepository;
	@Autowired
	private AdminBookHashtageRepository bookHashtageRepository;
	@Autowired
	private AdminBookRepository adminBookRepository;
	
	/*
	 * @param 			:  isbn(책 번호)
	 * @return			: 등록 성공 여부
	 * @isBook()		: 책이 등록 되어 있는지 검사, map(성공 여부), book(책 객체)
	 * @createMapData	: 책 등록, map, book, category1, category2
	 */
	@Override
	public Map<String, Object> selectBookAndCategory(long isbn) throws Exception {
		
		//책 등록 성공 여부
		Map<String, Object> map =  new HashMap<String, Object>();
		
		Optional<Book> book = bookRegisterRepository.findById(isbn);
		
		//책이 DB에 저장 되어 있는지 검사
		if (isBook(map,book)) {
			
			Bcategory parent = book.get().getS_category().getBcategory(); 
			
			List category1 = bCategoryRepository.findAll();
			
			List category2 = sCategoryRepository.findByBcategory(parent);
			
			//저장 되어 있을 시, 책 등록
			createMapData(map,book,category1,category2);
		}
		
		return map;
	}
	
	/*
	 * @param 			:  map(등록 성공 여부), book(책 객체)
	 * @return			: 등록 성공 여부
	 */
	private boolean isBook(Map<String, Object> map, Optional<Book> book) {
		
		return book.isPresent();
	}

	/*
	 * @param 			:  map(등록 성공 여부), book(책 객체) , category1(부모 카테), category2(자식 카테)
	 */
	private void createMapData(Map<String, Object> map, Optional<Book> book, List category1, List category2) {

		map.put("book", book.get());
		map.put("b_category", book.get().getS_category().getBcategory());
		map.put("s_category", book.get().getS_category());
		map.put("category1", category1);
		map.put("category2", category2);
		
	}
	
	/*
	 * @param 				: book(책 객체) , category1(부모 카테), category2(자식 카테)
	 * 							, isChangeB(책 변경 여부), isChangeC(카테고리 변경 여부)
	 * @categoryCreate()	: 카테고리 확인을 위한 카테고리 생성 메서드
	 * @selectRepository()	: 책과 카테고리 조회 후 업데이트
	 */
	@Override
	public void updateBookInfo(Book book, long category1, long category2,boolean isChangeB,boolean isChangeC) throws Exception {
		
		BookCategoryPK categoryInfo = new BookCategoryPK(book.getIsbn(),category2);
		
		Scategory child = categoryCreate(category1,category2);
		
		selectRepository(book,categoryInfo,child,isChangeB,isChangeC);
		
	}

	/*
	 * @param 					: book(책 객체) ,categoryInfo(카테고리 정보), child(자식 카테 객체)
	 * 								, isChangeB(책 변경 여부), isChangeC(카테고리 변경 여부)
	 * @OnlyChangeCategory()	: 카테고리만 변경 여부
	 * @OnlyChangeBook()		: 책만 변경 여부
	 * @repositorySave()		: 책과, 카테고리 저장
	 * @setBookCategory()		: 책 저장을 위해 책 객체에 카테고리 정보를 입력
	 */
	private void selectRepository(Book book, BookCategoryPK categoryInfo, Scategory child, boolean isChangeB,
			boolean isChangeC) {

		if(OnlyChangeCategory(isChangeB,isChangeC)) {
			
			bookCategoryRepository.deleteByBook(book);
			
			Bookcategory bookCategory = setBookCategory(book,child);
			
			bookCategoryRepository.saveAndFlush(bookCategory);
			
		} else if(OnlyChangeBook(isChangeB,isChangeC)) {
			
			adminBookRepository.saveAndFlush(book);
		} else {
			
			bookCategoryRepository.deleteByBook(book);
			
			Bookcategory bookCategory = setBookCategory(book,child);
			
			repositorySave(book,bookCategory);
		}
		
	}

	private boolean OnlyChangeBook(boolean isChangeB, boolean isChangeC) {
		
		return isChangeB && !isChangeC;
	}

	private boolean OnlyChangeCategory(boolean isChangeB, boolean isChangeC) {
		
		return !isChangeB && isChangeC;
	}

	private void repositorySave(Book book, Bookcategory bookCategory) {
		
		bookCategoryRepository.save(bookCategory);

		adminBookRepository.saveAndFlush(book);
		
	}

	private Bookcategory setBookCategory(Book book, Scategory child) {

		book.setS_category(child);
		
		return new Bookcategory(book,child);
	}

	private Scategory categoryCreate(long category1, long category2) {
		
		Bcategory bcategory = Bcategory.builder()
										.code(category1)
										.build();
		
		return Scategory.builder()
						.code(category2)
						.bcategory(bcategory)
						.build();
	}
}
```



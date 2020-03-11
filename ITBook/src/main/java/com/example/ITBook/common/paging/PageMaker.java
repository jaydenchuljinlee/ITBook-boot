package com.example.ITBook.common.paging;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	@Autowired
	private SearchCriteria criteria;
	
	public String makeSearch(int page) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum",criteria.getPerPageNum())
				.queryParam("searchType",((SearchCriteria) criteria).getSearchType())
				.queryParam("keyword", encoding(((SearchCriteria) criteria).getKeyword()))
				.build();
		
		return uriComponents.toUriString();
	}
	
	private String encoding(String keyword) {

		if (keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			return "";
		}
		
	}

	private void calcData() {

		this.endPage = (int) (Math.ceil(this.criteria.getPage() / (double) this.displayPageNum) * this.displayPageNum);
		
		this.startPage = (endPage - displayPageNum) +1;
		
		int tempEndPage = (int) (Math.ceil(this.totalCount / (double) this.criteria.getPerPageNum()));
		
		if (this.endPage > tempEndPage) {
			this.endPage = tempEndPage;
		}
	
		this.prev = this.startPage == 1 ? false : true;
		
		this.next = this.endPage * this.criteria.getPerPageNum() >= this.totalCount ? false : true;
	}
	
	public void setCriteria(SearchCriteria criteria) {
		
		this.criteria = criteria;
	} 
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public SearchCriteria getCriteria() {
		return criteria;
	}
	
	
}
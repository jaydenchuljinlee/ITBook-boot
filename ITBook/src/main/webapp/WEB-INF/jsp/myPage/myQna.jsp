<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">

<div class="product-grid-holder tc-padding2">
	<div class="row">
		<div class="myItbook_wrap">
		
		 	 <!-- 마이페이지 카테고리  -->
			<div class="lft_sec_mypage">
				<ul class="txt_tab_menu mypage-tab">
					<li><a href="myPage.do">마이페이지</a></li>
					<li><a href="gradeInfo.do">등급별 혜택</a></li>
					<li><a href="myMileage.do">마일리지</a></li>
				    <li><a href="myBasket.do">장바구니</a></li>
					<li><a href="wishList.do">위시리스트</a></li>
					<li><a href="buyList.do">구매/주문 내역</a></li>	
					<li><a href="myQna.do">1:1문의 내역</a></li>					
				    <li><a href="modifyCheckPassword.do">개인정보 수정</a></li>
				</ul>
			</div>
			<!-- 마이페이지 카테고리  -->
		
			<!-- 마일리지 탭 -->
			<div class="tabmenu">
				<ul>
					<li class="left"><i class="fas fa-clipboard-list"></i> 1:1 문의 내역 </li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
			
			<table class="tbl_type_list">
				<thead class="tbl_type_list_thead">
					<tr>
						<th scope="col">문의일자</th>
						<th scope="col">문의종류</th>
						<th scope="col">제목</th>
						<th class="last" scope="col">처리상태</th>
					</tr>
				</thead>
				<tbody class="tbl_type_list_tbody">
						<c:forEach items="${oneAskList}" var="oneAsk">
							<tr>
								<td>${oneAsk.q_date_create}</td>
								<td>${oneAsk.q_type}</td>
								<td id="<c:out value="${oneAsk.question_NO}"/>">
								  <a href="oneAskDetail.do">${oneAsk.q_title}</a>
								</td>
								<td>처리중</td>
							</tr>		
						</c:forEach>						
				</tbody>
			</table>
			
			<!-- // 내역 리스트 -->	
		
		
		</div>
	</div>
</div>
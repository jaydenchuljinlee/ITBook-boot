<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
			<div class="tabmenu" id="my_mileage">
				<ul>
					<li class="left"><i class="fas fa-list-alt"></i> 구매/주문 내역 </li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
			
			<table class="tbl_type_list">
				<thead class="tbl_type_list_thead">
					<tr>
						<th scope="col">주문번호</th>
						<th scope="col">주문일자</th>
						<th scope="col">상품명</th>
						<th scope="col">주문금액</th>
						<th class="last" scope="col">주문 상태</th>
					</tr>
				</thead>
				<tbody class="tbl_type_list_tbody">
						<tr>
						<td>1111111</td>	
						<td>2018-03-02</td>
						<td>토비의 스프링 3.1 세트</td>
						<td>30,000원</td>
						<td>배송완료</td>
						</tr>		
												
				</tbody>
			</table>
			
			<!-- // 내역 리스트 -->	
		
		
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">
<script type="text/javascript">
	$(function(){
		
		$(".delete_myBasket").on("click",function() {
			var that = this,
			isbn =$(this).closest("tr").children(".check_area").children().children().val();
		
			$.ajax({
				type		: "post",
				url 		: "deleteMyBasket",
				contentType	: "application/json",
				data		: isbn,
				successs	: function(data) {
					
					console.log(data.result);
					$(that).closest("tr").remove();
				},
				error		: function(error) {
					console.log(error);
				}
			})
			
		});
	})
</script>
<script type="text/javascript" src="/ITBook/js/myPage/myBasket.js">

</script>

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
					<li class="left"><i class="fas fa-shopping-cart" style="font-size: 30px;"></i> 장바구니</li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
			
		<!-- 주문배송 조회 -->
		<div class="myBasket-step smf_l">
              <hr>
				<ul class="mypage-step">
					<li><em><i class="fas fa-shopping-cart" style="font-size: 50px; color: #fe981e"></i></em> <span>장바구니</span></li>
					<li><em><i class="far fa-credit-card" style="font-size: 50px;"></i></em> <span>주문결제</span></li>
					<li><em><i class="fas fa-child" style="font-size: 50px;"></i></em> <span>주문완료</span></li>
				</ul>
			</div>
		<!-- //주문배송 조회 -->
		
		
		
		<!-- 선택영역 -->
		<div class="select_area2">
			<div class="check_area">
				<label for="check_select">
					<input class="i_check parent_chk" type="checkbox" id="checkAll" name="checkAll">
					<strong>전체선택</strong>
				</label>
			</div>
		</div>
		<!-- //선택영역 -->		
		
		<!-- 장바구니 리스트 -->
		<form id="myBasketFrm" action="payment" method="post">
		
		<div class="table_area_cart">
			<table class="tbl_type_list" summary="장바구니 리스트 테이블">
				<caption>장바구니 리스트</caption>
				<colgroup>
				<col width="">
				<col width="">
				<col width="">
				<col width="140px">
				<col width="130px">
				<col width="130px">
				<col width="90px">
				</colgroup>
				<thead>
					<tr>
						<th colspan="3" scope="col">상품명</th>
						<th scope="col">판매가</th>
						<th scope="col">수량</th>
						<th scope="col">합계</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${myBasketList}" var="myBasket" varStatus="status">
						<tr>
							<td class="check_area" data-idx = ${status.index}>
								<label for="check_select">
									<input id="isbn_${status.index}" class="i_check child_chk" type="checkbox" name="isbn" value="${myBasket.book.isbn}" />
								</label>
							</td>
							<td class="thumb_area">
								<input type="hidden" id="thumb_${status.index}" name="thumb" value="${myBasket.book.image}" >
								<img src="<c:out value="${myBasket.book.image}" />" alt="" class="thumb" /></td>
							<td class="left info">
								<input type="hidden" id="theme_${status.index}" name="theme" value="${myBasket.book.theme}">
								<p class="txt_nomal"><c:out value="${myBasket.book.theme}" /></p>
							</td>
							<td>
								<input type="hidden" id="price_${status.index}" name="price" value="${myBasket.book.price}">
								<p class="price" data-price="${myBasket.book.price}"><fmt:formatNumber value="${myBasket.book.price}" pattern="#.###" />원
								<span class="mileage"></span>								
							</td>
							<td>
							 <label class="option_label">
							 	<input id="quantity_${status.index}" value=1 name="quantity" class="i_text"/>
							 </label>																				
							</td>
							<td class="price2"><fmt:formatNumber value="${myBasket.book.price}" pattern="#.###" />원</td>
							<td><a class="delete_myBasket"><i class="fas fa-trash-alt delete"></i></a></td>
						</tr>
					</c:forEach>									
				</tbody>
			</table>
		</div>
		
		<!-- //장바구니 리스트 -->
		<!-- 장바구니 합계 -->
						
		
		<div class="cart_result_box">
			<ul>
				<li>주문상품 수량 :   <span id='buyCnt'>2종 [2개]</span>
					<input type="hidden" id="genreCnt" name="genreCnt"/>
					<input type="hidden" id="totalCnt" name="totalCnt"/>
				</li>
				<li>예상 마일리지 적립 :  <span id='totalMileage'>404점</span>
					<input type="hidden" id="totalMil" name="totalMil"/>
				</li>
				<li>배송료 :  <span id='deliveryCost'>0원</span>
					<input type="hidden" id="delivery" name="delivery"/>
				</li>
				<li>총 상품 금액 :  <span class="price" id='totalPrice'>40,400원</span>
					<input type="hidden" id="totalFee" name="totalFee"/>
				</li>
			</ul>
		</div>
		
		<div class="btn_area_cart">
			<!--<a href="/myhanbit/order_payment.html" class="btn_green">주문하기</a> -->
			<button id="submitBtn"  class="btn_green" style="height:50px">주문하기
		</div>		
		</form>
		<!-- 장바구니 버튼 -->						
	</div>
	<!-- //마이한빛 wrap -->
     </div>
  </div>
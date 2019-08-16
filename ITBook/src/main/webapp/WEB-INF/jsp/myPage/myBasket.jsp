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
					<input class="i_check" type="checkbox" id="checkAll" name="checkAll" value="" checked>
					<strong>전체선택</strong>
				</label>
			</div>
			<label>
				<button name="" type="submit" value="선택항목 삭제하기" class="btn_remove">선택상품삭제</button>
			</label>
			<label>
				<button name="" type="submit" value="선택항목 위시리스트 담기" class="btn_basket">선택상품보관</button>
			</label>
		</div>
		<!-- //선택영역 -->		
		
		<!-- 장바구니 리스트 -->
		<form name="frm" id="frm" action="payment.do" method="post">
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
								
					<tr>
						<td class="check_area">
							<label for="check_select">
								<input class="i_check" type="checkbox" name="checked_isbn_1" value="9788979149883" checked>
							</label>
						</td>
						<td class="thumb_area"><a href="#"><img src="http://image.kyobobook.co.kr/images/book/large/125/l9791188621125.jpg" alt="" class="thumb" /></a></td>
						<td class="left info">
							<p class="txt_nomal"><a href="/store/books/look.php?p_code=B2901427500">알고리즘 도감 그림으로 공부하는 알고리즘 26</a></p>
						</td>
						<td>
							<p class="price">23,400원
							<span class="mileage">234점</span>								
						</td>
						<td>						
						 <label class="option_label"><input type="text" value="1" name="quantity_isbn_1" class="i_text" maxlength="2"></label>																				
						</td>
						<td class="price2">23,400원</td>
						<td><a href="#" class=""><i class="fas fa-trash-alt delete"></i></a></td>
					</tr>
								
					<tr>
						<td class="check_area">
							<label for="check_select">
								<input class="i_check" type="checkbox" name="checked_isbn_3" value="9788968480799" checked>
							</label>
						</td>
						<td class="thumb_area">
						<a href="">
						<img src="http://image.kyobobook.co.kr/images/book/large/565/l9791160502565.jpg" alt="" class="thumb" />
						</a>
						</td>
						<td class="left info">
						<p class="txt_nomal">
						<a href="">시나공 워드프로세서 실기(2018)</a>
						</p>
							<!-- 2차 상품 -->
					    <!-- //2차 상품 -->
						</td>
						<td>
							<p class="price">17,000원
							<span class="mileage">170점</span>								
						</td>
						<td>
                            <label class="option_label"><input type="text" value="1" name="quantity_isbn_3" class="i_text" maxlength="2"></label>																				
						</td>
						<td class="price2">17,000원</td>
						<td><a href="#" class=""><i class="fas fa-trash-alt delete"></i></a></td>
					</tr>
																
				</tbody>
			</table>
		</div>
		
		<!-- //장바구니 리스트 -->
		<!-- 장바구니 합계 -->
						
		
		<div class="cart_result_box">
			<ul>
				<li>주문상품 수량 :   <span id='buyCnt'>2종 [2개]</span></li>
				<li>예상 마일리지 적립 :  <span id='mileage'>404점</span></li>
				<li>배송료 :  <span id='deliveryCost'>0원</span></li>
				<li>총 상품 금액 :  <span class="price" id='totalPrice'>40,400원</span></li>
			</ul>
		</div>
		
		<div class="btn_area_cart">
			<!--<a href="/myhanbit/order_payment.html" class="btn_green">주문하기</a> -->
			<button type="submit"  class="btn_green" style="height:50px">주문하기
		</div>		
		</form>
		<!-- 장바구니 버튼 -->						
	</div>
	<!-- //마이한빛 wrap -->
     </div>
  </div>
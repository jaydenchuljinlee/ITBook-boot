<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">

<!-- Contents -->
<div class="product-grid-holder tc-padding2">
<div class="row">
	<div class="myItbook_wrap" >
	
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
					<li class="left"><i class="fas fa-shopping-cart" style="font-size: 30px;"></i> 마이페이지</li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
			
		<!-- 회원등급 -->
		<div class="sm_myinfo">
			<div class="my_rating">
				<div class="icon">		
					<img src="images/mypage/Gold.jpg" alt="" />					
				</div>
				<br/>
				<p><strong>백가희</strong>님의<br> 회원 등급은 <a href="grade_info.do"><span>Gold Spoon</span></a> 입니다.</p>
				<p><strong>마일리지 : </strong><span>4,300</span>점</p>					
			</div>
		
				<!-- 최근 구매이력 -->
		<div class="sm_myorder">
			<p class="tit"><a href="buyList.do">[ 최근 구매이력 ]</a></p>
			
			
			<table class="tbl_type_list">
				
				<thead class="tbl_type_list_thead">
					<tr>
						<th scope="col">주문일자</th>
						<th scope="col">상품명</th>
						<th class="last" scope="col">주문금액</th>
					</tr>
				</thead>
				<tbody class="tbl_type_list_tbody">
						<tr>
						<td>2018-03-02</td>	
						<td>토비의 스프링 3.1</td>
						<td>30.000원</td>
						</tr>								
				</tbody>
			</table>
		</div>
		
		<!-- //최근 구매이력 -->
		</div>
		
		<!-- 쇼핑찜 상품 목록 -->
		<div class="submain_mypagae_foot smf_l">
			<div class="wish_book_list_area">
			<p class="sm_tit">위시리스트 
			<button class="btn btn-default wishbtn" onclick="location.href='wishList.do'">+더보기</button>
			</p>
              <hr>
				<ul>
					<li>
						<div class="wish_book_list">
							<span class="view_box_block"> <img
								src="http://image.kyobobook.co.kr/images/book/large/074/l9788996094074.jpg" alt="" class="thumb" />
							</span>
							<div class="info1">
								<p class="book_tit">
									윤성우의 열혈 Java 프로그래밍
								</p>
								<!---->
							</div>
							<div class="info2">
								<p class="price">
									30,000원
									<!--<br /><span>(10% off)</span>-->
								</p>
							</div>
						</div>
					</li>
					<li>
						<div class="wish_book_list">
							<span class="view_box_block"> <img
								src="http://image.kyobobook.co.kr/images/book/large/915/l9788997390915.jpg" alt="" class="thumb" />
							</span>
							<div class="info1">
								<p class="book_tit">
									Do it! 점프 투 파이썬
								</p>
								<!---->
							</div>
							<div class="info2">
								<p class="price">
									19,800원
									<!--<br /><span>(10% off)</span>-->
								</p>
							</div>
						</div>
                    </li>
                    	<li>
						<div class="wish_book_list">
							<span class="view_box_block"> <img
								src="http://image.kyobobook.co.kr/images/book/large/565/l9791160502565.jpg" alt="" class="thumb" />
							</span>
							<div class="info1">
								<p class="book_tit">
									시나공 워드프로세서 실기(2018)
								</p>
								<!---->
							</div>
							<div class="info2">
								<p class="price">
									17,000원
									<!--<br /><span>(10% off)</span>-->
								</p>
							</div>
						</div>
                    </li>
				</ul>
			</div>
         </div>
			
		
		<!-- My eBook -->
		<div class="submain_mypagae_foot smf_c">
			<p class="sm_tit">최근 마일리지 목록 <button class="btn btn-default" onclick="location.href='myMileage.do'" style="float: right;">+더보기</button></p>			
				
				<div class="account_mileage" id="mg_list_div" style="width: 100%; text-align: center;" >
			<table class="tbl_type_list">
				<thead class="tbl_type_list_thead">
					<tr>
						<th scope="col">일자</th>
						<th scope="col">구분</th>
						<th scope="col">마일리지 발생</th>
						<th class="last" scope="col">누적 마일리지</th>
					</tr>
				</thead>
				<tbody class="tbl_type_list_tbody">
						<tr>
						<td>2018-03-02</td>	
						<td>책구매</td>
						<td>300점</td>
						<td>4300점</td>
						</tr>		
						<tr>
						<td>2018-03-02</td>	
						<td>부가정보 입력</td>
						<td>1000점</td>
						<td>1000점</td>
						</tr>		
						<tr>
						<td>2018-03-02</td>	
						<td>회원가입</td>
						<td>3000점</td>
						<td>3000점</td>
						</tr>								
				</tbody>
			</table>
			</div>		
			<!-- // 내역 리스트 -->	
		</div>
		<!-- //My eBook -->
		
		<!-- My 강의 -->
		<div class="submain_mypagae_foot smf_r">
			<p class="sm_tit">1:1 문의내역 <button class="btn btn-default" onclick="location.href='myQna.do'" style="float: right;">+더보기</button></p>
							
				<div class="account_mileage" id="mg_list_div" style="width: 100%; text-align: center;" >
			<table class="tbl_type_list">
				<thead class="tbl_type_list_thead">
					<tr>
						<th scope="col">일자</th>
						<th class="last" scope="col">문의 내역</th>
					</tr>
				</thead>
				<tbody class="tbl_type_list_tbody">
						<tr>
						<td>2018-03-02</td>	
						<td>배송관련 문의 드립니다.</td>
						</tr>		
													
				</tbody>
			</table>
			</div>		

	</div>
	
	</div>
</div>
<!-- //Contents -->
</div>


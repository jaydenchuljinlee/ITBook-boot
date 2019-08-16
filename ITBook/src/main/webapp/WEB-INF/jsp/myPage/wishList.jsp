<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">
<div class="product-grid-holder tc-padding2">

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
				<li class="left"><img alt="" src="images/mypage/wish_t.png" style="width: 33.75px;height: 30px;margin-bottom: 5px;"> 위시리스트</li>
			</ul>
		</div>

		<!-- 탭메뉴 -->
		<!-- 상단 선택 영역 -->
	<div class="top_select_area">

		<!-- 선택영역 -->
		<div class="select_area">
			<div class="check_area">
				<label for="check_select"> <input class="i_check"
					type="checkbox" id="checkAll" name="checkAll" value=""> <strong>전체선택</strong>
				</label>
			</div>
			<label>
				<button type="button" value="선택항목 장바구니 담기" class="btn_basket">선택상품구매</button>
			</label>
			 <label>
				<button type="button" value="선택항목 삭제하기" class="btn_remove">선택상품삭제</button>
			</label>
		</div>
		<!-- //선택영역 -->
	</div>
	<!-- 상단 선택 영역 -->
<hr>
	<!-- 위시리스트 책 리스트 -->
	<form name="frm" id="frm" action="" method="post">
		<input type="hidden" name="mode" id="mode" value="">
		<div class="wish_book_list_area">
			<ul>
				<li>
					<div class="wish_book_list">
						<div class="check_area">
							<label for="check_select"> <input class="i_check2"
								type="checkbox" id="hbw_idx[]" name="hbw_idx[]" value="6118">
							</label>
						</div>
						<span class="view_box_block"> <img
							src="http://image.kyobobook.co.kr/images/book/large/074/l9788996094074.jpg"
							alt="" class="thumb" />
						</span>
						<div class="info1">
							<p class="book_tit">
								<a href="">윤성우의 열혈 Java 프로그래밍</a>
							</p>
						</div>
						<div class="info2">
							<p class="price">
								30,000원
							</p>
							<span class="mileage">300점</span>
						</div>
						<div class="book_list_btn">
							<label> 
								<button name="btnAddCart" type="button" value="장바구니"
									class="btn_basket" onClick="wishaddCart('6118');">장바구니</button>
							</label> <label>
								<button name="btnDelete" type="button" value="삭제"
									class="btn_remove" onClick="delete_item('6118');">삭제</button>
							</label>
						</div>
					</div>
				</li>
				<li>
					<div class="wish_book_list">
						<div class="check_area">
							<label for="check_select"> <input class="i_check2"
								type="checkbox" id="hbw_idx[]" name="hbw_idx[]" value="6112">
							</label>
						</div>
						<span class="view_box_block"> 
						<img src="http://image.kyobobook.co.kr/images/book/large/915/l9788997390915.jpg" alt="" class="thumb" />
						</span>
						<div class="info1">
							<p class="book_tit">
								<a href="">Do it! 점프 투 파이썬</a>
							</p>
						</div>
						<div class="info2">
							<p class="price">19,800원</p>
							<span class="mileage">189점</span>
						</div>
						<div class="book_list_btn">
							<label>
								<button name="btnAddCart" type="button" value="장바구니"
									class="btn_basket">장바구니</button>
							</label> <label>
								<button name="btnDelete" type="button" value="삭제"
									class="btn_remove">삭제</button>
							</label>
						</div>
					</div>
				</li>
				<li>
					<div class="wish_book_list">
						<div class="check_area">
							<label for="check_select"> <input class="i_check2"
								type="checkbox" >
							</label>
						</div>
						<span class="view_box_block"> 
						<img src="http://image.kyobobook.co.kr/images/book/large/565/l9791160502565.jpg" alt="" class="thumb" />
						</span>
						<div class="info1">
							<p class="book_tit">
								<a href="">시나공 워드프로세서 실기(2018)</a>
							</p>
						</div>
						<div class="info2">
							<p class="price">17,000원</p>
							<span class="mileage">170점</span>
						</div>
						<div class="book_list_btn">
							<label>
								<button name="btnAddCart" type="button" value="장바구니"
									class="btn_basket">장바구니</button>
							</label> <label>
								<button name="btnDelete" type="button" value="삭제"
									class="btn_remove">삭제</button>
							</label>
						</div>
					</div>
				</li>

			</ul>
		</div>
	</form>
	<!-- //위시리스트 책 리스트 -->
</div>
</div>
<!-- //마이한빛 wrap -->

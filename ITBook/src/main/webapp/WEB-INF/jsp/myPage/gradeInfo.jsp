<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
					<li class="left"><i class="fas fa-graduation-cap"></i> It Book 멤버십 등급별 혜택</li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
	
		<div class="TabsConts on">
			<table class="board-boon">
				<caption>* It Book 멤버십 등급별 혜택</caption>
				<colgroup>
					<col style="width:20%;">
					<col style="width:27%;">
					<col style="width:28%;">
					<col style="width:25%;">
				</colgroup>
				<tbody class="grade_tbody">
						<tr>
							<th scope="row">구분/회원등급</th>
							<td class="gold"><span class="rank" style="background:url(images/mypage/Gold.jpg);">등급</span>Gold Spoon</td>
							<td class="silver"><span class="rank" style="background:url(images/mypage/Silver.jpg);">등급</span>Silver Spoon</td>
							<td class="bronze"><span class="rank" style="background:url(images/mypage/Bronze.jpg);">등급</span>Bronze Spoon</td>
						</tr>
						<!-- 2017-03-07 수정 : 하단 내용 마크업 추가 (해당영역 전체 복사+붙여넣기 해주세요) -->
						<tr>
							<th scope="row">선정 기준</th>
							<td>
								<p>
									<span class="tx_point">최근 3개월 간의 구매건수가 5건 & 순수구매금액이 12만원 이상 또는 적립 마일리지 5만점 이상인 회원</span>
								</p>
							</td>
							<td>
								<p>
									<span class="tx_point">최근 3개월 간의 구매건수가 3건 또는 적립 마일리지가 2만점 이상인 회원</span>								
								</p>
							</td>
							<td>
								<p>
									<span class="tx_point">최근 3개월 간의 구매내역 및 마일리지 적립이 없는 회원</span>
								</p>
							</td>
						</tr>
						<tr>
							<th scope="row" rowspan="2">특별혜택</th>
							<td>
								<p>
									<span class="tx_point">할인쿠폰 3,000원 <br>(등급 상승 후 1회 지급 한정)</span>
								</p>
							</td>
							<td>
								<p>
									<span class="tx_point">할인쿠폰 2,000원 <br>(등급 상승 후 1회 지급 한정)</span>
								</p>
							</td>
							<td rowspan="2">&nbsp;</td>
						</tr>
						
					</tbody>
			</table>
</div>
</div>
</div>
</div>

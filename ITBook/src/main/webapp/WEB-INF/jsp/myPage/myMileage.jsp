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
					<li class="left"><a href="#" class="curr"><img
							alt="" src="images/mypage/m_t.png" style="width: 33.75px;height: 30px;margin-bottom: 5px;"> 마일리지 내역</a></li>
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
			<p class="tit">[ 최근 구매이력 ]</p>
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
		<!-- //회원등급 -->
        	
			<!-- 조회창 -->
			<div class="period_box">
				<div class="period_l">
					<span>기간별 조회</span>
					<div class="period_l_btn">
						<label>		
							<input type="button" value="1개월" id="1_month" class="i_button">
						</label>
						<label>		
							<input type="button" value="3개월" id="3_month" class="i_button">
						</label>
						<label>		
							<input type="button" value="6개월" id="6_month" class="i_button">
						</label>
					</div>
				</div>
															
			</div>
			<!-- //조회창 -->						
						
			<!-- 내역 리스트 -->
			<div class="account_mileage" id="mg_list_div">
			<table class="tbl_type_list">
				<thead class="tbl_type_list_thead">
					<tr>
						<th scope="col">일자</th>
						<th scope="col">구분</th>
						<th scope="col">마일리지 발생</th>
						<th scope="col">마일리지 차감</th>
						<th class="last" scope="col">누적 마일리지</th>
					</tr>
				</thead>
				<tbody class="tbl_type_list_tbody">
						<tr>
						<td>2018-03-02</td>	
						<td>책구매</td>
						<td>300점</td>
						<td></td>
						<td>4300점</td>
						</tr>		
						<tr>
						<td>2018-03-02</td>	
						<td>부가정보 입력</td>
						<td>1000점</td>
						<td></td>
						<td>1000점</td>
						</tr>		
						<tr>
						<td>2018-03-02</td>	
						<td>회원가입</td>
						<td>3000점</td>
						<td></td>
						<td>3000점</td>
						</tr>								
				</tbody>
			</table>
			</div>		
			<!-- // 내역 리스트 -->	
			<div class="myhanbit_tbox1 mb50">
			<p class="tbox_txt">* 잇북 마일리지는 모든 상품에 적용하여 현금처럼 사용이 가능합니다.</p>
			<p class="tbox_txt">* 잇북 마일리지는 5,000점 이상일 경우  사용이 가능합니다.</p>
		</div>
								
		</div><!--// myItbook_wrap 끝 -->
				                
	
	</div>
	</div>
	<!-- //마이한빛 wrap -->

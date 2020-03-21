<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

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
					<li class="left"><i class="fas fa-pen-square"></i> 개인정보 수정</li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
			
				<!-- 회원가입 개인정보 입력 -->
		<div class="member_register">
				<!-- 필수입력 -->
				<fieldset>
					<legend>회원정보 필수입력</legend>
				
					
					<div class="register_essential">
						<div class="register_li">
					<p class="register_cap"><span>* </span>는 필수 입력 사항입니다.</p>
					</div>
					
					
						<div class="register_li">
							<div class="i_tit"><strong>아이디</strong></div>														
							<input id="identity_input" class="form-control col-4 mx-1 necessary" type="text" name="identity" value="<c:out value='${user.identity}' />	" pattern="[A-Za-z0-9]{4,10}" maxlength="10" style="display:inline;" readOnly>
							
						</div>	
						
						<div class="register_li">
							<div class="i_tit"><strong>비밀번호<span>* </span></strong></div>
							<div class="i_con">
									<input id="input_pwd" class="form-control col-4 mx-1 necessary" type="password" name="password">
									<br>
									<span id="pw_tip">8~20자리의 영문, 숫자 조합(영문, 숫자, 특수 기호 조합을 권장합니다.)</span>	
									<!--pan>8자리 이상의 영문, 숫자 조합(영문, 숫자, 특수 기호 조합을 권장합니다)</span-->	
								
							</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>비밀번호 확인<span>* </span></strong></div>
							<div class="i_con">
									<input class="form-control col-4 mx-1 necessary" type="password" id="confirm_pwd">
							
								<span id="alert-danger" class="join-added-info text-danger" >비밀번호가 일치하지 않습니다.</span>
								<span id="alert-success" class="join-added-info text-primary" >비밀번호가 일치합니다.</span>
							</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>이름</strong></div>
							<input id="identity_input" class="form-control col-4 mx-1 necessary" type="text" name="name" maxlength="10" style="display:inline;">
							<div class="i_con"><c:out value="${user.name}" /></div>
						</div>
						<div class="register_li">
						    <label for="id">이메일</label>
						    <input type="hidden" id="email_input" name="email">
						    <input class="form-control col-3 mx-1 necessary" type="text" id="email_id">
							@
							<input class="form-control col-4 mx-1 necessary" type="text" id="email_address" readonly>
							<select id="email_select" class="sabang-select" name="mail" style="height:38px;">
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
							</select>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>휴대전화<span>* </span></strong></div>
							<div class="form-group">
							   <input type="hidden" id="manager_call_input" name="phone">
							   <input class="form-control col-1 mx-1 necessary" type="number" id="manager_call_input1" maxlength="5" oninput="maxLengthCheck(this)">
							-
							<input class="form-control col-1 mx-1 necessary" type="number" id="manager_call_input2" maxlength="4" oninput="maxLengthCheck(this)">
							-
							<input class="form-control col-1 mx-1 necessary" type="number" id="manager_call_input3" maxlength="4" oninput="maxLengthCheck(this)">
							</div>
						</div>
						<div class="register_li">
							<div class="i_tit"><strong>주소<span>* </span></strong></div>
							<div class="form-inline">
								<input class="form-control col-3 mx-1 necessary" type="text" id="search_zonecode" name="address1" readonly>

								<div id="search" class="col-2 p-2 mx-2 text-center address_btn" style="font-size:13px;">
									<span>주소검색</span>
								</div>
								<input class="form-control col-5 mx-1 necessary" type="text" id="search_address" name="address2" readonly>
							</div>
							<div class="mt-1">	
								<input class="form-control col-7 mx-1 necessary" type="text" id="address_details" name="address3">
							</div>
						</div>
					</div>
				</fieldset>
				<!-- 필수입력 -->		
				
		        <div class="btn_label_default">
					<button type="button" class="btn_leave">회원 탈퇴하기</button>
			
					<button name="" type="button" value="다음단계" class="btn_change">변경</button>
								
				</div>
		
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function() {
	$(".btn_leave").click(function() {
		var width = window.innerWidth*2/5;
		var height = window.innerHeight;
		window.open("memberLeave.do", "leaveForm", "width=" + width + ", height=" + height);
	});
});
</script>
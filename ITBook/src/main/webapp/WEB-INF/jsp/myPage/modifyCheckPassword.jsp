<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">

<div class="product-grid-holder tc-padding2">
	<div class="row">
		<div class="myItbook_wrap">
		
			 <!-- 마이페이지 카테고리  -->
			<div class="lft_sec_mypage">
				<ul class="txt_tab_menu mypage-tab">
					<li><a href="myPage.do">마이페이지</a></li>
					<li><a href="grade_info.do">등급별 혜택</a></li>
					<li><a href="myMileage.do">마일리지</a></li>
				    <li><a href="myBasket.do">장바구니</a></li>
					<li><a href="wishList.do">위시리스트</a></li>
					<li><a href="buyList.do">구매/주문 내역</a></li>	
					<li><a href="myQna.do">1:1문의 내역</a></li>					
				    <li><a href="modifyCheckPassword.do">개인정보 수정</a></li>
				</ul>
			</div>
			<!-- 마이페이지 카테고리  -->
			
			<div class="tabmenu" id="my_mileage">
				<ul>
					<li class="left"><h1>회원정보 확인</h1></li>
					<li class="left">
						<h5>정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인 합니다. 회원님의 비밀번호는 타인에게 노출되지 않도록 주의해 주세요. 회원님의 정보는 소중하니까요!</h5>
					</li>
				</ul>
			</div>

			<div class="member_register">
				<fieldset>
					<legend>회원정보 필수입력</legend>

					<div class="register_essential">
						<div class="register_li">
							<div class="i_tit"><strong>아이디</strong></div>														
							<div class="i_con">asdf1234</div>
						</div>	
						
						<div class="register_li">
							<div class="i_tit"><strong>비밀번호</strong></div>
							<div class="i_con">
								<input type="password" name="m_passwd" id="m_passwd" class="i_text" value="" >
							</div>
						</div>
					</div>
				</fieldset>
				
		        <div class="btn_label_default">
					<button type="button" class="btn_leave">확인</button>
					<button type="button" class="btn_change">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function() {
	$(".btn_leave").click(function() {
		location.href = "modifyInformation.do";
	});
	
	$(".btn_change").click(function() {
		location.href = "myPage.do";
	});
});
</script>
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
							
							<div class="i_con">
								asdf1234	
								
							</div>
						</div>	
						
						<div class="register_li">
							<div class="i_tit"><strong>비밀번호<span>* </span></strong></div>
							<div class="i_con">
									<input type="password" name="m_passwd" id="m_passwd" class="i_text" value="" >
									<br>
									<span id="pw_tip">8~20자리의 영문, 숫자 조합(영문, 숫자, 특수 기호 조합을 권장합니다.)</span>	
									<!--pan>8자리 이상의 영문, 숫자 조합(영문, 숫자, 특수 기호 조합을 권장합니다)</span-->	
								
							</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>비밀번호 확인<span>* </span></strong></div>
							<div class="i_con">
									<input type="password" name="m_passwd_chk" id="m_passwd_chk" class="i_text">	
									<span id="pwchk_tip" ></span><span id="pw_same_tip" class="f_red"></span>
							</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>이름</strong></div>
							<div class="i_con">김자바</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>성별</strong></div>													
							<div class="i_con">남</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>생년월일<span>* </span></strong></div>
							<div class="i_con">
								
							1990년&nbsp;08월&nbsp;06일		
                                &nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="m_birth_type" id="m_birth_type_s"  value="s"  class="i_radio"  checked>	
									<span>양력</span>
									<input type="radio" name="m_birth_type" id="m_birth_type_l"  value="l" class="i_radio"   >	
									<span>음력</span>								
							</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>이메일<span>* </span></strong></div>
							<div class="i_con">								
								<INPUT type="hidden" name="m_email" id="m_email"  value="">
									<input type="text" name="m_email_1" id="m_email_1" class="i_text2" value="abcd123">	
									@
									<input type="text" name="m_email_2" id="m_email_2" class="i_text2" value="naver.com">	
								
									<select id="m_email_addr" name="m_email_addr" class="i_select2">																	
										<option value="">직접입력</option>																
										<option value="naver.com">naver.com</option>		
										<option value="daum.net">daum.net</option>		
										<option value="nate.com">nate.com</option>		
										<option value="gmail.com">gmail.com</option>		
										<option value="hotmail.com">hotmail.com</option>		
										<option value="yahoo.co.kr">yahoo.co.kr</option>										
									</select>    														
									<span id="email_tip" color="red"></span>		
								
									<p class="tit_modify">이메일 수신동의 시, 신상품/할인혜택/이벤트 등의 정보를 받아보실 수 있습니다.<br>
                                                                                                                        수신동의 거부 시에도 기본서비스(주문배송 메일)는 발송됩니다.</p>																	
									<input type="radio" name="m_agree_email" id="m_agree_email_y" value="Y" checked='checked'  class="i_radio">
									<span>예</span>
									<input type="radio" name="m_agree_email" id="m_agree_email_n" value="N"  class="i_radio">
									<span>아니오</span>
							</div>
						</div>
						
						<div class="register_li">
							<div class="i_tit"><strong>휴대전화<span>* </span></strong></div>
							<div class="i_con">
									<input type="text" name="m_mobile_1" id="m_mobile_1" class="i_text3" value="010" maxlength="4" >	
								
								- <input type="text" name="m_mobile_2" id="m_mobile_2" class="i_text3" value="1234"maxlength="4" >	
							
								- <input type="text" name="m_mobile_3" id="m_mobile_3" class="i_text3" value="5678"maxlength="4" >	
							
									<p class="tit_modify">할인혜택과 이벤트 등의 소식 안내를 SMS로 받으실 수 있습니다.<br>
									                수신동의 거부 시에도 기본서비스는 발송됩니다.</p>															
									<input type="radio" name="m_agree_sms" id="m_agree_sms_y" value="Y" checked='checked'  class="i_radio">
									<span>예</span>
									<input type="radio" name="m_agree_sms" id="m_agree_sms_n" value="N"  class="i_radio">
									<span>아니오</span>
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
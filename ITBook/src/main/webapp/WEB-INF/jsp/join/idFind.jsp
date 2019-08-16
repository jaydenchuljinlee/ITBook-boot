<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="/ITBook/css/join/join.css">

<div class="w940 wrap_member">
		<!-- 아이디 찾기 영역 -->
		<p class="tit"><strong>회원 가입 시 등록한 이름과 이메일 정보로 아이디를 찾을 수 있습니다.</strong></p>
		<p class="sum">회원 가입 시 등록한 정보를 정확히 입력해주세요.</p>
		<form name="frm" id="frm" action="#" method="post">
			<div class="find_id">
				<fieldset>
					<legend>아이디 찾기</legend>
					
					<label class="i_label" for="find_name">
						<input class="form-control" required="required" placeholder="이름" name="name">
					</label>
		
					<label class="i_label" for="find_mail">
						<input class="form-control" required="required" placeholder="이메일" name="eMail">
					</label>
										
					<div class="btn_label">
						<label>
							<button name="find_id" id="find_id" type="button" value="로그인" class="btn_login"><a href="idFindTwo.do">아이디 찾기</a></button>
						</label>
					</div>
								
				</fieldset>
			</div>
		</form>
		<p class="cap">위 방법으로 아이디를 찾을 수 없는 경우 <a href="oneAsk.do">고객센터</a>에 문의해주세요.</p>
		<!-- //아이디 찾기 영역 -->
	</div>
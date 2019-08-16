<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="/ITBook/css/join/join.css">

<div class="w940 wrap_member">
		<!-- 아이디 찾기 영역 -->
		<p class="tit"><strong>회원 가입 시 등록한 정보로 비밀번호를 찾을 수 있습니다.</strong></p>
		<p class="sum">회원 가입 시 등록한 정보를 정확히 입력해주세요.</p>
		<form name="frm" id="frm" action="#" method="post">
			<div class="find_id">
				<fieldset>
					<legend>비밀번호 찾기</legend>
					
					<label class="i_label" for="find_id">
						<input class="form-control" required="required" placeholder="아이디" name="idPassword">
					</label>
		
					<label class="i_label" for="find_name">
						<input class="form-control" required="required" placeholder="이름" name="namePassword">
					</label>
					
					<label class="i_label" for="find_email">
						<input class="form-control" required="required" placeholder="이메일" name="emailPassword">
					</label>			
					<div class="btn_label">
						<label>
							<button name="find_id" id="find_id" type="button" value="비밀번호 찾기" class="btn_login"><a href="passwordFindTwo.do">비밀번호 찾기</a></button>
						</label>
					</div>
								
				</fieldset>
			</div>
		</form>
		<p class="cap">위 방법으로 비밀번호를 찾을 수 없는 경우 <a href="oneAsk.do">고객센터</a>에 문의해주세요.</p>
		<!-- //아이디 찾기 영역 -->
	</div>
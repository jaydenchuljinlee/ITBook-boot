<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="/ITBook/css/join/join.css">

<div class="w940 wrap_member">
		<!-- 비밀번호 재설정 영역 -->
		<p class="tit"><strong>비밀번호 재설정</strong></p>
		<p class="sum">비밀번호 재설정을 위한 본인 확인이 완료 되었습니다. 새로운 비밀번호 등록을 해주시기 바랍니다.</p>
		
		<form name="frm" id="frm" action="#" method="post">
			<input type="hidden" name="m_idx" id="m_idx" value="145099" class="i_text">						
			
			<div class="new_pw">
				<div class="new_pw_box">
					<p class="new_pw_l"><strong><span>아이디 <span>:</span> </span>Hanq</strong></p>
					<div class="new_pw_r">
						<fieldset>
							<legend>새 비밀번호</legend>
							<strong>새 비밀번호</strong>
							<label class="i_label" for="new_pw">
								<input name="new_pw" type="password" value="" class="i_text" id="new_pw" placeholder="새 비밀번호" name="newPassword">
							</label>
							<strong>새 비밀번호 확인</strong>
							<label class="i_label" for="new_pw_chk">
								<input name="new_pw_chk" type="password" value="" class="i_text" id="new_pw_chk" placeholder="새 비밀번호 확인" name="newPassword2">
							</label>
						</fieldset>
					</div>
				</div>
				
				<p class="cap">8자리 이상의 영문, 숫자 조합(영문, 숫자, 특수 기호 조합을 권장합니다.)</p>
				<fieldset>
					<legend>비밀번호 변경</legend>
					<label>
						<button name="change_pw_btn" id="change_pw_btn" type="button" value="" class="btn_new_pw">비밀번호 변경</button>
					</label>
				</fieldset>
			</div>
		</form>
		<script>
		$("#change_pw_btn").click(function() {
			alert("비밀번호가 변경되었습니다.");
			location.href = "main.do";
		});
		
		</script>
		<!-- //비밀번호 재설정 영역 -->
	</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Login Modal 로그인 모달창 -->
 <div class="modal fade login-modal" id="login-modal" role="dialog">
	<div class="position-center-center" role="document">
		<div class="modal-content">
			<strong>로그인</strong>
			<button class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<form class="sending-form" id="loginFrm">
				<div class="form-group">
					<input type="text" id="id_input" class="form-control" required="required" placeholder="ID" name="identity">
					<i class="fa fa-user"></i>
				</div>
				<div class="form-group">
					<input type="password"  id="pwd_input" class="form-control" required="required" placeholder="Password" name="password">
					<i class="fa fa-user"></i>
				</div>
				<p class="terms">
					<a class="pageMove" data-page="/join" href="javascript:;"> 회원가입</a>
					/ <a class="pageMove" data-page="/join" href="#">아이디 찾기</a>
					/ <a class="pageMove" data-page="/join" href="#">비밀번호 찾기</a>
				</p>
			</form>
			<button type="button" class="btn-1 shadow-0 full-width" id="loginBtn">로그인</button>
			<a href="javascript:;" class="btn_social" data-social="facebook">
				<img src="/images/facebook.png" width="40px" height="40px">
			</a>
			<a href="javascript:;" class="btn_social" data-social="google">
				<img src="/images/google.png" width="40px" height="40px">
			</a>
			<a href="javascript:;" class="btn_social" data-social="kakao">
				<img src="/images/kakao.png" width="40px" height="40px">
			</a>
		</div>
	</div>
</div> 
<!-- Login Modal -->

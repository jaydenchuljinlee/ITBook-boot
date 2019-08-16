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
					<input class="form-control" required="required" placeholder="ID" name="id">
					<i class="fa fa-user"></i>
				</div>
				<div class="form-group">
					<input class="form-control" required="required" placeholder="Password" name="pw">
					<i class="fa fa-user"></i>
				</div>
				<p class="terms"> <a href="joinCheck.do"> 회원가입</a> / <a href="idFind.do">아이디 찾기</a> / <a href="passwordFind.do">비밀번호 찾기</a>   </p>
				<button type="button" class="btn-1 shadow-0 full-width" id="login">로그인</button>
			</form>
		</div>
	</div>
</div> 
<!-- Login Modal -->

<script>
$(function() {
	
	$("#login").click(function() {
		
		$("#loginFrm").attr("action",$(this).attr("id")+".do");
		$("#loginFrm").attr("method","post");
		$("#loginFrm").submit();
	})
})
</script>
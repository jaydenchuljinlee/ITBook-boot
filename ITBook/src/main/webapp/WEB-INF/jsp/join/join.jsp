<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/customer_center/customer_common.css">

<div class="container">
	<div class="join_wrap modal-content">
		<div class="main-heading-holder">
			<div class="main-heading">
				<h2><span class="theme-color">회원 </span> 가입</h2>
				<p>IT Book에 오신 걸 환영합니다.</p>
			</div>
		</div>	
	
		<form action="" method="post" id="frmMemberJoin" name="frmMemberJoin">
			<div class="form-group">
				<label for="id">아이디</label>
				<input type="text" class="form-control" maxlength="10" name="id" id="id">
				<p id="msgCheckId" class="check_txt_check">아이디를 입력 해주세요</p>
			</div>
			<div class="form-group">
			    <label for="pass">비밀번호</label>
			    <input type="password" class="form-control" maxlength="10" name="passwd" id="passwd">
			</div>
			<div class="form-group">
			    <label for="pass">비밀번호 확인</label>
			    <input type="password" class="form-control" maxlength="10" name="passwdChk" id="passwdChk">
				<p id="msgCheckPw" class="check_txt_check">비밀번호를 입력해주세요</p>
			</div>
			<div class="form-group">
			    <label for="id">이름</label>
			    <input type="text" class="form-control" maxlength="10" name="name" id="name">
			</div>
			<div class="form-group">
			    <label for="id">이메일</label>
			    <ul class="li_mail cf">
			    	<li><input type="text" class="form-control" maxlength="10" name="mail" id="mail"></li>
			    	<li>@</li>
			    	<li><input type="text" class="form-control" maxlength="10" name="mailDomain" id="mailDomain"></li>
			    	<li>
					    <select name="selectMail" id="selectMail" class="select_mail form-control">
					    	<option value="">선택</option>
					    	<option value="google.com">google.com</option>
					    	<option value="naver.com">naver.com</option>
					    	<option value="hanmail.net">hanmail.net</option>
					    	<option value="hotmail.com">hotmail.com</option>
					    </select>					    	
			    	</li>
			    </ul>   
			</div>
			<div class="form-group">
			    <label for="id">전화번호</label>
			    <input type="text" class="form-control" maxlength="11" name="phone" id="phone" placeholder="-없이 입력해주세요">
			</div>
			<div class="text-right">
				<button type=button id="btnJoin" class="btn btn_orange">회원가입</button>
			</div>
		</form>
	</div>

</div>

<script>
$('#frmMemberJoin #id').on('keyup', function(){	
	var msgCheckId = $('#msgCheckId');
	if($(this).val()==='') {
		msgCheckId.text('아이디 입력해주세요');
		msgCheckId.attr("class","check_txt_check");
	} else {
		msgCheckId.text($(this).val()+'는 사용 가능한 아이디 입니다.');
		msgCheckId.attr("class","check_txt_basic");
	}
})

//pwValidator : 비밀번호와 비번확인 일치여부 체크
var pwValidator = {
	excute : function() {
		var passCheck = function() {
			var msgCheckPw = $('#msgCheckPw');
			var pw1 = $('#passwd').val();
			var pw2 = $('#passwdChk').val();
			if(pw1 =='' && pw2 =='') {
				msgCheckPw.text('비밀번호를 입력해주세요');
				msgCheckPw.attr("class","check_txt_check");
				joinValiState=false;
			} else if(pw1 != pw2) {
				msgCheckPw.text('비밀번호가 일치하지 않습니다');
				msgCheckPw.attr("class","check_txt_check");
				joinValiState=false;
			} else if(pw1 == pw2) {
				msgCheckPw.text('비밀번호가 일치합니다');	
				msgCheckPw.attr("class","check_txt_basic");
				joinValiState=true;
			}
		}// passCheck()
		$('#passwd').on('keyup', passCheck);
		$('#passwdChk').on('keyup', passCheck);
	}
};
pwValidator.excute(); // 매개변수 받아서 하는걸로 변경

$("#btnJoin").click(function() {
	alert("회원가입이 완료되었습니다.");
	location.href = "index.jsp";
});
</script>


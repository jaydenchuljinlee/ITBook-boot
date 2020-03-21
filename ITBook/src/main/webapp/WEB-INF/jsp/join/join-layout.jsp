<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<tiles:insertAttribute name="head" />
</head>
<body>
	<tiles:insertAttribute name="loading" />
	<div class="wrapper push-wrapper">
		<!-- Header start-->
		<tiles:insertAttribute name="header" />
		<!-- Header end-->
		<!-- 메인 컨텐츠 -->
		<tiles:insertAttribute name="content" />
		<!-- 메인 컨텐츠// -->
		<tiles:insertAttribute name="footer" />
	</div>
	
	<!-- 실행에 필요한 자바스크립트 파일들 -->
	<!--                                   -->

	<!-- 다음주소api -->
	<script type="text/JavaScript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	
	<script type="text/JavaScript">
	$(document).ready(function() {
		$("#alert-success").hide(); 

		//사업자유형 div 클릭시 하이라이트 이동
		$(".buisnessman").on("click",function() {
			$(".buisnessman-selected").removeClass("buisnessman-selected");

			$(this).addClass("buisnessman-selected");
			$("#buisnessman_type_input").val($(this).val());
		});

		//이메일 셀렉트박스 변경
		$("#email_select").on("change",function() {
			$("#email_address").val($(this).val());
		});

		/********************** 
		*주소검색시 다음주소api 실행
		* #search_zonecode		: 우편번호 태그
		* #search_address		: 검색후 입력되는 주소 태그
		* #address_details		: 상세주소 입력 태그
		***********************/
		$("#search").on("click",function() {
			
			new daum.Postcode({

				oncomplete:function(data) {
					
					$("#search_zonecode").val(data.zonecode);
					$("#search_address").val(data.address);
					$("#address_details").focus();
				}

			}).open();
		});

		$("#confirm_overlap").on("click",function() {

			if (overLapCheck()) {
				alert("이미 있는 아이디 입니다.");
				return;
			} else {
				alert("사용할 수 있는 아이디 입니다.");
				$("#confirm_overlap").addClass("overlap-check");
				$("#confirmed").val($("#identity_input").val());
			}

		});


		/********************** 
		*기본정보 전송
		*@arr		: 필수항목 클래스를 가진 태그
		*@return	: 0은 비정상 종료,1은 정상 종료
		***********************/
		$("#btnJoin").on("click",function() {

			if (!necessaryCheck()) return;
			
			if (!accountCheck()) return;

			if (!regexCheck()) return;

			var manager_phone	= $("#manager_call_input1").val() + "-" + $("#manager_call_input2").val() + "-" + $("#manager_call_input3").val(),
				email			= $("#email_id").val() + "@" + $("#email_address").val();

				$("#manager_call_input").val(manager_phone);
				$("#email_input").val(email);

			$("#default_frm").attr("action","/join/joinSuccess");
			$("#default_frm").submit();
			
		});

		/********************** 
		* keyup 이벤트들
		***********************/

		$("#manager_call_input1").keyup(function() {
			
			if($(this).val().length >= 3) $(this).next().focus();
		});

		$("#manager_call_input2").keyup(function() {
			
			if($(this).val().length >= 4) $(this).next().focus();
		});

		$("#confirm_pwd").keyup(function() {
		
			var pwd1=$("#input_pwd").val(); 
			var pwd2=$("#confirm_pwd").val();

			if (pwd1 != "" || pwd2 != "") { 

				if (pwd1 == pwd2) { $("#alert-success").show(); 
				$("#alert-danger").hide(); 
				
				} else { 
					$("#alert-success").hide(); 
					$("#alert-danger").show(); 
				}
			}

		});
	});

	/********************** 
	*정규식 체크
	*@arr		: 필수항목 클래스를 가진 태그
	*@return	: 0은 비정상 종료,1은 정상 종료 
	***********************/
	function regexCheck() {

		var rtnVal = 0;
		
		var regexEn			= /[a-zA-Z]/,
			regexNum		= /[0-9]/,
			regexSign		= /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/,
			regexEmail_1	= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])/,
			regexEmail_2	= /[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}/;

		var identity	= $("#identity_input").val(),
			password	= $("#input_pwd").val(),
			email_1		= $("#email_id").val(),
			email_2		= $("#email_address").val();
		
		//아이디 정규식 체크
		if (regexEn.test(identity) === false || regexNum.test(identity) === false) {

			alert("아이디는 영어로 대/소문자/숫자 조합이어야 합니다.");
			$("#identity_input").focus();
			return 0;
		}
		
		//비밀번호 정규식 체크
		if (regexEn.test(password) === false || regexNum.test(password) === false || 
		regexSign.test(password) === false || password.length < 8) {

			alert("비밀번호는 숫자,문자,특수문자 조합으로 8자 이상 입력해주세요.");
			$("#input_pwd").focus();
			return 0;
		} 
		
		//이메일 정규식 체크
		if (regexEmail_1.test(email_1) === false || regexEmail_2.test(email_2) === false) {

			alert("이메일 형식을 올바르게 작성해주세요.");
			$("#email_input").focus();
			return 0;
		}
		
		return 1;
	}

	/********************** 
	*아이디 중복 체크
	*@identity	: 아이디 태그의 값
	*@rtnVal	: 0이면 정상 종료, 1이면 비정상 종료
	***********************/
	function overLapCheck() {
		
		var identity	= $("#identity_input").val(),
			rtnVal		= 0;
		
		$.ajax({
			url			: "/join/identityCheck",
			type		: "post",
			async		:false,
			data		: "identity="+identity,
			success		: function(data){
				
				if (data == 0) {
					console.log("값이 비어있음");
					rtnVal = 0;

				} else {
					console.log(data);
					rtnVal = 1;

				}
			},
			error		: function (request, status, error){    
				console.log(request);
				console.log(status);
				console.log(error);
			}

		  });

		  return rtnVal;
	}

	/********************** 
	*아이디,비밀번호 확인 체크
	*@id_confirm	: 중복확인 버튼
	*@id_input		: 아이디 인풋
	*@compare_input : 아이디 비교 인풋
	*@pwd_input		: 비밀번호 인풋
	*@pwd_confirm	: 비밀번호 확인 인풋
	*@return		: 0은 비정상 종료, 1은 정상 종료
	***********************/
	function accountCheck() {
		
		var id_confirm		= $("#confirm_overlap").attr("class"),
			id_input		= $("#identity_input").val(),
			compare_input	= $("#confirmed").val(),
			pwd_input		= $("#input_pwd").val(),
			pwd_confirm		= $("#confirm_pwd").val();

		if (id_confirm.indexOf("overlap-check") == -1 || id_input !== compare_input) {
			alert("아이디 중복확인을 해주세요.");
			$("#confirm_overlap").focus();
			return 0;
		}
		
		if (pwd_input !== pwd_confirm) {
			alert("비밀번호를 확인해 주세요.");
			$("#confirm_pwd").focus();
			return 0;
		}

		return 1;
	}

	/********************** 
	*필수항목 체크
	*@arr		: 필수항목 클래스를 가진 태그
	*@return	: 0은 비정상 종료,1은 정상 종료
	***********************/
	function necessaryCheck() {
		
		var arr = new Array();
		
		arr = $(".necessary");
		
		for (var i=0; i<arr.length ; i++) {
			var tag = arr[i];

			if ($(tag).val() == '' || $(tag).val() == 'default') {

				alert("필수항목을 입력해주세요!");
				$(tag).focus();

				return 0;
			}
		}
		
		return 1;
	}
		

	//input number 길이 체크
	function maxLengthCheck(object){
		if (object.value.length > object.maxLength){
			object.value = object.value.slice(0, object.maxLength);
		}    
	}
	</script>
	
	 <tiles:insertAttribute name="link_js" />
</body>
</html>
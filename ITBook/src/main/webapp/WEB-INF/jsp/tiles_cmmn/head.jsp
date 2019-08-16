<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content=""/>
<!-- Document Title -->
<title>IT 종사자/개발자를 위한 공간 ITbook 입니다</title>

<!-- StyleSheets -->
<link rel="stylesheet" href="/itbook/css/bootstrap/bootstrap.min.css">

<link rel="stylesheet" href="/itbook/css/icomoon.css">

<link rel="stylesheet" href="/itbook/css/main.css">
<link rel="stylesheet" href="/itbook/css/color-1.css">
<link rel="stylesheet" href="/itbook/css/style.css">
<link rel="stylesheet" href="/itbook/css/responsive.css">
<link rel="stylesheet" href="/itbook/css/transition.css">

<!-- 게시판 공용 CSS -->
<link rel="stylesheet" href="/itbook/css/board/board.css">
 
 <!-- 아이콘 폰트어썸 -->
<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
<!-- <link rel="stylesheet" href="/itbook/css/font-awesome.min.css"> -->

<!-- JavaScripts -->
<!-- <script src="js/vendor/modernizr.js"></script> -->
<script src="/itbook/js/jquery.min.js" type="text/javascript"></script>


<script>
$(function(){
	 // 화면 상단 검색어 부부
	var hotKeywords = {
		initFun : function(){
			$('#hot_issue li').eq(0).fadeIn(600).delay(3800).fadeOut(600)
		},
		fadeShow : function(){
			var idx = 1;
			var $hotIssue_li = $('#hot_issue li');
			var len = $hotIssue_li.length-1;

			this.initFun();

			setInterval(function(){
				$hotIssue_li.eq(idx).fadeIn(600).delay(3800).fadeOut(600);
				idx++;
				if(idx > len)
					idx = 0
			},5000)
		}
	}
	hotKeywords.fadeShow(); 
	
})
</script>
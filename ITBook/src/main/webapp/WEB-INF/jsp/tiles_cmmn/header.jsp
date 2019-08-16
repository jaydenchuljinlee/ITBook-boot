<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Top Bar -->
<div class="topbar">
	<div class="container">
		<div class="row">
			<!-- Cart Option -->
			<div class="cart-option col-lg-7">
				<ul>
					<li class="add-cart">
						<a href="myBasket.do">
							<i class="fas fa-shopping-cart"></i>
							<span style="right: -15px;">3</span>
						</a>
					</li>
					<li class="add-cart">
						<img class="wish_n" alt="" src="/itbook/images/store/wish_n.png"><a href="wishList.do">위시리스트</a>
					</li>
					<li class="user_i"><a href="myPage.do"><i class="far fa-user"></i>마이페이지</a></li>
					<li><a href="#" data-toggle="modal" data-target="#login-modal">
					<i class="fas fa-sign-in-alt"></i>로그인 / 회원가입</a></li>
				</ul>
			</div>
			<!-- Cart Option -->

			<!-- Online Option -->
			<div class="online-option col-lg-4">
				<ul id="hot_issue">
					<li><a href="#">정신차린 MS가 만든 JS superset, Typescript</a></li>
					<li><a href="#">빠르게 치고 올라오는 Vue.js</a></li>
					<li><a href="#">구글이 미는 강자 Angular4</a></li>
					<li><a href="#">페북이 만든 대세 React.js</a></li>
					<li><a href="#">새로운 백엔드 패러다임 Node.js</a></li>
				</ul>
			</div>
			<!-- Online Option -->
		</div>

	</div>
</div>
<!-- Top Bar -->
<!-- Nav -->
<nav class="nav-holder style-1">
	<div class="container">
		<div class="mega-dropdown-wrapper">

			<!-- Logo -->
			<div class="logo">
				<a href="main.do"><img src="/itbook/images/logo-1.png" alt=""></a>
			</div>
			<!-- Logo -->

			<!-- Responsive Button -->
			<div class="responsive-btn">
				<a href="#menu" class="menu-link circle-btn"><i
					class="fa fa-bars"></i></a>
			</div>
			<!-- Responsive Button -->

			<!-- Navigation -->
			<div class="navigation">
				<ul>
					<li class="dropdown-icon">
						<a href="#"><i class="fas fa-book"></i>도서 <i class="fas fa-angle-down"></i></a>
						<ul>
							<li><a href="#" id="recommendBook" class="menu">맞춤도서</a></li>
							<li><a href="#" id="newBook" class="menu">신간도서</a></li>
							<li><a href="#" id="categoryBook" class="menu">전체 도서</a></li>
						</ul>
					</li>
					<li class="dropdown-icon">
						<a href="usedbookMain.do"><i class="fa fa-book"></i>중고 <i class="fas fa-angle-down"></i></a>
						<ul>
							<li><a href="usedbookMain.do">IT-Book 중고도서</a></li>
							<li><a href="usedbookSells.do">IT-Book 에 파세요!</a></li>
							<li><a href="usedbookGuide.do">중고팔기 이용안내</a></li>
						</ul>
					</li>
					<li class="dropdown-icon">
						<a href="#"><i class="fas fa-desktop"></i>교육 <i class="fas fa-angle-down"></i></a>
						<ul>
							<li><a href="#" id="seminar" class="menu">세미나</a></li>
							<li><a href="#" id="lecture" class="menu">강의</a></li>
							<li><a href="#" id="license" class="menu">자격증</a></li>
						</ul>
					</li>
					<li class="dropdown-icon"><a href="#"><i class="fa fa-code"></i>개발자 공간 <i class="fas fa-angle-down"></i></a>
						<ul>
							<li><a href="#" id="talkBoard" class="menu">Talk! & Tip!</a></li>
							<li><a href="#" id="askBoard" class="menu">질문있습니다!!</a></li>
							<li><a href="#" id="itNews" class="menu">IT news & column</a></li>
							<li><a href="#" id="studyBoard" class="menu">스터디</a></li>
						</ul>
					</li>
					<li><a href="eventList.do"><i class="fa fa-certificate"></i>이벤트</a></li>
					<li class="dropdown-icon"><a href="about.do"><i class="fas fa-phone-volume"></i>고객센터 <i class="fas fa-angle-down"></i></a>
						<ul>
							<li><a href="faq.do">FAQ</a></li>
							<li><a href="oneAsk.do">1:1문의</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- Navigation -->

		</div>
	</div>
</nav>
<!-- Nav -->
<form id="moveFrm"></form>

<form id="frm" method="post"> 
	<input type="hidden" id="pageName" name="pageName"/>
</form>

<script>
$(document).ready(function() {
	
	$(".menu").click(function() {
		
		$("#moveFrm").attr("action",$(this).attr("id")+".do")
		$("#moveFrm").submit()
	})
})
</script>

<script>	
	var header = { // 리터럴 함수를 선언하여  각 메뉴를 클릭할 때, id가 frm인 곳으로 매개변수를 전달하여, value에 추가하도록 하였다.
			pageSubmitFn : function(str) {
				$("#frm").attr("action",str + ".do");
				$("#pageName").val(str);
				$("#frm").submit();
			}
	}; 
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">

<!-- Contents -->
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
			<div class="tabmenu">
				<ul>
					<li class="left"><i class="fas fa-child"></i> 주문완료</li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
		
		<!-- 주문배송 조회 -->
		<div class="myBasket-step smf_l">
              <hr>
				<ul class="mypage-step">
					<li><em><i class="fas fa-shopping-cart" style="font-size: 50px;"></i></em> <span>장바구니</span></li>
					<li><em><i class="far fa-credit-card" style="font-size: 50px;"></i></em> <span>주문결제</span></li>
					<li><em><i class="fas fa-child" style="font-size: 50px; color: #fe981e"></i></em> <span>주문완료</span></li>
				</ul>
			</div>
		<!-- //주문배송 조회 -->
		
		
		<div class="order_info_box">
			<div class="order_info" style="position:relative;">
				<fieldset>
				   <div class="register_li">
						<div class=""><strong>주문 정보</strong></div>
					</div>
					<hr>
                    <div class="register_li">
						<div class="i_tit"><strong>주문번호</strong></div>
						<div class="i_con">
								<p><c:out value="${payInfoList[0].payment.idx}"/></p>
						</div>
					</div>
					 <div class="register_li">
						<div class="i_tit"><strong>총 결제 금액</strong></div>
						<div class="i_con">
								<p><c:out value="${payInfoList[0].payment.totalPrice}"/>원</p>
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>결제방법</strong></div>
						<div class="i_con">
							<c:if test="${payInfoList[0].payment.method eq 'card'}">
								<p>신용카드</p>
							</c:if>
							<c:if test="${payInfoList[0].payment.method eq 'cash'}">
								<p>계좌이체</p>
							</c:if>
							<c:if test="${payInfoList[0].payment.method eq 'bank'}">
								<p>무통장</p>
							</c:if>
						</div>
					</div>
					   <div class="register_li">
						<div class="i_tit"><strong>결제일</strong></div>
						<div class="i_con">
								<p><c:out value="${payInfoList[0].payment.payDate}"/></p>
						</div>
					</div>
					   <div class="register_li">
						<div class="i_tit"><strong>구매목록</strong></div>
						<div class="i_con">
							<p>
								<c:out value="${payInfoList[0].book.theme}"/>
								<c:if test="${payInfoList[0].payment.totalquantity > 1}">
									외<c:out value="${payInfoList[0].payment.totalquantity - 1}"/>개
								</c:if>
							</p>
						</div>
					</div>	  
					 <div class="register_li">
						<div class="i_tit"><strong>예상적립 마일리지</strong></div>
						<div class="i_con">
								<p><c:out value="${payInfoList[0].payment.mileage}"/>점</p>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
		
		</div>
	</div>
</div>
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
					<li><a href="grade_info.do">등급별 혜택</a></li>
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
			<div class="tabmenu" id="my_mileage">
				<ul>
					<li class="left"><i class="far fa-credit-card"></i> 주문결제</li>
				</ul>
			</div>

			<!-- 탭메뉴 -->
		<!-- 주문배송 조회 -->
		<div class="myBasket-step smf_l">
              <hr>
				<ul class="mypage-step">
					<li><em><i class="fas fa-shopping-cart" style="font-size: 50px;"></i></em> <span>장바구니</span></li>
					<li><em><i class="far fa-credit-card" style="font-size: 50px; color: #fe981e"></i></em> <span>주문결제</span></li>
					<li><em><i class="fas fa-child" style="font-size: 50px;"></i></em> <span>주문완료</span></li>
				</ul>
			</div>
		<!-- //주문배송 조회 -->

		<!-- 주문 상품 목록 -->
		<div class="table_area_cart">
			<table class="tbl_type_list" summary="장바구니 리스트 테이블">
				<caption>장바구니 리스트</caption>
				<colgroup>
				<col width="">
				<col width="">
				<col width="">
				<col width="140px">
				<col width="130px">
				<col width="130px">
				<col width="90px">
				</colgroup>
				<thead>
					<tr>
						<th colspan="3" scope="col">상품명</th>
						<th scope="col">판매가</th>
						<th scope="col">수량</th>
						<th scope="col">합계</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
								
					<tr>
						<td class="check_area">
							<label for="check_select">
								<input class="i_check" type="checkbox" id="cart_idx[]" name="cart_idx[]" value="130628" checked>
								
							</label>
						</td>
						<td class="thumb_area"><a href="#"><img src="http://image.kyobobook.co.kr/images/book/large/125/l9791188621125.jpg" alt="" class="thumb" /></a></td>
						<td class="left info">
							<p class="txt_nomal"><a href="/store/books/look.php?p_code=B2901427500">알고리즘 도감 그림으로 공부하는 알고리즘 26</a></p>
						</td>
						<td>
							<p class="price">23,400원</p>
							<input type="hidden" name="price" value="23400">
							<span class="mileage">234점</span>
						</td>
						
						<td>1</td>
						
						<td class="price2">23,400원</td>
						
						<td><a href="#" class=""><i class="fas fa-trash-alt delete"></i></a></td>
					</tr>
								
					<tr>
						<td class="check_area">
							<label for="check_select">
								<input class="i_check" type="checkbox" id="cart_idx[]" name="cart_idx[]" value="130253" checked>
								<input type="hidden" id="hid_pcode[]" name="hid_pcode[]" value="B1526053540" >
							</label>
						</td>
						<td class="thumb_area"><a href=""><img src="http://image.kyobobook.co.kr/images/book/large/565/l9791160502565.jpg" alt="" class="thumb" /></a></td>
						<td class="left info">
							<p class="txt_nomal"><a href="">시나공 워드프로세서 실기(2018)</a></p>
						</td>
						<td>
							<p class="price">17,000원</p>
							<input type="hidden" name="price" value="17000">
							<span class="mileage">170점</span>								
						</td>
						
						<td>1</td>
						
						<td class="price2">17,000원</td>
						
						<td><a href="#" class=""><i class="fas fa-trash-alt delete"></i></a></td>
					</tr>
																
				</tbody>
			</table>
		</div>
		<!-- //주문 상품 목록 -->
		
				<!-- 장바구니 합계 -->
		<div class="cart_result_box">
			<ul>
				<li>주문상품 수량 :  <span id='sumTr'></span>종 [<span id="quantity"></span>개 ]</li>
				<li>예상 마일리지 적립 :  <span id='mileage'></span>점</li>
				<li>배송료 :  <span id='deliveryCost'>0</span>원</li> 
				<li>총 주문 금액 :  <span class="price" id='totalPrice'>40,400원</span></li>
			</ul>
		</div>
		<!-- //장바구니 합계 -->
		<hr>
		<!-- 할인 정보 -->
        	<p class="tit">마일리지 사용</p>
            <div class="discount_info">
                <div class="register_li">
					<input type="hidden" value="0" name="my_e_coin" id="my_e_coin"  >              	            
                    <label>
                        <input type="text" value="" name="e_coin" id="e_coin" class="i_text2" > 점		
                        <input type="button" value="적용" id="apply_mileage" class="i_button">
                        <span id="remain_ecoin">보유 마일리지 : 4,300점</span>    			
                    </label>
                                
                  	</div>
                </div>
       
        <!-- //할인 정보 -->
     
		<!-- 배송지 정보 -->
		<div class="addr_info_box">
			<p class="tit">배송지 정보</p>
			<div class="address_info" style="position:relative;">
				<fieldset>
				<legend>배송지 정보 입력</legend>
				<div class="register_addr">
                    <div class="register_li">
						<div class="i_tit"><strong>배송지 선택<span> *</span></strong></div>
						<div class="i_con">													
							
							<label class="ra_label">
								<input type="radio" name="delivery_addr" id="delivery_Orderaddr"  value="Orderaddr"  class="i_radio" checked  onclick="javascript:set_deliveryAddr();" >
								<span>주문자와 동일</span>
							</label>
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>이름<span> *</span></strong></div>
						<div class="i_con">
								<input type="text" value="" name="m_name"  id="m_name" class="i_text" >	
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>주소<span> * </span></strong></div>
							<div class="i_con">
								<input type="text" name="m_zipcode" id="m_zipcode" class="i_text">
								<input type="button" value="우편번호 검색" id="prof_zipcode" class="i_button" >
								<div class="input_space"></div>
								<input type="text" name="m_address" id="m_address" class="i_text2">
								<input type="text" name="m_address_sub" id="m_address_sub" class="i_text2"> <br>
								<span class="address_span">※ 배송주소를 다시 한번 확인해 주세요.</span>

							</div>
						</div>
                    <div class="register_li">
						<div class="i_tit"><strong>휴대전화<span> *</span></strong></div>
						<div class="i_con">
								<input type="text"  name="m_mobile_1" id="m_mobile_1" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
									-
								<input type="text"  name="m_mobile_2" id="m_mobile_2" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
							
							- 
							
								<input type="text"  name="m_mobile_3" id="m_mobile_3" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" ><br />
          						
						</div>
					</div>
                    
                    <div class="register_li">
						<div class="i_tit"><strong>일반전화</strong></div>
						<div class="i_con">
								<input type="text" name="m_phone_1" id="m_phone_1" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
									- 
								<input type="text" name="m_phone_2" id="m_phone_2" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
							
							- 
								<input type="text" name="m_phone_3" id="m_phone_3" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
							
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>배송메시지</strong></div>
						<div class="i_con">
							
								<input type="text" name="ord_comment" id="ord_comment" class="i_text4" >
                                 <span>(50자 이내 작성)</span>
							
						</div>
					</div>
				</div>
				</fieldset>
							</div>
			
		</div>
		
        
		
			<!-- 결제 정보 -->
				<div class="payment_info">
			<p class="tit">결제 정보</p>
			<dl class="payment_type">
				<dt>결제방법 선택</dt>
				<dd>
					<label class="ra_label">
						<input type="radio" name="ord_pay_method" id="ord_pay_method" class="i_radio" value="card" checked="checked" onclick="javascript:select_pay_method(0);">
						<span>신용카드</span>
					</label>
				</dd>
				<dd>
					<label class="ra_label">
						<input type="radio" name="ord_pay_method" id="ord_pay_method" class="i_radio" value="bank" onclick="javascript:select_pay_method(2);">
						<span>무통장 입금</span>
					</label>
				</dd>
				<dd>
					<label class="ra_label">
						<input type="radio" name="ord_pay_method" id="ord_pay_method" class="i_radio" value="mobile" onclick="javascript:select_pay_method(3);">
						<span>휴대폰 결제</span>
					</label>
				</dd>
			</dl>			
		</div>
				<!-- //결제 정보 -->
	
		<!-- 주문,결제 최종 정보 영역 -->
		<div class="total_info">			
			
			<input  type="hidden" id="sum_sale_price" name="sum_sale_price">
			<input  type="hidden" id="sum_ecoin_price" name="sum_ecoin_price">
			<input  type="hidden" id="sum_coupon_price" name="sum_coupon_price">
			<input  type="hidden" id="sum_total_price" name="sum_total_price" value="37800">
			<input  type="hidden" id="sum_total_mileage" name="sum_total_mileage" value="2100">
			<input  type="hidden" id="p_delivery_price" name="p_delivery_price" value="0">
			
			<!-- 주문 총액 정보 -->
			<dl class="total_order">
				<dt>주문상품 : </dt>
				<dd>총 2종 [2개]</dd>
				<dt>총 상품금액 : </dt>
				<dd>40,400원</dd>
				<dt>배송비 : </dt>
				<dd>0원</dd>
				<dt>할인금액 : </dt>
				<dd><span id="sum_st_price_show">0원</span></dd>
			</dl>
			<!-- //주문 총액 정보 -->
			
			<!-- 최종 결제 정보 -->
			<dl class="total_payment">
				<dt><strong>최종 결제 금액 :</strong></dt>
				<dd><strong><span id="sum_t_price_show">40,400원</span></strong></dd>
				<dt>최종 적립 마일리지 :</dt>
				<dd><span id="sum_st_mileage_show">404</span>점</dd>
			</dl>
			<!-- //최종 결제 정보 -->
			
			<!-- 결제하기 버튼 -->
			<label>
				<button name="bynPay" type="button" value="결제하기" class="btn_payment">결제하기</button>
			</label>
			<!-- //결제하기 버튼 -->
		</div>
		<!-- //주문,결제 최종 정보 영역 -->
		<div class="btn_area_cart" style="text-align:left;">
			<a href="myBasket.do" class="btn_white2" style="text-align:center; width:150px; font-size:14px;">&lt; 이전단계</a>
		</div>
		</div>	<!-- //itbook wrap -->
	</div>
</div>

<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
	$(function() {
		var payList		= $(".tbl_type_list tbody");
		var sumPrice	= 0,
			sumTr		= 0,
			quantity	= 0,
			saveMileage	= 0,
			delivery	= 2500;
		//alert(Number(payList.children("tr:eq(0)").children("td:eq(4)").text().trim()));
		for(var i=0; i<payList.children("tr").length; i++){
			
			sumPrice += Number(payList.children("tr:eq("+i+")").children("td").children("input[name='price']").val());
			
			quantity += Number(payList.children("tr:eq("+i+")").children("td:eq(4)").text().trim());
			
			sumTr++;
			
			$("#sumTr").text(sumTr);
			$("#quantity").text(quantity);
			
		}
		saveMileage	= Math.round(sumPrice/100);
		$("#mileage").text(saveMileage);
		
		if (sumPrice < 50000) {
			$("#deliveryCost").text("2500");
		} else {
			$("#deliveryCost").text("0");
		}
		
		$(".btn_payment").click(function() {
			var IMP = window.IMP; // 생략가능
			IMP.init('imp19176780');

			//결제창
			IMP.request_pay({
			    pg : 'inicis', // version 1.1.0부터 지원.
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '알고리즘 도감 그림으로 공부하는 알고리즘 26 외 1권',
			    amount : 1000,
			    buyer_email : 'ivvve@naver.com',
			    buyer_name : '손영철',
			    buyer_tel : '010-0000-0000'
			}, function(rsp) {
				
				if ( rsp.success ) {
					location.href = "completePay.do";
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        alert(msg);
			    }
			});
		});
	});
</script>
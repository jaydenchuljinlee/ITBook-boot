<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="/ITBook/css/mypage/mypage.css">

<script type="text/javascript">
	var phone	= '<c:out value="${user.phone}" />',
		add_1	= '<c:out value="${user.address1}" />',
		add_2	= '<c:out value="${user.address2}" />',
		add_3	= '<c:out value="${user.address3}" />',
		name	= '<c:out value="${user.name}" />';

	var totalMileage	= <c:out value="${totalMil}" />,
		delivery		= <c:out value="${delivery}"/>,
		totalFee		= <c:out value="${totalFee}" /> - delivery,
		applyMileage	= <c:out value="${totalMil}" />,
		totalQuantity	= <c:out value="${totalCnt}" />;

	$(function() {
		
		// 페이지가 처음 로딩 되었을 때, 이전 페이지로부터 가져온 전체 합계와 그에 따른 마일리지
		$("#sum_t_price_show").text(totalFee+"원");
		$("#sum_st_mileage_show").text((totalFee/100)+"점");
		
		//'주문자 정보와 일치'라는 라디오 버튼을 눌렀을 때, 유저 정보를 input에 담음
		$("#delivery_Orderaddr").on("click",function() {

			$("#m_name").val(name);
			$("#m_zipcode").val(add_1);
			$("#m_address").val(add_2);
			$("#m_address_sub").val(add_3);
			$("#m_mobile_1").val(phone.substring(0,3));
			$("#m_mobile_2").val(phone.substring(3,7));
			$("#m_mobile_3").val(phone.substring(7));
			
						
		});

		//마일리지 적용 버튼을 클릭했을 때
		$("#apply_mileage").on("click",function() {
			changeCashState()
		})

		//마일리지 input의 상태가 변화했을 때
		$("#e_coin").on("change",function() {
			changeCashState()
		})

		//마일리지 적용 취소 버튼을 눌렀을 때, 다시 페이지 로딩 상태로 변화
		$("#cancle_mileage").on("click",function() {
			$("#e_coin").val(0);

			$("#discount").text("0원");
			$("#sum_t_price_show").text(totalFee+"원");
			$("#sum_st_mileage_show").text((totalFee/100)+"점");
		})
	})
	
	function changeCashState() {
		var current = $("#e_coin").val(),
			mileage	= Number($("#remain_ecoin").text().trim());
		
		//현재 내가 적용하려는 마일리지가 내가 가지고 있는 마일리지 보다 큰지를 판단
		if (current > mileage) {
			alert("가지고 있는 마일리지가 적습니다!");
			//마일리지와 전체 합계,할인 금액을 페이지가 로딩되었을 때의 상태로 돌림
			$("#e_coin").val(0);
			$("#remain_ecoin").val(<c:out value="${user.mileage}"/>);
			$("#discount").text("0원");
			$("#sum_t_price_show").text(totalFee+"원");
			$("#sum_st_mileage_show").text((totalFee/100)+"점");
			
			return;
		}

		//적용 마일리지가 변했으므로, 할인금액,전체합계,마일리지를 변화
		$("#remain_ecoin").text(mileage-current);
		$("#discount").text(current+"원");
		$("#sum_t_price_show").text((totalFee-current)+"원");
		$("#sum_st_mileage_show").text(((totalFee-current)/100)+"점");
	}
</script>

<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="/ITBook/js/myPage/payment.js"></script>



<!-- Contents -->
<div class="product-grid-holder tc-padding2">
	<form id="payFrm" action="completePay" method="post">
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
			
				<input type="hidden" id="input_totalPrice" name="totalPrice"/>
				<input type="hidden" id="input_mileage" name="mileage"/>
				<input type="hidden" id="input_totalquantity" name="totalquantity"/>
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
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bookList}" var="book">
							
							<tr>
								<td class="check_area">
									<input class="i_check" type="hidden" id="cart_idx[]" name="isbn" value="<c:out value="${book.isbn}" />" >
								</td>
								<td class="thumb_area">
									<input type="hidden" name="thumb" value="<c:out value="${book.image}" />">
									<img src="<c:out value="${book.image}" />" alt="" class="thumb" />
								</td>
								<td class="left info">
									<p class="txt_nomal">
										<input type="hidden" class="theme" name="theme" value="<c:out value="${book.theme}" />">
										<c:out value="${book.theme}" />
									</p>
								</td>
								<td>
									<p class="price">
										<fmt:formatNumber value="${book.price}" pattern="#.###"/>
									</p>
									<input type="hidden" name="price" value="<c:out value="${book.price}" />">
								</td>
								
								<td>
									<input type="hidden" name="quantity" value="${book.quantity}"/>
									<c:out value="${book.quantity}"/>
								</td>
								
								<td id="bookTotal" class="price2">
									<c:out value="${book.price*book.quantity}"/>원
								</td>
								
								<td class="price2"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
		</div>
		<!-- //주문 상품 목록 -->
		
				<!-- 장바구니 합계 -->
		<div class="cart_result_box">
			<ul>
				<li>주문상품 수량 :  <span id='sumTr'><c:out value="${genreCnt}"/></span>종 [<span id="quantity"><c:out value="${totalCnt}"/></span>개 ]</li>
				<li>예상 마일리지 적립 :  <span id='mileage'><c:out value="${totalMil}"/></span>점</li>
				<li>배송료 :  <span id='deliveryCost'><c:out value="${delivery}"/></span>원</li> 
				<li>총 주문 금액 :  <span class="price" id='totalPrice'><c:out value="${totalFee}"/>원</span></li>
			</ul>
		</div>
		<!-- //장바구니 합계 -->
		<hr>
		<!-- 할인 정보 -->
        	<p class="tit">마일리지 사용</p>
            <div class="discount_info">
                <div class="register_li">
					<input type="hidden" name="totalMil" id="my_e_coin"  >              	            
                    <label>
                        <input type="text" value="" name="e_coin" id="e_coin" class="i_text2" > 점		
                        <input type="button" value="적용" id="apply_mileage" class="i_button">
                        <input type="button" value="취소" id="cancle_mileage" class="i_button">
                       보유 마일리지 : <span id="remain_ecoin"> <c:out value="${user.mileage}" /></span>  점  			
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
								<input type="radio" id="delivery_Orderaddr"  value="Orderaddr"  class="i_radio" >
								<span>주문자와 동일</span>
							</label>
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>이름<span> *</span></strong></div>
						<div class="i_con">
								<input type="text" value="" name="name"  id="m_name" class="i_text" >	
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>주소<span> * </span></strong></div>
							<div class="i_con">
								<input type="text" name="address1" id="m_zipcode" class="i_text">
								<input type="button" value="우편번호 검색" id="prof_zipcode" class="i_button" >
								<div class="input_space"></div>
								<input type="text" name="address2" id="m_address" class="i_text2">
								<input type="text" name="address3" id="m_address_sub" class="i_text2"> <br>
								<span class="address_span">※ 배송주소를 다시 한번 확인해 주세요.</span>

							</div>
						</div>
                    <div class="register_li">
						<div class="i_tit"><strong>휴대전화<span> *</span></strong></div>
						<div class="i_con">
							<input type="hidden" data-phone="phone" name="phone">
								<input type="text" id="m_mobile_1" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
								-
								<input type="text" id="m_mobile_2" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
								- 
								<input type="text" id="m_mobile_3" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" ><br />
          						
						</div>
					</div>
                    
                    <div class="register_li">
						<div class="i_tit"><strong>일반전화</strong></div>
						<div class="i_con">
								<input type="hidden" data-call="call" name="call">
								<input type="text" id="m_phone_1" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
								- 
								<input type="text"id="m_phone_2" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
								- 
								<input type="text"id="m_phone_3" class="i_text3" onkeyup="this.value=number_filter(this.value);" maxlength="4" >	
							
						</div>
					</div>
                    <div class="register_li">
						<div class="i_tit"><strong>배송메시지</strong></div>
						<div class="i_con">
							
								<input type="text" name="message" id="ord_comment" class="i_text4" >
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
						<input type="radio" name="method" id="ord_pay_method" class="i_radio" value="card" checked="checked" >
						<span>신용카드</span>
					</label>
				</dd>
				<dd>
					<label class="ra_label">
						<input type="radio" name="method" id="ord_pay_method" class="i_radio" value="bank" >
						<span>무통장 입금</span>
					</label>
				</dd>
				<dd>
					<label class="ra_label">
						<input type="radio" name="method" value="phone" id="ord_pay_method" class="i_radio" >
						<span>휴대폰 결제</span>
					</label>
				</dd>
			</dl>			
		</div>
				<!-- //결제 정보 -->
	
		<!-- 주문,결제 최종 정보 영역 -->
		<div class="total_info">			
			
			<!-- 주문 총액 정보 -->
			<dl class="total_order">
				<dt>주문상품 : </dt>
				<dd>총 <c:out value="${genreCnt}"/>종 [<c:out value="${totalCnt}"/>개]</dd>
				<dt>총 상품금액 : </dt>
				<dd id="totalFee"><fmt:formatNumber value="${totalFee}" pattern="#.###" />원</dd>
				<dt>배송비 : </dt>
				<dd id="delivery"><fmt:formatNumber value="${delivery}" pattern="#.###" />원</dd>
				<dt>할인금액 : </dt>
				<dd><span id="discount">0원</span></dd>
			</dl>
			<!-- //주문 총액 정보 -->
			
			<!-- 최종 결제 정보 -->
			<dl class="total_payment">
				<dt><strong>최종 결제 금액 :</strong></dt>
				<dd><strong><span id="sum_t_price_show"></span></strong></dd>
				<dt>최종 적립 마일리지 :</dt>
				<dd><span id="sum_st_mileage_show"></span></dd>
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
	</form>
</div>


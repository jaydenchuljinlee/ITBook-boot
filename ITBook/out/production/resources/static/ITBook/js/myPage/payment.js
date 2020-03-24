$(function() {
		
		$(".btn_payment").click(function() {
			
			$("#phone").val($("#m_mobile_1").val()+$("#m_mobile_2").val()+$("#m_mobile_3").val());
			$("#call").val($("#m_phone_1").val()+$("#m_phone_1").val()+$("#m_phone_1").val());
			
			$("#input_totalPrice").val(totalFee);
			$("#input_mileage").val(totalMileage);
			$("#input_totalquantity").val(totalQuantity);
			
			$("#my_e_coin").val(Number($("#remain_ecoin").text().trim()));
			
			$("#payFrm").submit();
			
			/*var IMP = window.IMP; // 생략가능
			IMP.init('imp19176780');

			
			
			//결제창
			IMP.request_pay({
			    pg : 'inicis', // version 1.1.0부터 지원.
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : $(".theme").val()+"외"+(totalQuantity-1)+"권",
			    amount : 1000,
			    buyer_email : 'ivvve@naver.com',
			    buyer_name : $("#m_name").val(),
			    buyer_tel : phone
			}, function(rsp) {
				
				if ( rsp.success ) {
					location.href = "completePay.do";
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			        alert(msg);
			    }
			});*/
		});
	});
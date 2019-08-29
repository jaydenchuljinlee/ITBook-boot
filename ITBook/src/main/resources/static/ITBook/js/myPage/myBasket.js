var transArr		= [],
	totalPrice		= 0,
	totalMileage	= 0,
	totalQuantity	= 0,
	delivery		= 0;
	

$(function() {
	
	
	
	//전체 체크박스 수량 변경
	$("#checkAll").on("click",function() {
		var valChk = $(this).prop("checked");
		
		$(".child_chk").prop('checked',this.checked);
		
		if (valChk) {
			$(".child_chk").attr("checked",true);
			
		} else {
			$(".child_chk").attr("checked",false);
		}
		
		changeTotal();
	});
	//전체 체크박스 수량 변경
	
	//단일 체크박스 수량 변경
	$(".child_chk").on("click",function() {
		var valChk = $(this).prop("checked");
		
		if (valChk) {
			$(this).attr("checked",true);
			
		} else {
			$(this).attr("checked",false);
		}
		
		
	})
	//단일 체크박스 수량 변경
	
	$(".child_chk").on("change",function() {
		changeTotal();
		
	});
	
	$("#quantity").on("change",function(){
		
		changeTotal();
	});
	
	$("#submitBtn").on("click", function() {
		
		//아무것도 선택하지 않았을 때는 결제가 이뤄지지 않아야한다.
		if (transArr.length == 0) {
			alert("상품 목록을 선택해주세요.");
			return;
		}
		
		$("#myBasketFrm").submit();
	});
})

function changeTotal() {
	totalPrice		= 0,
	totalMileage	= 0,
	totalQuantity	= 0,
	delivery		= 0;
	
	var tbody = $(".tbl_type_list").children("tbody").children();

	//tr요소들안에서 check가 된 책 요소를 갖고오는 반복문 
	$.each(tbody, function(index,item) {
		var chkBoxTd	= $(item).children(".check_area"),
			chk			= $(chkBoxTd).children().children(),
			price		= Number($(item).children("td:eq(3)").children("p").data("price")),
			quantity	= Number($(item).children("td:eq(4)").children().children().val()),
			idx			= $(chkBoxTd).data("idx");
		
		if ($(chk).attr("checked") == "checked") {
			
			transArr.push(idx);
			
			totalPrice += (price*quantity);
			totalMileage =  totalPrice/100,
			totalQuantity += quantity;
			
			$("#isbn_"+idx).attr("name","isbn");
			$("#thumb_"+idx).attr("name","thumb");
			$("#theme_"+idx).attr("name","theme");
			$("#price_"+idx).attr("name","price");
			$("#quantity_"+idx).attr("name","quantity");
			
		} else {
			transArr.splice(transArr.indexOf(idx),1);
			
			$("#isbn_"+idx).removeAttr("name");
			$("#thumb_"+idx).removeAttr("name");
			$("#theme_"+idx).removeAttr("name");
			$("#price_"+idx).removeAttr("name");
			$("#quantity_"+idx).removeAttr("name");
		}
	});
	
	$("#totalMileage").text(totalMileage+"점");
	
	$("#buyCnt").text(transArr.length+"종["+totalQuantity+"개]");
	
	if (totalPrice >= 30000) {
		delivery = 0;
		$("#deliveryCost").text(delivery+"원");
	}
	else if (totalPrice > 0 && totalPrice < 30000){
		delivery = 2500;
		$("#deliveryCost").text("2500원");
	} else {
		delivery = 0;
		$("#deliveryCost").text(delivery+"원");
	}
	$("#totalPrice").text((totalPrice+delivery)+"원");
	
	$("#delivery").val(delivery);
	$("#totalFee").val(totalPrice);
	$("#totalCnt").val(totalQuantity);
	$("#genreCnt").val(transArr.length);
	$("#totalMil").val(totalMileage);
}
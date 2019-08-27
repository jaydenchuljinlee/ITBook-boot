$(function() {
	
	$( ".detial_tabs" ).tabs();
	$(".detail_tit").css({
		"display" : "block"
	});
	
	/* 상세 수량 제한 시작 */
	$(".book_amount input").click(function(){
		
		var amountInput = $(".book_amount input").val();
	
		if(amountInput <= "0" ){
			alert("수량은 최소 1이상 입력하셔야 합니다.");
			$(".book_amount input").val("1");
		}
	})
	/* 상세 수량 제한 끝*/
		
	$("#btnAddCart").on("click",function() {
		var session = "<c:out value='${userSession}'/>";
		
		if (session == '') return;

		var form = {
				isbn : <c:out value='${book.isbn}'/>,
				user : session
		}

		$("#isbnInput").val(<c:out value='${book.isbn}'/>);
		$("#userInput").val(session);

		$("#wishNbasket").attr("action","addMyBasket");
		$("#wishNbasket").submit();
	})
});
	function hb_show_tabs(t_num) {
		
		//alert(t_num);
		var t_max = 9;
		for (var t = 1; t < t_max; t++) {
			if (t_num == 0) {
				$("#tabs_" + t).show();
				$(".detail_tit").css({
					"display" : "block"
				});
			} else {
				if (t == t_num) {
					$("#tabs_" + t).show();
					$(".detail_tit").css({
						"display" : "block"
					});
				} else {
					$("#tabs_" + t).hide();
				}
			}
		}

	}
	var tid= "";
	if(tid=="review"){	
		hb_show_tabs(5);
		document.getElementById("review_tab").scrollIntoView();
		
	}else if(tid=="misprint"){	
		hb_show_tabs(6);
		document.getElementById("misprint_tab").scrollIntoView();

	}else if(tid=="exam"){	
		hb_show_tabs(7);
		document.getElementById("exam_tab").scrollIntoView();
		
	}else{
		hb_show_tabs(0);
	}


$('#reviewPop').click(function(){
	$('#reviewPop').modal({show:true})
});
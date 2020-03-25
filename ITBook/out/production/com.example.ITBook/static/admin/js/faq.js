$( function() {
	//jq tabs ui
	var tabs = $( "#tabs" ).tabs();
	tabs.find( ".ui-tabs-nav" ).sortable({
	  axis: "x",
	  stop: function() {
	    tabs.tabs( "refresh" );
	  }
	});
	
	//새로운 tab 생성
	$("#addTabBtn").click(function() {
		var newTabTitle = $("#newTabTitle").val();
		
		if (newTabTitle === "") {
			alert("제목을 입력해주세요!");				
		} else {
			var order = $("#tabs .tabsList li").length + 1;
			
			var newTab = 
				'<li class="ui-state-default ui-corner-top ui-sortable-handle" role="tab" tabindex="-1" aria-controls="tabs-' + order + '" aria-labelledby="ui-id-' + order + '" aria-selected="false" aria-expanded="false">\
					<a href="#tabs-' + order + '" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">' + newTabTitle + '</a>\
				</li>';
			$("#tabs .tabsList").append(newTab);
			
			var newTabDiv = 
				'<div id="tabs-' + order + '" aria-labelledby="ui-id-' + order + '" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-hidden="true" style="display: block;"></div>';
			$("#tabs").append(newTabDiv);
		    
			//새로 만든 탭을 작동시켜줌
			$( "#tabs" ).tabs("refresh");
			$("#newTabTitle").val("");
			$("#newTabModal").modal("toggle")
		}
		
	});
	
	//faq 상세
	$("#tabs div p").click(function() {
		location.href = "adminFaqDetail.do";
	});
	
	//faq 내용 추가
	$("#addFaqBtn").click(function() {
		location.href = "adminFaqInsertForm.do";
	});
} );
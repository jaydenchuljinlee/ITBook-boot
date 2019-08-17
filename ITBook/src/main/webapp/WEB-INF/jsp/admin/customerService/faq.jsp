<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">FAQ</h4>
<div class="clearfix"></div>
<hr/>

<div id="tabs">
  <ul class="tabsList">
    <li><a href="#tabs-1">결제 / 환불</a></li>
    <li><a href="#tabs-2">배송</a></li>
    <li><a href="#tabs-3">중고</a></li>
    <li><a href="#tabs-4">개발자</a></li>
    <li><a href="#tabs-5">자격증</a></li>
  </ul>

  <div id="tabs-1">
    <p><a href="#">결제는 어떻게 하나요?</a></p>
    <p><a href="#">결제 수단은 어떻게 되나요?</a></p>
  </div>
  <div id="tabs-2">
  	<p><a href="#">배송은 어떻게 하나요?</a></p>
    <p><a href="#">배송 회사는 어떻게 되나요?</a></p>
  </div>
  <div id="tabs-3">
  	<p><a href="#">중고책 거래는 어떻게 하나요?</a></p>
    <p><a href="#">중고책은 어떻게 판매 신청 하나요?</a></p>
  </div>
  <div id="tabs-4">
    <p><a href="#">개발자 1</a></p>
    <p><a href="#">개발자 2</a></p>
  </div>
  <div id="tabs-5">
    <p><a href="#">자격증 1</a></p>
    <p><a href="#">자격증 2</a></p>
    <p><a href="#">자격증 3</a></p>
    <p><a href="#">자격증 4</a></p>
    <p><a href="#">자격증 5</a></p>
    <p><a href="#">자격증 6</a></p>
  </div>
</div>
<br/>
<div>
	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newTabModal">
		FAQ 탭 추가
	</button>
	<button class="btn btn-success btn-lg">
		현재 순서 저장
	</button>
	<button id="addFaqBtn" class="btn btn-info btn-lg">
		FAQ 항목 추가
	</button>
</div>

<!-- add tab modal  -->
<div class="modal fade" id="newTabModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">FAQ 탭 추가</h4>
      </div>
      <div class="modal-body">
        <input type="text" id="newTabTitle" placeholder="FAQ 탭 제목"><br/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        <button id="addTabBtn" type="button" class="btn btn-primary">저장</button>
      </div>
    </div>
  </div>
</div>
<!--/ add tab modal -->

<script type="text/javascript" src="js/admin/faq.js"></script>
<script type="text/javascript" src="js/contextMenu.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/contextMenu.min.css">
<script type="text/javascript">
$(function() {
	$.contextMenu({
	    selector: '.ui-sortable-handle', 
	    callback: function(key, options) {
	    	if (key === "edit") {
	    		
	    	} else {
	    		$(this).remove();
	    	}
	    },
	    items: {
	        "edit": {name: "Edit", icon: "edit"},
	        "delete": {name: "Delete", icon: function(){
	            return 'context-menu-icon context-menu-icon-quit';
	        }}
	    }
	});

	$('.context-menu-one').on('click', function(e){
	    console.log('clicked', this);
	});
});
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">이벤트</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">이벤트 목록</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
							  <th>#</th>
							  <th>제목</th>
							  <th>대상</th>
							  <th>시작일</th>
							  <th>종료일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							  	<td>1</td>
							  	<td class="eventDetail"><a href="#">IT Book 머그컵 2018 Edition</a></td>
							  	<th>5만원 이상</th>
							  	<td>2018.02.10</td>
							  	<td>2019.02.10</td>
							</tr>
							<tr>
							  	<td>2</td>
							  	<td class="eventDetail"><a href="#">코딩 교육 이벤트</a></td>
							  	<td>교육</td>
							  	<td>2018.02.10</td>
							  	<td>2019.02.10</td>
							</tr>
							<tr>
							  	<td>3</td>
							  	<td class="eventDetail"><a href="#">파이썬 관련 서적 구매 시 기프티콘 증정</a></td>
							  	<td>파이썬</td>
							  	<td>2018.02.10</td>
							  	<td>2019.02.10</td>
							</tr>
							<tr>
							  	<td>4</td>
							  	<td class="eventDetail"><a href="#">3만원 이상 구매 시 마우스패드 증정</a></td>
							  	<td>3만원 이상</td>
							  	<td>2018.02.10</td>
							  	<td>2019.02.10</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<ul class="pagination pull-left">
				  <li id="addEventBtn"><a href="#">새 이벤트 등록</a></li>
				</ul>
				<ul class="pagination pull-right">
				  <li><a href="#">Prev</a></li>
				  <li><a href="#">1</a></li>
				  <li><a href="#">2</a></li>
				  <li><a href="#">3</a></li>
				  <li><a href="#">4</a></li>
				  <li><a href="#">Next</a></li>
				</ul>
				<div class="clearfix"></div> 
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function() {
	$(".eventDetail").click(function() {
		location.href = "adminEventDetail.do";
	});
	
	$("#addEventBtn").click(function() {
		location.href = "adminEventInsertForm.do";
	});
});
</script>
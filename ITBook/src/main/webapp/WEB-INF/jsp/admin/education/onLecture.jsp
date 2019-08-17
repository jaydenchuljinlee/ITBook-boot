<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">온라인 강의</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">온라인 강의 목록</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>URL</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							  	<td>10</td>
							  	<td class="onLectureDetail"><a href="#">[30강]파이썬 강좌</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td class="onLectureDetail"><a href="#">[90강] C언어 강좌</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>8</td>
							  	<td class="onLectureDetail"><a href="#">[30일] 자바스크립트 완성</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>7</td>
							  	<td class="onLectureDetail"><a href="#">[33강] 네트워크</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>6</td>
							  	<td class="onLectureDetail"><a href="#">[57강] 리눅스 강의</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>5</td>
							  	<td class="onLectureDetail"><a href="#">[30강]파이썬 강좌</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>10</td>
							  	<td class="onLectureDetail"><a href="#">[30강]파이썬 강좌</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td class="onLectureDetail"><a href="#">[90강] C언어 강좌</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>8</td>
							  	<td class="onLectureDetail"><a href="#">[30일] 자바스크립트 완성</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>7</td>
							  	<td class="onLectureDetail"><a href="#">[33강] 네트워크</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
							<tr>
							  	<td>6</td>
							  	<td class="onLectureDetail"><a href="#">[57강] 리눅스 강의</a></td>
							  	<th><a href="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<ul class="pagination pull-left">
				  <li id="addOnLectureBtn"><a href="#">새 온라인 강의 등록</a></li>
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
	$(".onLectureDetail").click(function() {
		location.href = "adminOnLectureDetail.do";
	});
	
	$("#addOnLectureBtn").click(function() {
		location.href = "adminOnLectureInsertForm.do";
	});
});
</script>

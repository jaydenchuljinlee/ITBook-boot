<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">오프라인 강의</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">오프라인 강의 목록</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>#</th>
								<th>제목</th>
								<th>주최자</th>
								<th>날짜</th>
								<th>시간</th>
								<th>
									<select id="option">
										<option value="">전체</option>
										<option value="pass">승인</option>
										<option value="wait">대기</option>
										<option value="deny">거부</option>
									</select>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							  	<td>10</td>
							  	<td class="offLectureDetail"><a href="#">[32차] 대한민국 개발자의 생존전략 2.17</a></td>
							  	<th>한큐</th>
							  	<td>2018-03-13</td>
							  	<td>09:00 ~ 13:00</td>
							  	<td><span class="label label-success">승인</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td class="offLectureDetail"><a href="#">김왼손의 미운코딩새끼:4시간만에 끝내는 파이썬 기초</a></td>
							  	<th>김왼손</th>
							  	<td>2018-03-11</td>
							  	<td>14:00 ~ 18:00</td>
							  	<td><span class="label label-info">대기</span></td>
							</tr>
							<tr>
							  	<td>8</td>
							  	<td class="offLectureDetail"><a href="#">[32차] 대한민국 개발자의 생존전략 2.17</a></td>
							  	<th>한큐</th>
							  	<td>2018-03-13</td>
							  	<td>09:00 ~ 13:00</td>
							  	<td><span class="label label-important">거부</span></td>
							</tr>
							<tr>
							  	<td>7</td>
							  	<td class="offLectureDetail"><a href="#">김왼손의 미운코딩새끼:4시간만에 끝내는 파이썬 기초</a></td>
							  	<th>김왼손</th>
							  	<td>2018-03-11</td>
							  	<td>14:00 ~ 18:00</td>
							  	<td><span class="label label-success">승인</span></td>
							</tr>
							<tr>
							  	<td>6</td>
							  	<td class="offLectureDetail"><a href="#">[32차] 대한민국 개발자의 생존전략 2.17</a></td>
							  	<th>한큐</th>
							  	<td>2018-03-13</td>
							  	<td>09:00 ~ 13:00</td>
							  	<td><span class="label label-info">대기</span></td>
							</tr>
							<tr>
							  	<td>5</td>
							  	<td class="offLectureDetail"><a href="#">김왼손의 미운코딩새끼:4시간만에 끝내는 파이썬 기초</a></td>
							  	<th>김왼손</th>
							  	<td>2018-03-11</td>
							  	<td>14:00 ~ 18:00</td>
							  	<td><span class="label label-important">거부</span></td>
							</tr>
							<tr>
							  	<td>4</td>
							  	<td class="offLectureDetail"><a href="#">[32차] 대한민국 개발자의 생존전략 2.17</a></td>
							  	<th>한큐</th>
							  	<td>2018-03-13</td>
							  	<td>09:00 ~ 13:00</td>
							  	<td><span class="label label-success">승인</span></td>
							</tr>
							<tr>
							  	<td>3</td>
							  	<td class="offLectureDetail"><a href="#">김왼손의 미운코딩새끼:4시간만에 끝내는 파이썬 기초</a></td>
							  	<th>김왼손</th>
							  	<td>2018-03-11</td>
							  	<td>14:00 ~ 18:00</td>
							  	<td><span class="label label-info">대기</span></td>
							</tr>
							<tr>
							  	<td>2</td>
							  	<td class="offLectureDetail"><a href="#">[32차] 대한민국 개발자의 생존전략 2.17</a></td>
							  	<th>한큐</th>
							  	<td>2018-03-13</td>
							  	<td>09:00 ~ 13:00</td>
							  	<td><span class="label label-important">거부</span></td>
							</tr>
							<tr>
							  	<td>1</td>
							  	<td class="offLectureDetail"><a href="#">김왼손의 미운코딩새끼:4시간만에 끝내는 파이썬 기초</a></td>
							  	<th>김왼손</th>
							  	<td>2018-03-11</td>
							  	<td>14:00 ~ 18:00</td>
							  	<td><span class="label label-success">승인</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<ul class="pagination pull-left">
				  <li id="addOffLectureBtn"><a href="#">새 오프라인 강의 등록</a></li>
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
	$(".offLectureDetail").click(function() {
		location.href = "adminOffLectureDetail.do";
	});
	
	$("#addOffLectureBtn").click(function() {
		location.href = "adminOffLectureInsertForm.do";
	});
});
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">IT 뉴스</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">IT 뉴스 목록</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
							  <th>#</th>
							  <th>제목</th>
							  <th>기자</th>
							  <th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							  	<td>10</td>
							  	<td class="seminarDetail"><a href="#">애플의 차세대 디스플레이 혁신 “마이크로LED로”</a></td>
							  	<th>김종영</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td class="seminarDetail"><a href="#">“낟알 크기 컴퓨터로 모조품 잡는다” 초소형 블록체인 컴퓨터 ‘크립토앵커’</a></td>
							  	<th>이철진</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>8</td>
							  	<td class="seminarDetail"><a href="#">업데이트 : 페이스북 계정을 삭제하거나 비활성화하거나 제한하는 방법</a></td>
							  	<th>백가희</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>7</td>
							  	<td class="seminarDetail"><a href="#">AMD, 라이젠 취약점 인정…정기 BIOS 업데이트 쉽게 수정</a></td>
							  	<th>오희진</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>6</td>
							  	<td class="seminarDetail"><a href="#">글로벌 칼럼 | 터치스크린 키보드가 노트북 키보드의 미래가 될 이유</a></td>
							  	<th>홍정석</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>5</td>
							  	<td class="seminarDetail"><a href="#">"시장 경쟁에서 어떤 동물이 될 것인가" 클라우드 컴퓨팅 전략의 핵심 질문</a></td>
							  	<th>김태민</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>4</td>
							  	<td class="seminarDetail"><a href="#">애플의 차세대 디스플레이 혁신 “마이크로LED로”</a></td>
							  	<th>김종영</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>3</td>
							  	<td class="seminarDetail"><a href="#">“낟알 크기 컴퓨터로 모조품 잡는다” 초소형 블록체인 컴퓨터 ‘크립토앵커’</a></td>
							  	<th>이철진</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>2</td>
							  	<td class="seminarDetail"><a href="#">업데이트 : 페이스북 계정을 삭제하거나 비활성화하거나 제한하는 방법</a></td>
							  	<th>백가희</th>
							  	<td>2018.03.13</td>
							</tr>
							<tr>
							  	<td>1</td>
							  	<td class="seminarDetail"><a href="#">AMD, 라이젠 취약점 인정…정기 BIOS 업데이트 쉽게 수정</a></td>
							  	<th>오희진</th>
							  	<td>2018.03.13</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<ul class="pagination pull-left">
				  <li id="addSeminarBtn"><a href="#">새 IT 뉴스 등록</a></li>
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
	$(".seminarDetail").click(function() {
		location.href = "adminItNewsDetail.do";
	});
	
	$("#addSeminarBtn").click(function() {
		location.href = "adminItNewsInsertForm.do";
	});
});
</script>

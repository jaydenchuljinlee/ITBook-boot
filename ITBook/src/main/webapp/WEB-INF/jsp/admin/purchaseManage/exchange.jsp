<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">교환 내역</h4>
<div class="clearfix"></div>
<hr/>
<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">교환 목록</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>#</th>
								<th>결제 번호</th>
								<th>ID</th>
								<th>이름</th>
								<th>교환 내역</th>
								<th>신청일</th>
								<th>
									<select>
									 		<option>전체</option>
									 		<option>교환 대기</option>
									 		<option>교환 완료</option>
									</select>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>10</td>
								<td>pay201802100001</td>
								<td>test10</td>
								<td>테스트10</td>
								<td><a id="pay3" class="refundDetail" href="#">자바의 정석 외 3권</a></td>
								<td>2018-02-10</td>
								<td><span class="label label-info">교환 대기</span></td>
							</tr>
							<tr>
								<td>9</td>
								<td>pay201802100002</td>
								<td>test9</td>
								<td>테스트9</td>
								<td>Do it</td>
								<td>2018-02-10</td>
								<td><span class="label label-success">교환 완료</span></td>
							</tr>
							<tr>
								<td>8</td>
								<td>pay201802100001</td>
								<td>test8</td>
								<td>테스트8</td>
								<td><a id="pay3" class="refundDetail" href="#">자바의 정석 외 3권</a></td>
								<td>2018-02-10</td>
								<td><span class="label label-info">교환 대기</span></td>
							</tr>
							<tr>
								<td>7</td>
								<td>pay201802100002</td>
								<td>test7</td>
								<td>테스트7</td>
								<td>Do it</td>
								<td>2018-02-10</td>
								<td><span class="label label-success">교환 완료</span></td>
							</tr>
							<tr>
								<td>6</td>
								<td>pay201802100001</td>
								<td>test6</td>
								<td>테스트6</td>
								<td><a id="pay3" class="refundDetail" href="#">자바의 정석 외 3권</a></td>
								<td>2018-02-10</td>
								<td><span class="label label-info">교환 대기</span></td>
							</tr>
							<tr>
								<td>9</td>
								<td>pay201802100002</td>
								<td>test9</td>
								<td>테스트9</td>
								<td>Do it</td>
								<td>2018-02-10</td>
								<td><span class="label label-success">교환 완료</span></td>
							</tr>
							<tr>
								<td>4</td>
								<td>pay201802100001</td>
								<td>test4</td>
								<td>테스트4</td>
								<td><a id="pay3" class="refundDetail" href="#">자바의 정석 외 3권</a></td>
								<td>2018-02-10</td>
								<td><span class="label label-info">교환 대기</span></td>
							</tr>
							<tr>
								<td>3</td>
								<td>pay201802100002</td>
								<td>test3</td>
								<td>테스트3</td>
								<td>Do it</td>
								<td>2018-02-10</td>
								<td><span class="label label-success">교환 완료</span></td>
							</tr>
							<tr>
								<td>2</td>
								<td>pay201802100001</td>
								<td>test2</td>
								<td>테스트2</td>
								<td><a id="pay3" class="refundDetail" href="#">자바의 정석 외 3권</a></td>
								<td>2018-02-10</td>
								<td><span class="label label-info">교환 대기</span></td>
							</tr>
							<tr>
								<td>1</td>
								<td>pay201802100001</td>
								<td>test1</td>
								<td>테스트1</td>
								<td><a id="pay3" class="refundDetail" href="#">자바의 정석 외 3권</a></td>
								<td>2018-02-10</td>
								<td><span class="label label-info">교환 대기</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<div class="pull-left">
					<form>
						<input type="text" name="keyword" placeholder="검색어를 입력해주세요">
						<button>검색</button>
					</form>
				</div>
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
	$(".refundDetail").click(function() {
		var payCode = $(this).attr("id");
		location.href = "adminRefundDetail.do?payCode=" + payCode;
	});
});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4 class="pull-left">판매 신청 목록</h4>
<div class="clearfix"></div>
<hr/>
<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">판매신청</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>#</th>
								<th>ID</th>
								<th>이름</th>
								<th>송장번호</th>
								<th>내역</th>
								<th>신청날짜</th>
								<th>
									<select>
										<option>전체</option>
										<option>대기</option>
										<option>처리 완료</option>
									</select>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>test1</td>
								<td>테스트1</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-important">대기</span></td>
							</tr>
							<tr>
								<td>2</td>
								<td>test2</td>
								<td>테스트2</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-success">처리 완료</span></td>
							</tr>
							<tr>
								<td>1</td>
								<td>test1</td>
								<td>테스트1</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-important">대기</span></td>
							</tr>
							<tr>
								<td>2</td>
								<td>test2</td>
								<td>테스트2</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-success">처리 완료</span></td>
							</tr>
							<tr>
								<td>1</td>
								<td>test1</td>
								<td>테스트1</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-important">대기</span></td>
							</tr>
							<tr>
								<td>2</td>
								<td>test2</td>
								<td>테스트2</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-success">처리 완료</span></td>
							</tr>
							<tr>
								<td>1</td>
								<td>test1</td>
								<td>테스트1</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-important">대기</span></td>
							</tr>
							<tr>
								<td>2</td>
								<td>test2</td>
								<td>테스트2</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-success">처리 완료</span></td>
							</tr>
							<tr>
								<td>1</td>
								<td>test1</td>
								<td>테스트1</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-important">대기</span></td>
							</tr>
							<tr>
								<td>2</td>
								<td>test2</td>
								<td>테스트2</td>
								<td>0123456789</td>
								<td><a class="requestDetail" href="#">프로그래머를 위한 베이지안 with 파이썬 외 3권</a></td>
								<td>2018-03-18</td>
								<td><span class="label label-success">처리 완료</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<div class="pull-left">
					<form action="#">
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
	$(".requestDetail").click(function() {
		location.href = "usedSellRequestDetail.do";
	});
});
</script>
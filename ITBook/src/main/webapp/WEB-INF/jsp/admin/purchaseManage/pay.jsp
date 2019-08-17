<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4 class="pull-left">결제 내역</h4>
<div class="clearfix"></div>
<hr/>
<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">결제 목록</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>#</th>
							  	<th>결제 번호</th>
							  	<th>ID</th>
							  	<th>이름</th>
							  	<th>결제 내역</th>
							  	<th>결제 금액</th>
							  	<th>결제 방법</th>
							  	<th>결제일</th>
							  	<th>
							  		<select>
							  			<option value="">전체</option>
								  		<option value="wait">입금 대기</option>
								  		<option value="done">결제 완료</option>
								  		<option value="cancel">결제 취소</option>
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
							  	<td><a id="pay1" class="payDetail" href="#">자바의 정석 외 3권</a></td>
							  	<td><fmt:formatNumber pattern="###,###원" value="35000"/></td>
							  	<td>카드</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-success">결제 완료</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td><a id="pay1" class="payDetail" href="#">jQuery CookBook</a></td>
							  	<td><fmt:formatNumber pattern="###,###원" value="10000"/></td>
							  	<td>무통장 입금</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-info">입금 대기</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td><a id="pay1" class="payDetail" href="#">자바의 정석 외 3권</a></td>
							  	<td><fmt:formatNumber pattern="###,###원" value="35000"/></td>
							  	<td>카드</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-success">결제 완료</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td>jQuery CookBook</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="10000"/></td>
							  	<td>무통장 입금</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-info">입금 대기</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td>자바의 정석 외 3권</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="35000"/></td>
							  	<td>카드</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-success">결제 완료</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td>jQuery CookBook</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="10000"/></td>
							  	<td>무통장 입금</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-info">입금 대기</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td>자바의 정석 외 3권</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="35000"/></td>
							  	<td>카드</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-success">결제 완료</span></td>
							</tr>
							<tr>
							  	<td>9</td>
							  	<td>pay201802100001</td>
							  	<td>test9</td>
							  	<td>테스트9</td>
							  	<td>jQuery CookBook</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="10000"/></td>
							  	<td>무통장 입금</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-important">결제 취소</span></td>
							</tr>
							<tr>
							  	<td>2</td>
							  	<td>pay201802100001</td>
							  	<td>test2</td>
							  	<td>테스트2</td>
							  	<td>자바의 정석 외 3권</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="35000"/></td>
							  	<td>카드</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-success">결제 완료</span></td>
							</tr>
							<tr>
							  	<td>1</td>
							  	<td>pay201802100001</td>
							  	<td>test1</td>
							  	<td>테스트1</td>
							  	<td>jQuery CookBook</td>
							  	<td><fmt:formatNumber pattern="###,###원" value="10000"/></td>
							  	<td>무통장 입금</td>
							  	<td>2018-02-10</td>
							  	<td><span class="label label-success">결제 완료</span></td>
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
	
	$(".payDetail").click(function() {
		var payCode = $(this).attr("id");
		location.href = "adminPayDetail.do?payCode=" + payCode;
	});
});
</script>
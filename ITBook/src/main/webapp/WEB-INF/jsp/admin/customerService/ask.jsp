<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h4 class="pull-left">1:1 문의</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-12">
		<div class="widget wviolet">
			<div class="widget-head">
				<div class="pull-left">1:1 문의 목록</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered " style="width: 100%;">
						<thead>
							<tr>
								<th style="width:6%;">#</th>
								<th style="width:10%;">회원번호</th>
								<th style="width:13%;">질문 유형</th>
								<th style="width:40%;">제목</th>
								<th style="width:10%;">문의날짜</th>
								<th style="width:10%;">
									<select>
								  		<option>전체</option>
								  		<option>답변 대기</option>
								  		<option>답변 완료</option>
									</select>
								</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach items="${oneAskList}" var="oneAskList">
							<tr>
							  <td>${oneAskList.question_NO}</td>
							  <td>회원아이디</td>
							  <td>${oneAskList.q_type}</td>
							  <td id="${oneAskList.question_NO}" class="askDetail"><a href="#">${oneAskList.q_title}</a></td>
							  <td>${oneAskList.q_date_create}</td>
							  <c:if test="${oneAskList.whether_answer eq '1'}">
							  <td><span class="label label-success">답변완료</span></td>
							  </c:if>
							  <c:if test="${oneAskList.whether_answer eq '0'}">
							  <td><span class="label label-important">답변대기</span></td>
							  </c:if>
							</tr>
							 </c:forEach>
							<!-- <tr>
							  <td>4</td>
							  <td>test4</td>
							  <td>결제</td>
							  <td id="ask2" class="askDetail"><a href="#">카드 결제가 안되요</a></td>
							  <td>2018-03-05</td>
							  <td><span class="label label-success">답변 완료</span></td>
							</tr>
							<tr>
							  <td>3</td>
							  <td>test3</td>
							  <td>중고</td>
							  <td id="ask3" class="askDetail"><a href="#">중고 책 판매 문제</a></td>
							  <td>2018-03-05</td>
							  <td><span class="label label-success">답변 완료</span></td>
							</tr>
							<tr>
							  <td>2</td>
							  <td>test2</td>
							  <td>회원</td>
							  <td id="ask4" class="askDetail"><a href="#">탈퇴가 안되요</a></td>
							  <td>2018-03-05</td>
							  <td><span class="label label-success">답변 완료</span></td>
							</tr>
							<tr>
							  <td>1</td>
							  <td>test1</td>
							  <td>기타</td>
							  <td id="ask5" class="askDetail"><a href="#">마일리지가 안써져요</a></td>
							  <td>2018-03-05</td>
							  <td><span class="label label-important">답변 대기</span></td>
							</tr>       -->
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
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
$(".askDetail").click(function() {
	location.href = "adminAskDetail.do?askNo=" + $(this).attr("id");
});
</script>
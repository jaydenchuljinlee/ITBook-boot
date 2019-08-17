<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4 class="pull-left">회원 목록</h4>
<div class="clearfix"></div>
<hr/>
<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
			  <div class="pull-left">회원</div>
			  <div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
							  <th>회원 번호</th>
							  <th>아이디</th>
							  <th>이름</th>
							  <th>이메일</th>
							  <th>등급</th>
							  <th>가입일</th>
							  <th>탈퇴일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							  <td>1</td>
							  <td>test1</td>
							  <td>테스트1</td>
							  <td>test1@gmail.com</td>
							  <td>브론즈</td>
							  <td>2018.03.18</td>
							  <td></td>
							</tr>
							<tr>
							  <td>2</td>
							  <td>test2</td>
							  <td>테스트2</td>
							  <td>test2@gmail.com</td>
							  <td>실버</td>
							  <td>2018.03.18</td>
							  <td></td>
							</tr>
							<tr>
							  <td>3</td>
							  <td>test3</td>
							  <td>테스트3</td>
							  <td>test2@gmail.com</td>
							  <td>탈퇴</td>
							  <td>2018.03.18</td>
							  <td>2018.03.20</td>
							</tr>
							<tr>
							  <td>1</td>
							  <td>test1</td>
							  <td>테스트1</td>
							  <td>test1@gmail.com</td>
							  <td>브론즈</td>
							  <td>2018.03.18</td>
							  <td></td>
							</tr>
							<tr>
							  <td>2</td>
							  <td>test2</td>
							  <td>테스트2</td>
							  <td>test2@gmail.com</td>
							  <td>실버</td>
							  <td>2018.03.18</td>
							  <td></td>
							</tr>
							<tr>
							  <td>3</td>
							  <td>test3</td>
							  <td>테스트3</td>
							  <td>test2@gmail.com</td>
							  <td>탈퇴</td>
							  <td>2018.03.18</td>
							  <td>2018.03.20</td>
							</tr>
							<tr>
							  <td>4</td>
							  <td>test4</td>
							  <td>테스트4</td>
							  <td>test4@gmail.com</td>
							  <td>플래티넘</td>
							  <td>2018.03.01</td>
							  <td></td>
							</tr>
							<tr>
							  <td>2</td>
							  <td>test2</td>
							  <td>테스트2</td>
							  <td>test2@gmail.com</td>
							  <td>실버</td>
							  <td>2018.03.18</td>
							  <td></td>
							</tr>
							<tr>
							  <td>3</td>
							  <td>test3</td>
							  <td>테스트3</td>
							  <td>test2@gmail.com</td>
							  <td>탈퇴</td>
							  <td>2018.03.18</td>
							  <td>2018.03.20</td>
							</tr>
							<tr>
							  <td>4</td>
							  <td>test4</td>
							  <td>테스트4</td>
							  <td>test4@gmail.com</td>
							  <td>플래티넘</td>
							  <td>2018.03.01</td>
							  <td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<div class="pull-left">
					<form action="adminMember.do">
						<input type="text" name="keyword" placeholder="검색어를 입력해주세요">
						<button>검색</button>
					</form>
				</div>
				<ul class="pagination pull-right">
					<c:if test="${!empty memberList }">
						<li id="prevBtn"><a href="#">Prev</a></li>
					  	<c:forEach begin="${startPage }" end="${endPage }" var="page">
							<li class="page"><a href="#">${page }</a></li>
					  	</c:forEach>
					  	<li id="nextBtn"><a href="#">Next</a></li>
					</c:if>
				</ul>
				<div class="clearfix"></div> 
			</div>
		</div>
	</div>
</div>

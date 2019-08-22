<%@ page language="java" contentType="text/html; charset=UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h4 class="pull-left">도서 관리</h4>
<div class="clearfix"></div>
<hr />
<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
				<div class="pull-left">도서 목록</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content medias">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<col width="50">
						<col width="250">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<col width="50">
						<thead>
							<tr>
								<th>표지</th>
								<th>제목</th>
								<th>ISBN</th>
								<th>저자</th>
								<th>출판사</th>
								<th>출판일</th>
								<th>가격</th>
								<th>재고</th>
							</tr>
						</thead>
						<c:forEach items="${adminBookList}" var="adminBookList" varStatus="status">
						<tbody>
							<tr>
								<td><img src="${adminBookList.image}"></td>
								<td id="${adminBookList.isbn}" class="bookDetail"><a href="#">${adminBookList.theme}</a></td>
								<td>${adminBookList.isbn}</td>
								<td>${adminBookList.author}</td>
								<td>${adminBookList.publish}</td>
								<td>${adminBookList.publishdate}</td>
								<td><fmt:formatNumber pattern="###,###" value="${adminBookList.price}"/></td>
								<td>${adminBookList.quantity}</td>
							</tr>
						</tbody>
						</c:forEach>							
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<div class="pull-left">
					<form action="#">
						<input type="text" name="keyword" placeholder="검색어를 입력해주세요">
						<button>검색</button>
						<button type="button" id="bookRegisterBtn" class="btn btn-success">도서 등록</button>
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

	var bookCheck = "${bookCheck}";

	console.log(bookCheck);
	
	/* if (bookCheck == 1) {
		alert("이미 존재하는 책입니다.");
	} else if (bookCheck == 0) {
		alert("책 등록이 완료되었습니다.");
	} */
	
	$("#bookRegisterBtn").click(function() {
		location.href = "adminBookRegister.do";
	});
	
	$(".bookDetail").click(function() {
		var isbn = $(this).attr("id").slice(4);
		location.href = "adminBookDetail?isbn=" + isbn;
	});
});
</script>
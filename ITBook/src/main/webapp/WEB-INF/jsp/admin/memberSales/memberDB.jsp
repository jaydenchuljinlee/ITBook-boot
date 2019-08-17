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
							<c:forEach items="${memberList }" var="memberList">
								<tr>
								  <td><c:out value="${memberList.memberNo }"/></td>
								  <td><c:out value="${memberList.memberId }"/></td>
								  <td><c:out value="${memberList.memberName }"/></td>
								  <td><c:out value="${memberList.memberEmail }"/></td>
								  <td><c:out value="${memberList.memberGrade }"/></td>
								  <td><fmt:formatDate value="${memberList.memberEnterDate }" pattern="YYYY.MM.dd"/></td>
								  <td><fmt:formatDate value="${memberList.memberLeaveDate }" pattern="YYYY.MM.dd"/></td>
								</tr>
							</c:forEach>
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

<script type="text/javascript">
$(function() {
	//페이지 하이라이트
	var page = "<c:out value="${param.page}"/>";
	
	if (page === "") {
		$(".page").eq(0).addClass("active");
	} else {
		
		$(".page").each(function() {
			
			if($(this).text() === page) {
				$(this).addClass("active");
				return false;
		    }
			
		});

	}
	
	//페이지 버튼 클릭
	var keyword = "<c:out value="${param.keyword}"/>";
	
	$(".page").click(function() {
		var page = $(this).text();
		var url = "adminMember.do?page=" + page;
		
		if (url !== "") {
			url += "&keyword=" + keyword;
		}
		
		location.href = "adminMember.do?page=" + page;
	});
	
	var totalPage = <c:out value="${totalPage}"/>;
	var startPage = <c:out value="${startPage}"/>;
	var endPage = <c:out value="${endPage}"/>;
	
	//prev 버튼 클릭
	$("#prevBtn").click(function() {
		var url = "";
		
		if (startPage > 10) {
			url = "adminMember.do?page=" + (startPage - 10);
		} else {
			url = "adminMember.do?page=" + 1;
		}
		
		if (keyword !== "") {
			url += "&keyword=" + keyword;
		}
		
		location.href = url;
		
	});
		
	//next 버튼 클릭
	$("#nextBtn").click(function() {
		var url = "";
		
		if (endPage === totalPage) {
			url = "adminMember.do?page=" + totalPage;
		} else {
			url = "adminMember.do?page=" + (startPage + 10);
		}
		
		if (keyword !== "") {
			url += "&keyword=" + keyword;
		}
		
		location.href = url;
		
	});

});
</script>
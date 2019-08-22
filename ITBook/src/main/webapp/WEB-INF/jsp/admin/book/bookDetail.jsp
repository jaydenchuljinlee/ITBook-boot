<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">

	$(function() {
		var bcategory = '<c:out value="${bcategory.code}"/>';
		var scategory = '<c:out value="${scategory.code}"/>';

		$("#category1").children().eq(bcategory-1).attr("selected","selected");
		$("#category2").children().eq(scategory-1).attr("selected","selected");
	})

	
</script>

<script type="text/javascript" src="/admin/js/book/bookDetail.js"></script>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<h4 class="pull-left">도서 상세 페이지</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left"><c:out value="${book.theme}" /></div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form class="form-horizontal" role="form">
						<input type="hidden" id="isbn" name="isbn">
						<div class="form-group">
							<label class="col-md-2 control-label">표지</label>
							<div class="col-md-8">
								<img id="thumbnail" width="300" src="${book.image}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" id="title" class="form-control" value="${book.theme}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">원제</label>
							<div class="col-md-8">
								<input type="text" id="original" class="form-control" value="${book.original}" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">ISBN</label>
							<div class="col-md-8">
								<input type="text" id="isbn" class="form-control" value="${book.isbn}" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자</label>
							<div class="col-md-8">
								<input type="text" id="author" class="form-control" value="${book.author}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">역자</label>
							<div class="col-md-8">
								<input type="text" id="translator" class="form-control" value="${book.translator}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판사</label>
							<div class="col-md-8">
								<input type="text" id="publish" class="form-control" value="${book.publish}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판일</label>
							<div class="col-md-8">
								<input type="date" id="publishdate" class="form-control" value="${book.publishdate}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">가격</label>
							<div class="col-md-8">
								<input type="text" id="price" class="form-control" value="${book.price}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">페이지</label>
							<div class="col-md-8">
								<input type="text" id="page" class="form-control" value="${book.page}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">소개</label>
							<div class="col-md-8">
								<textarea id="info" class="form-control" rows="10">
									<c:out value="${book.intro}"/>							
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">목차</label>
							<div class="col-md-8">
								<textarea id="contents" class="form-control" rows="10">
									<c:out value="${book.contents}"/>	
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자 소개</label>
							<div class="col-md-8">
								<textarea id="authorinfo" class="form-control" rows="10">
									<c:out value="${book.authorinfo}"/>
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">수량</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="${book.quantity}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">분류</label>
							<div class="col-md-8">
								<select id="category1">
									<c:forEach items="${category1}" var="parent" >
										<option value="${parent.code}">${parent.name}</option>
									</c:forEach>
								</select>
								<select id="category2">
									<c:forEach items="${category2}" var="child" >
										<option value="${child.code}">${child.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button type="button" class="btn btn-success">수정</button>
								<button type="button" class="btn btn-danger">삭제</button>
								<button type="button" class="btn btn-warning">취소</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<script type="text/javascript">

	var checkMap	= new Map();
		isChangeB	= false,
		isChangeC	= false;
		
	

	$(function() {
		
		var bcategory = '<c:out value="${bcategory.code}"/>';
		var scategory = '<c:out value="${scategory.code}"/>';

		$("#category1").children().eq(bcategory-1).attr("selected","selected");
		$("#category2").children().eq(scategory-1).attr("selected","selected");

		$(".book-frm").on("change",function() {
			
			checkMap.set($(this).attr("name"),true);
			
		})

		$("#update").on("click",function() {
			
			for (var key of checkMap.keys()) {

				if (key == "category1" || key == "category2") isChangeC = true;
				else isChangeB = true;
			}

			if (!(isChangeC || isChangeB)) {
				var rtnPage = confirm("수정된 사항이 없습니다! 목록으로 돌아가시겠습니까?");

				if (rtnPage) location.href = "adminBookMain";
			} else {
				$("#isChangeB").val(isChangeB);
				$("#isChangeC").val(isChangeC);

				$("#updateFrm").attr("action","adminBookUpdate");
				$("#updateFrm").submit();
			}

			
			
		})
	})

	
</script>

<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/admin/js/book/bookDetail.js"></script>

<h4 class="pull-left">도서 상세 페이지</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left book-frm"><c:out value="${book.theme}" /></div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form id="updateFrm" class="form-horizontal" role="form" method="post">
						<input type="hidden" id="isChangeB" name="isChangeB">
						<input type="hidden" id="isChangeC" name="isChangeC">
						<div class="form-group">
							<label class="col-md-2 control-label">표지</label>
							<div class="col-md-8">
								<img id="thumbnail" width="300" src="${book.image}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" id="title" name="theme" class="form-control book-frm" value="${book.theme}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">원제</label>
							<div class="col-md-8">
								<input type="text" id="original" name="original" class="form-control book-frm" value="${book.original}" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">ISBN</label>
							<div class="col-md-8">
								<input type="text" id="isbn" name="isbn" class="form-control book-frm" value="${book.isbn}" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자</label>
							<div class="col-md-8">
								<input type="text" id="author" name="author" class="form-control book-frm" value="${book.author}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">역자</label>
							<div class="col-md-8">
								<input type="text" id="translator" name="translator" class="form-control book-frm" value="${book.translator}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판사</label>
							<div class="col-md-8">
								<input type="text" id="publish" name="publish" class="form-control book-frm" value="${book.publish}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판일</label>
							<div class="col-md-8">
								<input type="date" id="publishdate" name="publishdate" class="form-control book-frm" value="${book.publishdate}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">가격</label>
							<div class="col-md-8">
								<input type="text" id="price" name="price" class="form-control book-frm" value="${book.price}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">페이지</label>
							<div class="col-md-8">
								<input type="text" id="page" name="page" class="form-control book-frm" value="${book.page}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">소개</label>
							<div class="col-md-8">
								<textarea id="info" name="intro" class="form-control book-frm" rows="10">
									<c:out value="${book.intro}"/>							
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">목차</label>
							<div class="col-md-8">
								<textarea id="contents" name="contents" class="form-control book-frm" rows="10">
									<c:out value="${book.contents}"/>	
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자 소개</label>
							<div class="col-md-8">
								<textarea id="authorinfo" name="authorinfo" class="form-control book-frm" rows="10">
									<c:out value="${book.authorinfo}"/>
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">수량</label>
							<div class="col-md-8">
								<input type="text" name="quantity" class="form-control book-frm" value="${book.quantity}" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">분류</label>
							<div class="col-md-8">
								<select id="category1" name="category1" class="book-frm">
									<c:forEach items="${category1}" var="parent" >
										<option value="${parent.code}">${parent.name}</option>
									</c:forEach>
								</select>
								<select id="category2" name="category2" class="book-frm">
									<c:forEach items="${category2}" var="child" >
										<option value="${child.code}">${child.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button id="update" type="button" class="btn btn-success">수정</button>
								<button id="delete" type="button" class="btn btn-danger">삭제</button>
								<button id="cancle" type="button" class="btn btn-warning">취소</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="/admin/js/bookRegister.js"></script>
<script type="text/javascript" src="/admin/js/bookRegisterCategory.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

<h4 class="pull-left">도서 등록</h4>
<div class="clearfix"></div>
<hr />
<img id="loader" src="/admin/images/prettyPhoto/default/loader.gif" style="position: fixed; z-index: 100; left: 50%; top: 50%; display: none;">
<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">도서 검색</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<input type="text" id="searchIsbn" placeholder="ISBN을 입력해주세요">
					<button id="searchBookBtn" class="btn btn-success">검색</button>
					<hr />
					<!-- Form starts.  -->
					<form method="post" class="form-horizontal" role="form" action="register_book.do">
						<input type="hidden" id="isbn" name="ISBN">
						<div class="form-group">
							<label class="col-md-2 control-label">표지</label>
							<div class="col-md-8">
								<img id="thumbnail" width="300">
								<input type="hidden" id="bookThumbnail" name="B_IMAGE">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" id="title" class="form-control" name="B_THEME" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">원제</label>
							<div class="col-md-8">
								<input type="text" id="originalTitle" class="form-control" name="ORIGINAL" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자</label>
							<div class="col-md-8">
								<input type="text" id="author" class="form-control" name="B_AUTHOR" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">역자</label>
							<div class="col-md-8">
								<input type="text" id="translator" class="form-control" name="TRANSLATOR" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판사</label>
							<div class="col-md-8">
								<input type="text" id="publisher" class="form-control" name="PUBLISH" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판일</label>
							<div class="col-md-8">
								<input type="date" id="publishDate" class="form-control" name="PUBLISH_DATE" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">가격</label>
							<div class="col-md-8">
								<input type="text" id="price" class="form-control" name="PRICE" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">페이지</label>
							<div class="col-md-8">
								<input type="text" id="page" class="form-control" name="PAGE" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">소개</label>
							<div class="col-md-8">
								<textarea id="info" class="form-control" name="B_INTRO" rows="10"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">목차</label>
							<div class="col-md-8">
								<textarea id="contents" class="form-control" name="B_CONTENTS" rows="10"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자 소개</label>
							<div class="col-md-8">
								<textarea id="authorInfo" class="form-control" name="B_AUTHORINFO" rows="10"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">수량</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="QUANTITY" required="required">
							</div>
						</div>
						<div id="categoryGroup" class="form-group">
							<!-- <label class="col-md-2 control-label">
								<button type="button" id="categoryAddBtn">분류 추가</button> 분류
							</label> -->
							<label class="col-md-2 control-label">카테고리</label>
							<div class="col-md-10">
								<select id="category1" name="B1_BCATEGORY">
					                <c:forEach items="${categoryList_1}" var="categoryList_1">
				                		<option value="<c:out value="${categoryList_1.code}"/>">
				                			<c:out value="${categoryList_1.name}"/>
				                		</option>
					                </c:forEach>
			                	</select>
			                	<select id="category2" name="B1_SCATEGORY">
			                		<option value="">없음</option>
			                	</select><br>
							</div>
						</div>
						<div class="form-group">
								<label class="col-md-2 control-label">해쉬태그</label>
								<div class="col-md-8">
									<input type="checkbox" name="hash" value="spring">Spring
									<input type="checkbox" name="hash" value="it">IT
									<input type="checkbox" name="hash" value="java">java
									<input type="checkbox" name="hash" value="hmtl">hmtl
									<input type="checkbox" name="hash" value="javascript">javascript
									<input type="checkbox" name="hash" value="jstl">jstl
									<input type="checkbox" name="hash" value="algorithm">알고리즘
									<input type="checkbox" name="hash" value="certificate">자격증
									<input type="checkbox" name="hash" value="llevel">초급
									<input type="checkbox" name="hash" value="mlevel">중급
									<input type="checkbox" name="hash" value="hlevel">고급
									<input type="checkbox" name="hash" value="potoshop">포토샵
									<input type="checkbox" name="hash" value="css">CSS
									<input type="checkbox" name="hash" value="aws">AWS
									<input type="checkbox" name="hash" value="working">실무
									<input type="checkbox" name="hash" value="angular">앵귤러
									<input type="checkbox" name="hash" value="python">파이썬
									<input type="checkbox" name="hash" value="data_structure">자료구조
									<input type="checkbox" name="hash" value="node_js">node.js
									<input type="checkbox" name="hash" value="android">안드로이드
									<input type="checkbox" name="hash" value="php">php
									<input type="checkbox" name="hash" value="web">웹
									<input type="checkbox" name="hash" value="cpp">c++
									<input type="checkbox" name="hash" value="oracle">오라클
									<input type="checkbox" name="hash" value="web_design">웹디자인
									<input type="checkbox" name="hash" value="visual_basic">비주얼베이직
									<input type="checkbox" name="hash" value="c">c언어
									<input type="checkbox" name="hash" value="mysql">MySQL
									<input type="checkbox" name="hash" value="R">R언어
									<input type="checkbox" name="hash" value="autoSAD">autoSAD
									<input type="checkbox" name="hash" value="ai">AI
									<input type="checkbox" name="hash" value="ps">ps
								</div>
						</div>
						
						<!-- <div class="form-group">
							<label class="col-md-2 control-label">태그 설정</label>
							<div class="col-md-8">
								<input type="text" class="form-control" required="required" placeholder=",를 구분으로 태그들을 입력해주세요 ex) 프로그래밍, 알고리즘, java">
								split하고 trim 그리고 toUpperCase
							</div>
						</div> -->
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button type="submit" class="btn btn-success">등록</button>
								<button type="reset" class="btn btn-danger">취소</button>
							</div>
						</div>
					</form>
				</div> 	
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">

var category = {
		change12 : function() {
			$(".category1").change(function() {
				var category1Val = $(this).val();
				var category2 = $(this).parent().find(".category2")
				
				category2.empty().append('<option value="">---</option>');
				$.each(category12[category1Val], function(index, val) {
					category2.append('<option>' + val + '</option>');
				});
			});
		}
}

$("#categoryAddBtn").click(function() {
	$("#categoryGroup").append('<div>\
									<div class="col-md-2"></div>\
									<div class="col-md-10">\
										<select class="category1" name="category1">\
											<option>프로그래밍</option>\
											<option>DB</option>\
											<option>수험서</option>\
										</select>\
										<select class="category2" name="category2">\
											<option value="">---</option>\
										</select>\
										<button class="categoryDelBtn" type="button">삭제</button>\
									</div>\
								</div>');
	
	$(".category1").unbind("change");
	category.change12();
	
	$(".categoryDelBtn").unbind("click");
	
	$(".categoryDelBtn").click(function() {
		$(this).parent().parent().remove();
	});

});
</script>

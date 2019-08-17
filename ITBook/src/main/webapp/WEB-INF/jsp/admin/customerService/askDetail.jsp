<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h4 class="pull-left">1:1 문의</h4>
<div class="clearfix"></div>
<hr />
<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">문의 내용</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form class="form-horizontal" role="form">
					<c:forEach items="${oneAskDetail}" var="oneAskDetail">
						<div class="form-group">
							<label class="col-md-2 control-label">분류</label>
							<div class="col-md-8">
								<c:out value='${oneAskDetail.q_type}'></c:out>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" id="title" class="form-control" value="돈이 안빠져나가요" required="required">
								<c:out value='${oneAskDetail.q_type}'></c:out>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">내용</label>
							<div class="col-md-8">
								<textarea class="form-control" rows="10">돈이 안빠져나가네요 ㅎㅎ</textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">답변</label>
							<div class="col-md-8">
								<textarea id="answer" class="form-control" rows="10"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button type="button" class="btn btn-success">등록</button>
								<button type="button" class="btn btn-danger">취소</button>
							</div>
						</div>
						</c:forEach>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
CKEDITOR.config.language = 'ko';
CKEDITOR.replace('answer');
</script>
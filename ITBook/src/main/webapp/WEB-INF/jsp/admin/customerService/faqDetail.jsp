<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">FAQ</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">FAQ 추가</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-md-2 control-label">분류</label>
							<div class="col-md-8">
								<select class="form-control">
									<option>결제/환불</option>
									<option>배송</option>
									<option>중고</option>
									<option>개발자</option>
									<option>자격증</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">질문</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="질문입니다 질문입니다 질문입니다 ">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">답변</label>
							<div class="col-md-8">
								<textarea class="form-control" rows="10" placeholder="답변">답변이에요 
								답변이에요 답변이에요
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button id="faqInsertBtn" class="btn btn-success">수정</button>
								<button type="button" id="cancelBtn" class="btn btn-danger">삭제</button>
								<button type="button" class="btn btn-warning">취소</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
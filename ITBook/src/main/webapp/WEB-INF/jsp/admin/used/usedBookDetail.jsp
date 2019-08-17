<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4 class="pull-left">도서 상세 페이지</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form class="form-horizontal" role="form">
						<input type="hidden" id="isbn" name="isbn">
						
						<div class="form-group">
							<label class="col-md-2 control-label">재고 현황</label>
							<div class="col-md-8">
								<table class="table table-bordered ">
									<thead>
										<tr>
											<th>등급</th>
											<th>수량</th>
											<th>판매 가격</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>최상</td>
											<td>0</td>
											<td><input type="text" value="15000"></td>
										</tr>
										<tr>
											<td>상</td>
											<td>5</td>
											<td><input type="text" value="10000"></td>
										</tr>
										<tr>
											<td>중</td>
											<td>1</td>
											<td><input type="text" value="5000"></td>
										</tr> 
									</tbody>
								</table>
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

<script type="text/javascript" src="js/admin/bookRegister.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
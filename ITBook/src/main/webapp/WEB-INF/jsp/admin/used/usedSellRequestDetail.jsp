<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4 class="pull-left">세미나</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">세미나 상세</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						
						<div class="form-group">
							<label class="col-md-2 control-label">책 목록</label>
							<div class="col-md-8">
								<table class="table table-bordered ">
									<thead>
										<tr>
											<th>표지</th>
											<th>책 제목</th>
											<th>원가</th>
											<th>신청 등급</th>
											<th>등급 판정</th>
											<th>매입 가격</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><img src="https://image.aladin.co.kr/product/12455/98/covermini/k952532762_1.jpg" height="100px"></td>
											<td>프로그래머를 위한 베이지안 with 파이썬</td>
											<td><fmt:formatNumber pattern="###,###" value="10000"/></td>
											<td>상</td>
											<td>
												<select>
													<option>최상</option>
													<option>상</option>
													<option>중</option>
													<option>매입 불가</option>
												</select>
											</td>
											<td><fmt:formatNumber pattern="###,###" value="5000"/></td>
										</tr> 
										<tr>
											<td><img src="https://image.aladin.co.kr/product/12397/95/covermini/k662531550_1.jpg" height="100px"></td>
											<td>엔지니어를 위한 파이썬 - 개발 기초, 필수 라이브러리, 그리고 고속화</td>
											<td><fmt:formatNumber pattern="###,###" value="10000"/></td>
											<td>상</td>
											<td>
												<select>
													<option>최상</option>
													<option>상</option>
													<option>중</option>
													<option>매입 불가</option>
												</select>
											</td>
											<td><fmt:formatNumber pattern="###,###" value="5000"/></td>
										</tr> 
										<tr>
											<td><img src="https://image.aladin.co.kr/product/12609/37/covermini/k372532974_1.jpg" height="100px"></td>
											<td>파이썬으로 데이터 주무르기 - 독특한 예제를 통해 배우는 데이터 분석 입문</td>
											<td><fmt:formatNumber pattern="###,###" value="10000"/></td>
											<td>상</td>
											<td>
												<select>
													<option>최상</option>
													<option>상</option>
													<option>중</option>
													<option>매입 불가</option>
												</select>
											</td>
											<td><fmt:formatNumber pattern="###,###" value="5000"/></td>
										</tr> 
										
									</tbody>
								</table>
							</div>
						</div>
					
						<div class="form-group">
							<label class="col-md-2 control-label">매입불가 상품 처리방법</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="폐기">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">반송 주소 (반송일때)</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="서울특별시 영등포구 양평동 1234">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">정산 방식</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="마일리지">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">계좌 (계좌 입금 시)</label>
							<div class="col-md-8">
								<label class="control-label">은행</label>
								<input type="text" class="form-control" value="신한은행">
								<label class="control-label">계좌번호</label>
								<input type="text" class="form-control" value="123456789">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">총 매입 금액</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="15000">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-2 control-label">회원 정보</label>
							<div class="col-md-8">
								<label class="control-label">아이디</label>
								<input type="text" class="form-control" value="test1">
								<label class="control-label">이름</label>
								<input type="text" class="form-control" value="테스트">
								<label class="control-label">연락처</label>
								<input type="text" class="form-control" value="01012345678">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button class="btn btn-success">처리 완료</button>
								<button type="button" class="btn btn-warning">취소</button>
							</div>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
</script>
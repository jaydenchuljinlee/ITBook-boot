<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">환불 상세</h4>
<div class="clearfix"></div>
<hr/>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="widget wred">
				<div class="widget-head">
				  <div class="pull-left">환불 상세</div>
				  <div class="clearfix"></div>
				</div>

				<div class="widget-content">
					<div class="padd">
						<!-- Profile form -->
						<div class="form profile">
							<!-- Edit profile form (not working)-->
							<form class="form-horizontal">
								 <!-- Name -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="name1">주문번호</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="name1" value="pay201802100001">
								</div>
							  </div> 
							  <!-- Name -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="name1">주문자</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="name1" value="손영철">
								</div>
							  </div> 
							  <!-- Telephone -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="telephone">연락처</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="telephone" value="010-1234-5678">
								</div>
							  </div>
							  <!-- Price -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="telephone">결제 금액</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="telephone" value="35000">
								</div>
							  </div>  
							  <!-- Pay Method -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="telephone">결제 방법</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="telephone" value="카드">
								</div>
							  </div>  
							  <!-- Pay List -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="address">환불 요청 내역</label>
								<div class="col-lg-6">
								  <ul>
								  	<li>자바의 정석</li>
								  	<li>오라클 교과서</li>
								  </ul>
								</div>
							  </div>                               
							  <!-- Status -->
							  <div class="form-group">
								<label class="control-label col-lg-2">상태</label>
								<div class="col-lg-6">                               
									<select class="form-control">
										<option>환불 대기</option>
										<option>환불 완료</option>
									</select>  
								</div>
							  </div>
							  <!-- Buttons -->
							  <div class="form-group">
								 <div class="col-lg-6 col-lg-offset-2">
									<button type="submit" class="btn btn-success">변경</button>
									<button type="reset" class="btn btn-default">취소</button>
								</div>
							  </div>
							</form>
						</div>
					</div>
				</div>
			</div>  
		</div>
	</div>
</div>
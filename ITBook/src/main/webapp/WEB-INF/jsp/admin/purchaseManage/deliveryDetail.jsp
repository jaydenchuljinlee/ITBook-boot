<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">배송 상세</h4>
<div class="clearfix"></div>
<hr/>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="widget wred">
				<div class="widget-head">
				  <div class="pull-left">Profile</div>
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
								  <input type="text" class="form-control" id="name1" value="123456">
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
							  <!-- Address -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="address">주소</label>
								<div class="col-lg-6">
								  <textarea class="form-control" id="address">인천광역시 남동구 11111</textarea>
								</div>
							  </div>
							  <!-- Address -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="address">주문 내용</label>
								<div class="col-lg-6">
								  <ul>
								  	<li>자바의 정석</li>
								  	<li>오라클 교과서</li>
								  </ul>
								</div>
							  </div>
							  <!-- Delivery Company -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="telephone">택배사</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="telephone" value="대한통운">
								</div>
							  </div>  
							  <!-- Delivery Number -->
							  <div class="form-group">
								<label class="control-label col-lg-2" for="telephone">송장 번호</label>
								<div class="col-lg-6">
								  <input type="text" class="form-control" id="telephone" value="11112223333">
								</div>
							  </div>                            
							  <!-- Country -->
							  <div class="form-group">
								<label class="control-label col-lg-2">상태</label>
								<div class="col-lg-6">                               
									<select class="form-control">
										<option>출고 대기</option>
										<option>배송 중</option>
										<option>배송 완료</option>
									</select>  
								</div>
							  </div>
							  <!-- Buttons -->
							  <div class="form-group">
								 <!-- Buttons -->
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
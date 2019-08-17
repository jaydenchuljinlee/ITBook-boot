<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">배송 관리</h4>
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
					<table class="table table-bordered deliveryList">
						<thead>
							<tr>
								<th>#</th>
								<th>주문 번호</th>
								<th>아이디</th>
								<th>이름</th>
								<th>배송 내역</th>
								<th>택배사</th>
								<th>송장번호</th>
								<th>
								 	<select>
								 		<option>전체</option>
								 		<option>출고 대기</option>
								 		<option>배송 중</option>
								 		<option>배송 완료</option>
								</select>	
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>10</td>
								<td>pay201802100001</td>
								<td>test10</td>
								<td>테스트10</td>
								<td><a id="pay3" class="deliveryDetail" href="#">자바의 정석 외 3권</a></td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-success">배송 완료</span></td>
							</tr>
							<tr>
								<td>9</td>
								<td>pay201802100001</td>
								<td>test9</td>
								<td>테스트9</td>
								<td>jQuery CookBook</td>
								<td></td>
								<td></td>
								<td><span class="label label-warning">출고 대기</span></td>
							</tr>
							<tr>
								<td>8</td>
								<td>pay201802100001</td>
								<td>test8</td>
								<td>테스트8</td>
								<td>자바의 정석 외 3권</td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-info">배송 중</span></td>
							</tr>
							<tr>
								<td>10</td>
								<td>pay201802100001</td>
								<td>test10</td>
								<td>테스트10</td>
								<td><a id="pay3" class="deliveryDetail" href="#">자바의 정석 외 3권</a></td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-success">배송 완료</span></td>
							</tr>
							<tr>
								<td>9</td>
								<td>pay201802100001</td>
								<td>test9</td>
								<td>테스트9</td>
								<td>jQuery CookBook</td>
								<td></td>
								<td></td>
								<td><span class="label label-warning">출고 대기</span></td>
							</tr>
							<tr>
								<td>8</td>
								<td>pay201802100001</td>
								<td>test8</td>
								<td>테스트8</td>
								<td>자바의 정석 외 3권</td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-info">배송 중</span></td>
							</tr>
							<tr>
								<td>10</td>
								<td>pay201802100001</td>
								<td>test10</td>
								<td>테스트10</td>
								<td><a id="pay3" class="deliveryDetail" href="#">자바의 정석 외 3권</a></td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-success">배송 완료</span></td>
							</tr>
							<tr>
								<td>9</td>
								<td>pay201802100001</td>
								<td>test9</td>
								<td>테스트9</td>
								<td>jQuery CookBook</td>
								<td></td>
								<td></td>
								<td><span class="label label-warning">출고 대기</span></td>
							</tr>
							<tr>
								<td>8</td>
								<td>pay201802100001</td>
								<td>test8</td>
								<td>테스트8</td>
								<td>자바의 정석 외 3권</td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-info">배송 중</span></td>
							</tr>
							<tr>
								<td>10</td>
								<td>pay201802100001</td>
								<td>test10</td>
								<td>테스트10</td>
								<td><a id="pay3" class="deliveryDetail" href="#">자바의 정석 외 3권</a></td>
								<td>대한통운</td>
								<td>111122223333</td>
								<td><span class="label label-success">배송 완료</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<div class="pull-left">
					<form>
						<input type="text" name="keyword" placeholder="검색어를 입력해주세요">
						<button>검색</button>
					</form>
				</div>
				<ul class="pagination pull-right">
				  <li><a href="#">Prev</a></li>
				  <li><a href="#">1</a></li>
				  <li><a href="#">2</a></li>
				  <li><a href="#">3</a></li>
				  <li><a href="#">4</a></li>
				  <li><a href="#">Next</a></li>
				</ul>
				<div class="clearfix"></div> 
			</div>
		</div>
	</div>
</div>

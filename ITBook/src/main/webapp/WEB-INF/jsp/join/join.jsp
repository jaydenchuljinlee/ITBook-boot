<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/customer_center/customer_common.css">

<div class="container">
	<div class="join_wrap modal-content">
		<div class="main-heading-holder">
			<div class="main-heading">
				<h2><span class="theme-color">회원 </span> 가입</h2>
				<p>IT Book에 오신 걸 환영합니다.</p>
			</div>
		</div>	
		<form action="" method="post" id="default_frm">
		<!-- 계정정보 section -->
			<table class="table mt-3">
				<colgroup>
					<col width="20%">
				</colgroup>
				<tbody>
					<!-- 계정정보 아이디 입력 -->
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span >아이디</span>
						</th>
						<td>
							<input id="identity_input" class="form-control col-4 mx-1 necessary" type="text" name="identity" pattern="[A-Za-z0-9]{4,10}" maxlength="10" style="display:inline;">
							<input id="confirmed" type="hidden">
							<button type="button" id="confirm_overlap" class="join-btn join-btn-outline mx-1 confirm">중복확인</button>
							</br>
							<span class="join-added-info">중복확인 아이디는 영문 또는 숫자를 입력해 주세요.</span>
						</td>
					</tr>
					<!-- 계정정보 비밀번호 입력 -->
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span >비밀번호</span>
						</th>
						<td>
							<input id="input_pwd" class="form-control col-4 mx-1 necessary" type="password" name="password">
							
							<span class="join-added-info" >비밀번호는 영문, 숫자, 특수문자를 조합하여 10자 이상 입력해 주세요.</span>
						</td>
					</tr>
					<!-- 계정정보 비밀번호 확인 -->
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span>비밀번호 확인</span>
						</th>
						<td>
							<input class="form-control col-4 mx-1 necessary" type="password" id="confirm_pwd">
							
							<span id="alert-danger" class="join-added-info text-danger" >비밀번호가 일치하지 않습니다.</span>
							<span id="alert-success" class="join-added-info text-primary" >비밀번호가 일치합니다.</span>
						</td>
					</tr>
					<!-- 계정정보 아이디 입력 -->
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span >이름</span>
						</th>
						<td>
							<input id="identity_input" class="form-control col-4 mx-1 necessary" type="text" name="name" maxlength="10" style="display:inline;">
						</td>
					</tr>
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span >휴대폰번호</span>
							<input type="hidden" id="manager_call_input" name="phone">
						</th>
						<td class="form-inline">
							<input class="form-control col-1 mx-1 necessary" type="number" id="manager_call_input1" maxlength="5" oninput="maxLengthCheck(this)">
							-
							<input class="form-control col-1 mx-1 necessary" type="number" id="manager_call_input2" maxlength="4" oninput="maxLengthCheck(this)">
							-
							<input class="form-control col-1 mx-1 necessary" type="number" id="manager_call_input3" maxlength="4" oninput="maxLengthCheck(this)">
						</td>
					</tr>
					<!-- 담당자정보 이메일주소 입력 -->
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span >이메일주소</span>
							<input type="hidden" id="email_input" name="email">
						</th>
						<td class="form-inline">
							<input class="form-control col-3 mx-1 necessary" type="text" id="email_id">
							@
							<input class="form-control col-4 mx-1 necessary" type="text" id="email_address" readonly>
							<select id="email_select" class="sabang-select" name="mail" style="height:38px;">
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
							</select>
						</td>
					</tr>
					<!-- 회사정보 회사주소 입력 -->
					<tr>
						<th scope="row">
							<span class=" mx-2" style="color:red">*</span>
							<span >회사주소</span>
						</th>
						<td colspan="3">
							<div class="form-inline">
								<input class="form-control col-3 mx-1 necessary" type="text" id="search_zonecode" name="address1" readonly>

								<div id="search" class="col-2 p-2 mx-2 text-center address_btn" style="font-size:13px;">
									<span>주소검색</span>
								</div>
								<input class="form-control col-5 mx-1 necessary" type="text" id="search_address" name="address2" readonly>
							</div>
							<div class="mt-1">	
								<input class="form-control col-7 mx-1 necessary" type="text" id="address_details" name="address3">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<!-- 계정정보 End -->
			<!--              -->
			<div class="text-right">
				<button type=button id="btnJoin" class="btn btn_orange">회원가입</button>
			</div>
		</form>
	</div>

</div>


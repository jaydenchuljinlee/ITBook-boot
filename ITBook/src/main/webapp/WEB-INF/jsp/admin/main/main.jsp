<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4 class="pull-left">IT Book 관리자 페이지</h4>
<div class="clearfix"></div>
<hr/>

<div class="row">
	<div class="col-md-8" id="mainInfoList"> 
		<div class="col-md-3">
			<div data-url="adminPay.do?op=wait" class="well borange mainMenu">
				<h5>입금 대기</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminDelivery.do?op=ready" class="well borange mainMenu">
				<h5>출고 대기</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminExchange.do?op=wait" class="well blightblue mainMenu">
				<h5>교환 신청</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminRefund.do?op=wait" class="well blightblue mainMenu">
				<h5>환불 신청</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminSeminar.do?op=wait" class="well bgreen mainMenu">
				<h5>세미나 신청</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminOffLecture.do?op=wait" class="well bgreen mainMenu">
				<h5>오프 강의 신청</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminUsedSellRequest.do?op=wait" class="well bviolet mainMenu">
				<h5>중고 판매 신청</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
		
		<div class="col-md-3">
			<div data-url="adminAsk.do?op=wait" class="well bviolet mainMenu">
				<h5>1:1 문의</h5>
				<div class="mainRight">
					<h3>1</h3>
				</div>
			</div>
		</div>
	</div>
	
	<div class="col-md-4">
		<div class="widget-content">
			<div class="padd">
			
				<div class="row">
					<div class="col-md-2">
					</div>
					
					<div class="col-md-3">
						<h4 id="visitor" class="mainPointer chartBtn">방문자</h4><!-- 최근 일주일 방문자 -->
					</div>
					
					<div class="col-md-3">
						<h4 id="client" class="mainPointer chartBtn">회원</h4><!-- 최근 일주일 가입, 탈퇴 -->
					</div>
					
					<div class="col-md-3">
						<h4 id="sell" class="mainPointer chartBtn">판매</h4><!-- 최근 일주일 판매, 교환, 환불 -->
					</div>
					
				</div>
				
				<hr/>
				
				<div id="mainChartDiv" class="row">
					<canvas id="mainChart"></canvas>
				</div>
			</div>
		</div>
	</div>
</div>

<hr/>

<h3>사이트 네비게이션</h3>
<div id="tabs">
	<ul class="tabsList">
	  <li data-url="#"><a href="#tabs-1">도서</a></li>
	  <li data-url="#"><a href="#tabs-2">중고</a></li>
	  <li data-url="#"><a href="#tabs-3">교육</a></li>
	  <li data-url="#"><a href="#tabs-4">개발자 공간</a></li>
	  <li data-url="eventList.do"><a href="#tabs-5">이벤트</a></li>
	  <li data-url="#"><a href="#tabs-6">고객센터</a></li>
	</ul>
	
	<div id="tabs-1">
		<p data-url="recommendBook.do"><a href="#">맞춤 도서</a></p>
		<p data-url="newBook.do"><a href="#">신간 도서</a></p>
		<p data-url="categoryBook.do"><a href="#">전체 도서</a></p>
	</div>
	<div id="tabs-2">
		<p data-url="usedbookMain.do"><a href="#">IT-Book 중고도서</a></p>
		<p data-url="lecture.do"><a href="#">IT-Book에 파세요!</a></p>
		<p data-url="usedbookGuide.do"><a href="#">중고팔기 이용안내</a></p>
	</div>
	<div id="tabs-3">
		<p><a href="#">세미나</a></p>
		<p><a href="#">강의</a></p>
		<p><a href="#">자격증</a></p>
	</div>
	<div id="tabs-4">
		<p><a href="#">Talk! & Tip!</a></p>
		<p><a href="#">질문있습니다!!</a></p>
		<p><a href="#">IT News & Column</a></p>
		<p><a href="#">스터디</a></p>
	</div>
	<div id="tabs-5">
	</div>
	<div id="tabs-6">
		<p><a href="#">FAQ</a></p>
		<p><a href="#">1:1 문의</a></p>
	</div>
</div>
<br/>
<div>
	<button id="setNaviOrderBtn" class="btn btn-success btn-lg">
		현재 순서 적용
	</button>
	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newTabModal">
		네비게이션 탭 추가
	</button>
	<button class="btn btn-info btn-lg" data-toggle="modal" data-target="#newContentModal">
		네비게이션 항목 추가
	</button>
</div>

<!-- 네비 탭 추가 modal  -->
<div class="modal fade" id="newTabModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">네비게이션 탭 추가</h4>
      </div>
      <div class="modal-body">
      	제목 :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="title" placeholder="네비게이션 탭 제목"><br/>
        URL :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="url" placeholder="없을 시 #입력">
      </div>
      <div class="modal-footer">
        <button id="addTabBtn" type="button" class="btn btn-primary">추가</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
<!--/ 네비 탭 추가 modal -->

<!-- 네비 탭 수정 modal  -->
<div class="modal fade" id="updateTabModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="updateModalLabel">네비게이션 탭 수정</h4>
      </div>
      <div class="modal-body">
      	제목 :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="title"><br/>
        URL :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="url">
      </div>
      <div class="modal-footer">
        <button id="updateTabBtn" type="button" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
<!--/ 네비 탭 수정 modal -->

<!-- 네비 항목 수정 modal  -->
<div class="modal fade" id="updateContentModal" tabindex="-1" role="dialog" aria-labelledby="updateContentModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="updateContentModalLabel">네비게이션 항목 수정</h4>
      </div>
      <div class="modal-body">
      	제목 :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="title"><br/>
        URL :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="url">
      </div>
      <div class="modal-footer">
        <button id="updateContentBtn" type="button" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
<!--/ 네비 내용 수정 modal -->

<!-- 네비 항목 추가 modal  -->
<div class="modal fade" id="newContentModal" tabindex="-1" role="dialog" aria-labelledby="addContentModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="addContentModalLabel">네비게이션 항목 추가</h4>
      </div>
      <div class="modal-body">
      	카테고리 : <br/>
      	<select class="navCategory" style="margin-left: 50px;">
      		<!-- ajax로 목록 가져오기 -->
      		<option>도서</option>
      		<option>중고</option>
      		<option>교육</option>
      		<option>개발자 공간</option>
      		<option>이벤트</option>
      		<option>고객센터</option>
      	</select>
      	<br/>
      
      	제목 :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="title"><br/>
        URL :<br/>
        <input type="text" style="margin-left: 50px; width: 90%" class="url">
      </div>
      <div class="modal-footer">
        <button id="addContentBtn" type="button" class="btn btn-primary">추가</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
<!--/ 네비 내용 추가 modal -->

<script type="text/javascript" src="/admin/js/Chart.min.js"></script>
<script type="text/javascript" src="/admin/js/main.js"></script>
<script type="text/javascript" src="/admin/js/contextMenu.min.js"></script>
<link rel="stylesheet" type="text/css" href="/admin/css/contextMenu.min.css">
<link rel="stylesheet" type="text/css" href="/admin/css/admin/main.css">
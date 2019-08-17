<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">이벤트</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">이벤트 상세</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-md-2 control-label">썸네일</label>
							<div class="col-md-8">
								<img id="eventThumbnail" style="height: 200px;" src="https://images-na.ssl-images-amazon.com/images/I/61p5QpMrL7L._SL1100_.jpg">
								<input id="thumbnail" type="file">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">적용 대상</label>
							<div class="col-md-8">
								<select id="target" class="form-control">
									<option>모든 책</option>
									<option>책 분류</option>
									<option>특정 책</option>
									<option selected="selected">금액</option>
									<option>회원등급</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">적용 대상 상세</label>
							<div id="targetDetail" class="col-md-8">
								<input type="text" class="form-control" name="targetDetail" placeholder="~원 이상" value="50000">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">시작일</label>
							<div class="col-md-8">
								<input id="startDate" type="date" class="form-control" value="2018-03-01">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">종료일</label>
							<div class="col-md-8">
								<input id="endDate" type="date" class="form-control" value="2018-03-31">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="제목" value="IT Book 머그컵 2018 Edition">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">설명</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="제목" value="3월 한 달간 5만원 이상 주문시 모든 고객에게 IT Book 머그컵 2018 Edition을 드립니다.">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">내용</label>
							<div class="col-md-8">
								<textarea id="eventContent" class="form-control" rows="10">IT Book을 사랑해주시는 개발자 여러분들을 위한 IT Book의 선물!
								3월 한 달간 5만원 이상 주문한 모든 고객분들에게 개발자라면 갖고싶을 만한 디자인의 머그컵을 증정합니다!</textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button class="btn btn-success">수정</button>
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

<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
$(function() {
	//ckEditor
	CKEDITOR.config.language = 'ko';
	CKEDITOR.replace('eventContent');
	
	//책 분류
	var bookCategory = ["프로그래밍 언어", "데이터베이스", "알고리즘", "수험서"];
	var clientGrade = ["골드", "실버", "브론즈"];
	
	//적용 대상
	$("#target").change(function() {
		$("#targetDetail").empty();
		var target = $("#target").val();
		
		if (target === "책 분류") {
			$("#targetDetail").append('<select id="targetDetailSel" class="form-control" name="targetDetail"></select>');
			
			for (var i in bookCategory) {
				$("#targetDetailSel").append("<option>" + bookCategory[i] + "</option>");
			}
			
		} else if (target === "특정 책") {
			$("#targetDetail").append('<input type="text" class="form-control" name="targetDetail" placeholder="ISBN 입력">');
		} else if (target === "금액") {
			$("#targetDetail").append('<input type="text" class="form-control" name="targetDetail" placeholder="~원 이상">');			
		} else if (target === "회원등급") {
			$("#targetDetail").append('<select id="targetDetailSel" class="form-control" name="targetDetail"></select>');
			
			for (var i in clientGrade) {
				$("#targetDetailSel").append("<option>" + clientGrade[i] + "</option>");
			}
		}
	});
	
	$("#thumbnail").change(handleImgFileSelect);
	
	function handleImgFileSelect(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(selFile) {
			
			if (!selFile.type.match("image.*")) {
				alert("이미지 파일을 올려주세요!");
				return;
			}
			
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$("#eventThumbnail").attr("src", e.target.result);
			}
			
			reader.readAsDataURL(selFile);
		})
	}
});
</script>
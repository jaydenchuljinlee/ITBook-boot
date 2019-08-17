<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
							<label class="col-md-2 control-label">썸네일</label>
							<div class="col-md-8">
								<img id="eventThumbnail" style="height: 200px;" src="images/seminar-list/channel-img-01.jpg">
								<input id="thumbnail" type="file">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="제목" value="[32차] 대한민국 개발자의 생존전략 2.17">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">주최자</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="주최자" value="한큐">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">설명</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="설명" value="이 기회를 놓치지 마세요. 한큐에자바는 지난 30회차 동안 단 한 번의 악플도 없었습니다. 입소문, 글 소문, 후기 등등 이거다 싶으시면 신청하세요. 우리 대한민국 웹 개발자를 꿈꾸는, 혹은 멋진 프리랜서를 꿈꾸는 모든 분들에게 이 특강을 바칩니다. 무엇 하나 새로운 내용이 아닌 게 없으실 겁니다. 판도라의 상자를 개봉합니다.">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">상세 내용</label>
							<div class="col-md-8">
								<textarea id="seminarContent" class="form-control" rows="10" placeholder="상세 내용">
									<p>모임기간 : 2월 17일 (토) 18시 00분 ~ 22시 30분</p> <p>모임장소 : 서울 마포구 서교동 서광빌딩 4층 한큐에자바</p><p>안녕하세요. 총 29번의 프로젝트를 뛰었고, 현재는 SI 법인 한큐에이시스템 대표이며 주말에는 제 학원 한큐에자바 에서 강의를 하고있는 11년차 자바 프리랜서 대발자 한큐 입니다.</p><p>이 기회를 놓치지 마세요. 한큐에자바는 지난 30회차 동안 단 한 번의 악플도 없었습니다. 입소문, 글 소문, 후기 등등 이거다 싶으시면 신청하세요. 우리 대한민국 웹 개발자를 꿈꾸는, 혹은 멋진 프리랜서를 꿈꾸는 모든 분들에게 이 특강을 바칩니다. 무엇 하나 새로운 내용이 아닌 게 없으실 겁니다. 판도라의 상자를 개봉합니다.</p><p>세미나 대상 : IT쪽을 준비하시는,취업하신지 얼마 안되신 모든 분들</p>
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">날짜</label>
							<div class="col-md-8">
								<input id="seminarDate" type="date" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">시작 시간</label>
							<div class="col-md-8">
								<input id="startTime" type="time" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">종료 시간</label>
							<div class="col-md-8">
								<input id="endTime" type="time" class="form-control">
							</div>
						</div>
						
						<!-- 어떤식으로 구현할지 상의 필요 -->
						<div class="form-group">
							<label class="col-md-2 control-label">상태</label>
							<div class="col-md-8">
								<div class="map">
									<select>
										<option>대기</option>
										<option>통과</option>
										<option>거부</option>
									</select>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button class="btn btn-success">적용</button>
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
<script type="text/javascript" defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2RtCx2sphTzIWzGh5uLlDtrnVjs_uYVM&libraries=places"></script>
<script type="text/javascript">
$(function() {
	//ckEditor
	CKEDITOR.config.language = 'ko';
	CKEDITOR.replace('seminarContent');

	//썸네일 미리보기
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
		});
	}
	
});
</script>
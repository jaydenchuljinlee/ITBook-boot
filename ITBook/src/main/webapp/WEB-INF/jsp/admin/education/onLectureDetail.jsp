<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">온라인 강의</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">온라인 강의 상세</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-md-2 control-label">썸네일</label>
							<div class="col-md-8">
								<img id="eventThumbnail" src="images/lecture/lecture-img-01.jpg" style="height: 200px;">
								<input id="thumbnail" type="file">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="제목" value="[30강]파이썬 강좌">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">URL</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="URL" value="https://www.youtube.com/channel/UC0h8NzL2vllvp3PjdoYSK4g">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">설명</label>
							<div class="col-md-8">
								<textarea id="seminarContent" class="form-control" rows="10" placeholder="상세 내용">
								책꽂이에는 비싼 프로그래밍 입문서들만 하나씩 늘어갑니다. 큰 맘먹고 등록한 인터넷 강의는 접속한지가 언젠지 가물가물합니다. 암호 같은 전문 용어에 한숨 쉬며 자괴감 드는 날들이 반복됩니다. 자, 이제 결심 후 좌절의 악순환의 고리를 끊을 때가 왔습니다. (전) 프로그래밍 포기자가 역지사지의 심정으로 정성껏 준비한 강의! 인기 유튜버 김왼손의 미운코딩새끼: 파이썬 입문편을 만나보세요!</textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button class="btn btn-success">등록</button>
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
<script type="text/javascript" src="js/admin/onLectureInsertForm.js"></script>
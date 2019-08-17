<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">세미나</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">세미나 추가</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-md-2 control-label">썸네일</label>
							<div class="col-md-8">
								<img id="eventThumbnail" style="height: 200px;">
								<input id="thumbnail" type="file">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="제목">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">주최자</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="주최자">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">설명</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="설명">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">상세 내용</label>
							<div class="col-md-8">
								<textarea id="seminarContent" class="form-control" rows="10" placeholder="상세 내용"></textarea>
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
						
						<div class="form-group">
							<label class="col-md-2 control-label">장소</label>
							<div class="col-md-8">
								<div class="map">
									<div id="googleMap"  style="width:100%; height: 400px;"></div>
									<input id="pac-input" style="background-color: white; width:50%; margin: 5px;">
								</div>
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
<script type="text/javascript" defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2RtCx2sphTzIWzGh5uLlDtrnVjs_uYVM&libraries=places"></script>
<script type="text/javascript" src="js/admin/seminarInsertForm.js"></script>
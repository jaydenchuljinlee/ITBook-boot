<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">IT 뉴스</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">IT 뉴스 추가</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-md-2 control-label">썸네일</label>
							<div class="col-md-8">
								<img id="itNewsThumbnail" style="height: 200px;">
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
							<label class="col-md-2 control-label">기자</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="기자">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">기자 이메일</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="기자 이메일">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">상세 내용</label>
							<div class="col-md-8">
								<textarea id="itNewsContent" class="form-control" rows="50" placeholder="상세 내용"></textarea>
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
<script type="text/javascript">
$(function() {
	//ckEditor
	CKEDITOR.config.language = 'ko';
	CKEDITOR.config.height= '1000px';
	CKEDITOR.replace('itNewsContent');

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
				$("#itNewsThumbnail").attr("src", e.target.result);
			}
			
			reader.readAsDataURL(selFile);
		});
	}
	
});
</script>
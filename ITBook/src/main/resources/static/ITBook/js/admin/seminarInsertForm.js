$(function() {
	//ckEditor
	CKEDITOR.config.language = 'ko';
	CKEDITOR.replace('seminarContent', {
		filebrowserImageUploadUrl: "upload.do"});
	
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
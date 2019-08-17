<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">IT 뉴스</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">IT 뉴스 상세</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form action="#" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-md-2 control-label">썸네일</label>
							<div class="col-md-8">
								<img id="itNewsThumbnail" style="height: 200px;" src="http://www.itnews.or.kr/wp-content/uploads/2018/03/Internet2-100x70.jpg">
								<input id="thumbnail" type="file">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="제목" value="구글 크롬, HTTP에 보안경고 표시…웹 보안 독점?">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">기자</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="기자" value="임정호">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">기자 이메일</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="기자 이메일" value="art@itnews.or.kr">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">상세 내용</label>
							<div class="col-md-8">
								<textarea id="itNewsContent" class="form-control" placeholder="상세 내용">
									페이스북 메신저부터 킥, 슬랙봇, 구글 어시스턴트, 아마존 알렉사 그리고 이메일 봇에 이르는 새로운 대화형 앱이 소프트웨어와 인터랙션하는 방법에 혁명을 일으키고 있다. 
제이펍이 출간한 새 책 '봇 설계는 이렇게 한다: 다양한 봇으로 알아보는 대화형 서비스 만들기'는 실용 가이드로 그 대상이 새로운 소비자용 서비스인지 기업용 효율성 제품인지에 상관없이 사람들의 생산성을 높이는, 훌륭한 대화형 경험을 가진 유익한 봇을 기획하고 만드는 방법을 보여 준다. 
기획자, 제품 담당 책임자 그리고 창업자에게 이상적인 이 책은 실제 봇 사례에서 무엇이 동작하고 동작하지 않는지를 탐구하고 실용적인 기획 패턴을 제공한다. 또한, 여러분은 봇을 효과적으로 적용하는 방법, 다양한 흐름의 개요를 그리는 방법 그리고 봇의 개성을 정의하고 리치 컨트롤 및 텍스트의 적절한 균형을 선택하는 방법을 배우게 될 것이다. 
이 책의 주요 내용은 ▲ 봇의 다양한 사용 사례와 모범적인 기획 사례들을 학습한다. ▲ 브랜드, 성격, 대화, 고급 UI 컨트롤 및 봇의 기획 패턴과 같은 봇의 구조를 이해한다. ▲ 소비자용 페이스북 메신저 봇과 기업용 슬랙봇 제작 단계를 배운다. ▲ 봇을 만든 기획자와 창업자의 경험을 공유한다. ▲ 여러분의 첫 번째 봇을 기획하고 프로토타입을 작성하여 사용자의 반응을 실험해 본다 등이다. 
이 책은 봇을 이해하고 기획하는 방법을 배우는 여행으로 여러분을 안내한다. 또한, 자신의 성공, 실패 및 모범 사례들을 공유한 봇 기획자와 개발자에 관해서도 읽게 될 것이다. 이 책은 이론적일 뿐만 아니라 실용적이며, 우리는 실제로 페이스북 메신저 기반의 소비자용 봇과 슬랙 기반의 기업용 봇 각각을 기획하는 모든 단계를 밟아 볼 것이다. 
지은이 아미르 셔밧(Amir Shevat)은 슬랙(Slack)의 개발 책임자이며, 봇 개발자, 기획자들과 함께 일하고 있다. 아울러 유다시티(Udacity)에서 제품 기획 과정을 개설하여 제품 책임자, 기획자, 개발자들에게 사용자들이 사랑하는 제품을 만드는 방법도 가르치고 있다. 예전에는 구글 스타트업 지원 프로그램을 관리하면서 전 세계 개발자들이 더 나은 제품을 기획하고 만드는 데 도움을 주기도 했다. 
옮긴이 강성용은 수능 모의고사를 치르다 교실을 뛰쳐나왔던 그날 이후로 지난 17년간 개발자로 일했으며, 지금은 디스코(www.disco.re) 서비스를 개발 중이다. 옮긴이에 대한 소식은 ulzima.com에서 볼 수 있다. 옮긴 책으로는 ‘자바 네트워크 프로그래밍(제4판)’이 있으며, 함께 옮긴 책으로는 ‘러닝 파이썬(제5판)’, ‘러닝 스칼라’, ‘리뷰의 기술’, ‘C 포인터의 이해와 활용’, ‘윈도우 파워셸 3 시작하기(제2판)’가 있다. 지은이 아미르 셔밧 |옮긴이 강성용 | 제이펍 |336쪽 | 26,000원
								</textarea>
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
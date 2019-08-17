<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h4 class="pull-left">도서 상세 페이지</h4>
<div class="clearfix"></div>
<hr />

<div class="row">
	<div class="col-md-12">
		<div class="widget wgreen">
			<div class="widget-head">
				<div class="pull-left">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content">
				<div class="padd">
					<!-- Form starts.  -->
					<form class="form-horizontal" role="form">
						<input type="hidden" id="isbn" name="isbn">
						<div class="form-group">
							<label class="col-md-2 control-label">표지</label>
							<div class="col-md-8">
								<img id="thumbnail" width="300" src="http://bookthumb.phinf.naver.net/cover/121/748/12174889.jpg?udate=20171122">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">제목</label>
							<div class="col-md-8">
								<input type="text" id="title" class="form-control" value="파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">원제</label>
							<div class="col-md-8">
								<input type="text" id="originalTitle" class="form-control" value="Introduction to Machine Learning with Python" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">ISBN</label>
							<div class="col-md-8">
								<input type="text" id="originalTitle" class="form-control" value="9788968483394" placeholder="국내책의 경우 빈칸">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자</label>
							<div class="col-md-8">
								<input type="text" id="author" class="form-control" value="안드레아스 뮐러, 세라 가이도">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">역자</label>
							<div class="col-md-8">
								<input type="text" id="translator" class="form-control" value="박해선">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판사</label>
							<div class="col-md-8">
								<input type="text" id="publisher" class="form-control" value="한빛미디어" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">출판일</label>
							<div class="col-md-8">
								<input type="date" id="publishDate" class="form-control" value="2017-07-01" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">가격</label>
							<div class="col-md-8">
								<input type="text" id="publishDate" class="form-control" value="18000" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">페이지</label>
							<div class="col-md-8">
								<input type="text" id="page" class="form-control" value="456" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">소개</label>
							<div class="col-md-8">
								<textarea id="info" class="form-control" rows="10"><p>사이킷런 핵심 개발자에게 배우는 머신러닝 이론과 구현<br />
<br />
현업에서 머신러닝을 연구하고 인공지능 서비스를 개발하기 위해 꼭 학위를 받을 필요는 없다. 사이킷런(SCIKIT-LEARN)과 같은 훌륭한 머신러닝 라이브러리가 복잡하고 난해한 작업을 직관적인 인터페이스로 감싸주는 덕분. 이 책에서는 사이킷런의 핵심 개발자가 복잡한 수학을 동원하지 않고 실용적으로 머신러닝을 구축하는 모든 단계를 설명한다. 미적분, 선형대수, 확률 이론을 공부하지 않았어도 이 책을 통해 머신러닝을 활용할 수 있게 될 것이다. 한국어판에는 특별히 &lsquo;저자 인터뷰&rsquo;와 &lsquo;KONLPY를 사용한 영화 리뷰 분석(7.8.1절)&rsquo;도 실었다.</p></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">목차</label>
							<div class="col-md-8">
								<textarea id="contents" class="form-control" rows="10"><p>CHAPTER 1 소개<br />
1.1 왜 머신러닝인가?<br />
__1.1.1 머신러닝으로 풀 수 있는 문제<br />
__1.1.2 문제와 데이터 이해하기<br />
1.2 왜 파이썬인가?<br />
1.3 scikit-learn<br />
__1.3.1 scikit-learn 설치<br />
1.4 필수 라이브러리와 도구들<br />
__1.4.1 주피터 노트북<br />
__1.4.2 NumPy<br />
__1.4.3 SciPy<br />
__1.4.4 matplotlib<br />
__1.4.5 pandas<br />
__1.4.6 mglearn<br />
1.5 파이썬 2 vs. 파이썬 3<br />
1.6 이 책에서 사용하는 소프트웨어 버전<br />
1.7 첫 번째 애플리케이션: 붓꽃의 품종 분류<br />
__1.7.1 데이터 적재<br />
__1.7.2 성과 측정: 훈련 데이터와 테스트 데이터<br />
__1.7.3 가장 먼저 할 일: 데이터 살펴보기<br />
__1.7.4 첫 번째 머신러닝 모델: k-최근접 이웃 알고리즘<br />
__1.7.5 예측하기<br />
__1.7.6 모델 평가하기<br />
1.8 요약<br />
<br />
CHAPTER 2 지도 학습<br />
2.1 분류와 회귀<br />
2.2 일반화, 과대적합, 과소적합<br />
__2.2.1 모델 복잡도와 데이터셋 크기의 관계<br />
2.3 지도 학습 알고리즘<br />
__2.3.1 예제에 사용할 데이터셋<br />
__2.3.2 k-최근접 이웃<br />
__2.3.3 선형 모델<br />
__2.3.4 나이브 베이즈 분류기<br />
__2.3.5 결정 트리<br />
__2.3.6 결정 트리의 앙상블<br />
__2.3.7 커널 서포트 벡터 머신<br />
__2.3.8 신경망(딥러닝)<br />
2.4 분류 예측의 불확실성 추정<br />
__2.4.1 결정 함수<br />
__2.4.2 예측 확률<br />
__2.4.3 다중 분류에서의 불확실성<br />
2.5 요약 및 정리<br />
<br />
CHAPTER 3 비지도 학습과 데이터 전처리<br />
3.1 비지도 학습의 종류<br />
3.2 비지도 학습의 도전 과제<br />
3.3 데이터 전처리와 스케일 조정<br />
__3.3.1 여러 가지 전처리 방법<br />
__3.3.2 데이터 변환 적용하기<br />
__3.3.3 훈련 데이터와 테스트 데이터의 스케일을 같은 방법으로 조정하기<br />
__3.3.4 지도 학습에서 데이터 전처리 효과<br />
3.4 차원 축소, 특성 추출, 매니폴드 학습<br />
__3.4.1 주성분 분석(PCA)<br />
__3.4.2 비음수 행렬 분해(NMF)<br />
__3.4.3 t-SNE를 이용한 매니폴드 학습<br />
3.5 군집<br />
__3.5.1 k-평균 군집<br />
__3.5.2 병합 군집<br />
__3.5.3 DBSCAN<br />
__3.5.4 군집 알고리즘의 비교와 평가<br />
__3.5.5 군집 알고리즘 요약<br />
3.6 요약 및 정리<br />
<br />
CHAPTER 4 데이터 표현과 특성 공학<br />
4.1 범주형 변수<br />
__4.1.1 원-핫-인코딩(가변수)<br />
__4.1.2 숫자로 표현된 범주형 특성<br />
4.2 구간 분할, 이산화 그리고 선형 모델, 트리 모델<br />
4.3 상호작용과 다항식<br />
4.4 일변량 비선형 변환<br />
4.5 특성 자동 선택<br />
__4.5.1 일변량 통계<br />
__4.5.2 모델 기반 특성 선택<br />
__4.5.3 반복적 특성 선택<br />
4.6 전문가 지식 활용<br />
4.7 요약 및 정리<br />
<br />
CHAPTER 5 모델 평가와 성능 향상<br />
5.1 교차 검증<br />
__5.1.1 scikit-learn의 교차 검증<br />
__5.1.2 교차 검증의 장점<br />
__5.1.3 계층별 k-겹 교차 검증과 그외 전략들<br />
5.2 그리드 서치<br />
__5.2.1 간단한 그리드 서치<br />
__5.2.2 매개변수 과대적합과 검증 세트<br />
__5.2.3 교차 검증을 사용한 그리드 서치<br />
5.4 평가 지표와 측정<br />
__5.4.1 최종 목표를 기억하라<br />
__5.4.2 이진 분류의 평가 지표<br />
__5.4.3 다중 분류의 평가 지표<br />
__5.4.4 회귀의 평가 지표<br />
__5.4.5 모델 선택에서 평가 지표 사용하기<br />
5.5 요약 및 정리<br />
<br />
CHAPTER 6 알고리즘 체인과 파이프라인<br />
6.1 데이터 전처리와 매개변수 선택<br />
6.2 파이프라인 구축하기<br />
6.3 그리드 서치에 파이프라인 적용하기<br />
6.4 파이프라인 인터페이스<br />
__6.4.1 make_pipleline을 사용한 파이프라인 생성<br />
__6.4.2 단계 속성에 접근하기<br />
__6.4.3 그리드 서치 안의 파이프라인 속성에 접근하기<br />
6.5 전처리와 모델의 매개변수를 위한 그리드 서치<br />
6.6 모델 선택을 위한 그리드 서치<br />
6.7 요약 및 정리<br />
<br />
CHAPTER 7 텍스트 데이터 다루기<br />
7.1 문자열 데이터 타입<br />
7.2 예제 애플리케이션: 영화 리뷰 감성 분석<br />
7.3 텍스트 데이터를 BOW로 표현하기<br />
__7.3.1 샘플 데이터에 BOW 적용하기<br />
__7.3.2 영화 리뷰에 대한 BOW<br />
7.4 불용어<br />
7.5 tf-idf로 데이터 스케일 변경하기<br />
7.6 모델 계수 조사<br />
7.7 여러 단어로 만든 BOW(n-그램)<br />
7.8 고급 토큰화, 어간 추출, 표제어 추출<br />
__7.8.1 (한국어판 부록) KoNLPy를 사용한 영화 리뷰 분석<br />
7.9 토픽 모델링과 문서 군집화<br />
__7.9.1 LDA<br />
7.10 요약 및 정리<br />
<br />
CHAPTER 8 마무리<br />
8.1 머신러닝 문제 접근 방법<br />
__8.1.1 의사 결정 참여<br />
8.2 프로토타입에서 제품까지<br />
8.3 제품 시스템 테스트<br />
8.4 나만의 추정기 만들기<br />
8.5 더 배울 것들<br />
__8.5.1 이론<br />
__8.5.2 다른 머신러닝 프레임워크와 패키지<br />
__8.5.3 랭킹, 추천 시스템과 그 외 다른 알고리즘<br />
__8.5.4 확률 모델링, 추론, 확률적 프로그래밍<br />
__8.5.5 신경망<br />
__8.5.6 대규모 데이터셋으로 확장<br />
__8.5.7 실력 기르기<br />
8.6 마치며</p>
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">저자 소개</label>
							<div class="col-md-8">
								<textarea id="authorInfo" class="form-control" rows="10"><p>저자 : 안드레아스 뮐러<br />
저자 안드레아스 뮐러(ANDREAS MU?LLER)는 독일 본(BONN) 대학교에서 머신러닝으로 박사 학위를 받았습니다. 1년간 아마존의 컴퓨터 비전 응용 부서에서 머신러닝 연구자로 일한 뒤 뉴욕 대학교의 데이터 과학 센터에 합류했고, 현재는 컬럼비아 대학교에서 &lsquo;APPLIED MACHINE LEARNING&rsquo; 과목을 가르치고 있습니다. 지난 4년 동안 학계와 산업계에서 널리 사용하는 머신러닝 툴킷인 사이킷런의 핵심 기여자와 관리자로 활동했습니다. 또 잘 알려진 여러 머신러닝 패키지를 직접 만들거나 개발에 참여했습니다. 뮐러의 소망은 머신러닝 애플리케이션 개발의 진입 장벽을 낮추고, 수준 높은 머신러닝 알고리즘을 손쉽게 사용할 수 있는 공개 툴을 만드는 것입니다.<br />
<br />
저자 : 세라 가이도<br />
저자 세라 가이도(SARAH GUIDO)는 오랫동안 스타트업에서 일해온 데이터 과학자이자 뛰어난 콘퍼런스 발표자입니다. 파이썬, 머신러닝, 대량의 데이터와 기술 세계를 좋아합니다. 미시간 대학교의 대학원에 입학했으며, 지금은 뉴욕에 거주하고 있습니다.<br />
<br />
역자 : 박해선<br />
역자 박해선은 니트머스의 시니어 소프트웨어 엔지니어. 홍익대학교 기계공학과를 졸업했고 현대자동차 연구소를 나와 여러 벤처 회사를 거치며 소프트웨어 엔지니어 경력을 쌓았습니다. NHN TX, 11번가, SK텔레콤, 이베이코리아, LG전자 등의 프로젝트에서 광고 전달 및 서버 설계와 개발에 참여했습니다. 텐서플로 블로그(TENSORFLOW.BLOG)에 글을 쓰고, 텐서플로 코리아 그룹(FACEBOOK.COM/GROUPS/TENSORFLOWKR) 운영진으로 활동하고 있습니다.<br />
<br />
『텐서플로 첫걸음』(한빛미디어, 2016)을 우리말로 옮겼습니다.</p>
								</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">수량</label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="7" required="required">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">분류</label>
							<div class="col-md-8">
								<select>
									<option>프로그래밍</option>
									<option>데이터베이스</option>
									<option>컴퓨터 공학</option>
									<option>수험서</option>
								</select>
								<select>
									<option>JAVA</option>
									<option>C</option>
									<option selected="selected">파이썬</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">분류</label>
							<div class="col-md-8">
								<select>
									<option>프로그래밍</option>
									<option>데이터베이스</option>
									<option selected="selected">컴퓨터 공학</option>
									<option>수험서</option>
								</select>
								<select>
									<option>인공지능</option>
									<option selected="selected">머신러닝</option>
									<option>컴퓨터 구조</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-2 col-md-8">
								<button type="button" class="btn btn-success">수정</button>
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

<script type="text/javascript" src="js/admin/bookRegister.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
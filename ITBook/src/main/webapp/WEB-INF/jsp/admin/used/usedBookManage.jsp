<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 판매 신청 목록에서 완료 받으면 도서목록에 뜸-->
<h4 class="pull-left">중고 도서 관리</h4>
<div class="clearfix"></div>
<hr />
<div class="row">
	<div class="col-md-12">
		<div class="widget wred">
			<div class="widget-head">
				<div class="pull-left">중고 도서 목록</div>
				<div class="clearfix"></div>
			</div>
			<div class="widget-content medias">
				<div class="table-responsive">
					<table class="table table-bordered ">
						<thead>
							<tr>
								<th>표지</th>
								<th>제목</th>
								<th>매입일</th>
								<th>상품 상태</th>
								<th>
									<select>
										<option>전체</option>
										<option>판매 중</option>
										<option>판매 완료</option>
									</select>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/121/748/12174889.jpg?type=m140&udate=20171122"></td>
								<td id="book1" class="bookDetail"><a href="#">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</a></td>
								<td>2017.07.01</td>
								<td><span class="label label-warning">중</span></td>
								<td><span class="label label-success">판매 완료</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/110/148/11014824.jpg?udate=20160906"></td>
								<td id="book1" class="bookDetail"><a href="#">HTML5와 Java Script 기반의 웹 프로그래밍 정석</a></td>
								<td>2016.09.20</td>
								<td><span class="label label-success">최상</span></td>
								<td><span class="label label-warning">판매 중</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/121/748/12174889.jpg?type=m140&udate=20171122"></td>
								<td id="book1" class="bookDetail"><a href="#">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</a></td>
								<td>2017.07.01</td>
								<td><span class="label label-info">상</span></td>
								<td><span class="label label-success">판매 완료</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/110/148/11014824.jpg?udate=20160906"></td>
								<td id="book1" class="bookDetail"><a href="#">HTML5와 Java Script 기반의 웹 프로그래밍 정석</a></td>
								<td>2016.09.20</td>
								<td><span class="label label-success">최상</span></td>
								<td><span class="label label-warning">판매 중</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/121/748/12174889.jpg?type=m140&udate=20171122"></td>
								<td id="book1" class="bookDetail"><a href="#">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</a></td>
								<td>2017.07.01</td>
								<td><span class="label label-warning">중</span></td>
								<td><span class="label label-success">판매 완료</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/110/148/11014824.jpg?udate=20160906"></td>
								<td id="book1" class="bookDetail"><a href="#">HTML5와 Java Script 기반의 웹 프로그래밍 정석</a></td>
								<td>2016.09.20</td>
								<td><span class="label label-success">최상</span></td>
								<td><span class="label label-warning">판매 중</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/121/748/12174889.jpg?type=m140&udate=20171122"></td>
								<td id="book1" class="bookDetail"><a href="#">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</a></td>
								<td>2017.07.01</td>
								<td><span class="label label-info">상</span></td>
								<td><span class="label label-success">판매 완료</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/110/148/11014824.jpg?udate=20160906"></td>
								<td id="book1" class="bookDetail"><a href="#">HTML5와 Java Script 기반의 웹 프로그래밍 정석</a></td>
								<td>2016.09.20</td>
								<td><span class="label label-success">최상</span></td>
								<td><span class="label label-warning">판매 중</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/121/748/12174889.jpg?type=m140&udate=20171122"></td>
								<td id="book1" class="bookDetail"><a href="#">파이썬 라이브러리를 활용한 머신러닝 (사이킷런 핵심 개발자가 쓴 머신러닝과 데이터 과학 실무서)</a></td>
								<td>2017.07.01</td>
								<td><span class="label label-warning">중</span></td>
								<td><span class="label label-success">판매 완료</span></td>
							</tr>
							<tr>
								<td><img src="http://bookthumb.phinf.naver.net/cover/110/148/11014824.jpg?udate=20160906"></td>
								<td id="book1" class="bookDetail"><a href="#">HTML5와 Java Script 기반의 웹 프로그래밍 정석</a></td>
								<td>2016.09.20</td>
								<td><span class="label label-success">최상</span></td>
								<td><span class="label label-warning">판매 중</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="widget-foot">
				<div class="pull-left">
					<form action="#">
						<input type="text" name="keyword" placeholder="검색어를 입력해주세요">
						<button>검색</button>
						<button type="button" id="bookRegisterBtn" class="btn btn-success">도서 등록</button>
					</form>
				</div>
				<ul class="pagination pull-right">
					<li><a href="#">Prev</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">Next</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$("tr a").click(function() {
		location.href = "adminUsedBookDetail.do";
	});
</script>
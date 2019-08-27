<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="/ITBook/css/book/book_detail.css">
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/ITBook/ckeditor/ckeditor.js"></script>

<form id="wishNbasket" method="post">
	<input type="hidden" id="isbnInput" name="isbn">
	<input type="hidden" id="userInput" name="userIdx">
</form>
	
	
<!-- 모달  리뷰쓰기 -->
<!-- Modal -->
<div class="modal fade " id="reviewPop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-w">
    <div class="review-content review-content-w">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"><img alt="" src="images/store/review.jpg">  리뷰쓰기</h4>
      </div>
      <div class="modal-body layer_scroll">
        <form id="reviewFrm" method="post" enctype="multipart/form-data">
			<div class="layer_con_box">
				<fieldset>
					<div class="lp_register_li">
						<div class="i_tit">
							<span>* </span>도서명 :
						</div>
						<div class="i_con">
							<c:out value="${book.theme}"/>
						</div>
					</div>
					<div class="lp_register_li">
						<div class="i_tit">
							<span>* </span>제목 :
						</div>
						<div class="i_con">
						 <input type="text" name="hbr_title" id="hbr_title" class="i_text1" value="">
						</div>
					</div>
					<div class="lp_register_li">
						<div class="i_tit">
							<span>* </span>실무경력:
						</div>
						<div class="i_con">
							<select name="s1" class="i_select2">																	
							<option value="">경력선택</option>																
							<option value="1">1year</option>
							<option value="2">2year</option>	
							<option value="3">3year</option>	
							<option value="4">4year</option>	
							<option value="5">5year</option>
							<option value="6">6year</option>	
							<option value="7">7year</option>	
						    <option value="8">8year</option>	
							<option value="9">9year</option>	
							<option value="10">10year</option>	
						    <option value="11">고급</option>											
						</select>    	
						</div>
					</div>
					<div class="lp_register_li">

						<div class="i_tit">
							<span>* </span>별점평가
						</div>
						<div class="i_con">
							<div id="default" style="margin-top: 5px;">
							<img src="images/store/star.png" alt="" style="margin: 0px; height: 20px;" />
							</div>
							<div class="highlight">
							</div>
						</div>
					</div>

					<div class="lp_register_li">
						<div class="i_tit">
							<span>* </span>내용 :
						</div>
						<div class="i_con" id="hbc_cont_div">
							<label> <textarea class="form-control" name="editor1"
									id="editor1" rows="10" cols="50"></textarea>

							</label>
						</div>
					</div>
				</fieldset>
			</div>
		</form>        
      </div>
      <div class="modal-footer">
        
						<p class="note_tit">* 리뷰 작성시 유의사항</p>
						<p class="note_txt">글이나 이미지/사진 저작권 등 다른 사람의 권리를 침해하거나 명예를 훼손하는
							게시물은 이용약관 및 관련법률에 의해 제재를 받을 수 있습니다.</p>
						<p class="note_txt">
							1. 특히 뉴스/언론사 기사를 전문 또는 부분적으로 '허락없이' 갖고 와서는 안됩니다 (출처를 밝히는 경우에도
							안됨).<br /> 2. 저작권자의 허락을 받지 않은 콘텐츠의 무단 사용은 저작권자의 권리를 침해하는 행위로, 이에
							대한 법적 책임을 지게 될 수 있습니다.
						</p>

						<div class="btn_layer_default">
							<label><button id="proc_btn" name="proc_btn"
									type="button" value="" class="btn_blue"
									onclick="review_proc('re_ins','');">등록</button></label> <label><button
									id="reset_btn" name="reset_btn" type="button" value=""
									class="btn_white" onclick="frm_reset();">취소</button></label>
						</div>
					
      </div>
    </div>
  </div>
</div>

<!-- //모달 - 리뷰쓰기 -->

<!-- Main Content -->
<main class="main-content"> <!-- 카테고리 상세 wrap -->
<div class="store_view_wrap">
	<div class="store_view_wrap_l">
		<!-- 책 정보 -->
		<div class="store_view_area">
			<div class="store_product_box">
				<div class="store_product_box_img">
					<img
						src=<c:out value="${book.image}"/>
						alt="" class="thumb" />
				</div>
			</div>

			<div class="store_product_info_box">
				<h3><c:out value="${book.theme}"/></h3>


				<ul class="info_list">
					<li><strong>저자 : </strong><span><c:out value="${book.author}"/></span></li>
					<li><strong>출판사 : </strong><span><c:out value="${book.publish}"/> </span></li>
					<li><strong>출간 : </strong><span><c:out value="${book.publishdate}"/></span></li>
					<li><strong>ISBN : </strong><span><c:out value="${book.isbn}"/></span></li>
				</ul>

				<div class="book_amount">
						<span><strong>수량 : </strong></span><input type="number" class="book_amountN" value="1" onclick="book_amount();"></input>	
					</div>
				
				<div class="tag_area">
					<strong>TAG :</strong>
					<button>#자바</button>
					<button>#고급</button>
					<button>#스프링</button>
					<button>#토비</button>
					<button>#프로그래밍</button>
				</div>
				
			</div>
		</div>

		<!-- //책 정보 -->

		<!-- 별점 및 좋아요 -->


		<div class="store_like_area">

			<div class="store_grade">
				<span><img src="images/store/star.png" alt="" /> 4점 (10명)</span>
			</div>
			<div class="store_like">
				<span><img src="images/store/love.png" alt="" /> 좋아요 : </span><font
					id="likescore">3</font>
			</div>
			<div class="store_review">
				<button class="btn_review" data-toggle="modal" data-target="#reviewPop">
				리뷰쓰기!
				</button>
			</div>
		</div>
		<!-- //별점 및 좋아요 -->

		<!-- 하단 컨텐츠 -->
		<div class="store_detail_area">
			<!-- 텝메뉴 -->
			<div class="detial_tabs">
				<ul class="nav nav-tabs">
					<li onclick="javascript:hb_show_tabs('0');"><a
						href="javascript:;">전체</a></li>
					<li onclick="javascript:hb_show_tabs('1');"><a
						href="javascript:;">책소개</a></li>
					<li onclick="javascript:hb_show_tabs('2');"><a
						href="javascript:;">저자소개</a></li>
					<li onclick="javascript:hb_show_tabs('3');"><a
						href="javascript:;">목차</a></li>
					<li onclick="javascript:hb_show_tabs('4');"><a
						href="javascript:;">독자리뷰</a></li>
					<li onclick="javascript:hb_show_tabs('5');"><a
						href="javascript:;">교환/반품/품절</a></li>
				</ul>

				<!-- 책소개 -->
				<div id="tabs_1">
					<p class="detail_tit" style="display: none;">책소개</p>
					<div id="" class="detail_conbox hanbit_edit_view">
						${book.intro}

						<p>&nbsp;</p>
					</div>
				</div>
				<!-- //책소개 -->

				<!-- 저자소개 -->
				<div id="tabs_2">
					<p class="detail_tit" style="display: none;">저자소개</p>
					<div id="" class="detail_conbox">
						<!-- 저자 소개 -->
						<div class="author_box">
							${book.authorinfo}
						</div>
						<!-- //저자 소개 -->

					</div>
				</div>
				<!-- //저자소개 -->

				<!-- 목차 -->
				<div id="tabs_3">
					<p class="detail_tit" style="display: none;">목차</p>
					<div id="" class="detail_conbox hanbit_edit_view">
						${book.contents}
					</div>
				</div>
				<!-- //목차 -->

				<!-- 출판사리뷰 -->
				<!-- //출판사리뷰 -->

				<!-- 독자리뷰 -->

				<div id="tabs_4">
					<a id="review_tab"></a>
					<p class="detail_tit" style="display: none;">독자리뷰</p>

					<div id="" class="detail_conbox">
						<div class="detail_review_area">
		<!-- 유저 댓글 목록 시작 -->
									<ul>
										<li>
											<div class="comment" style="border-bottom:1px solid #e7e7e7;">
												<h6>
													bgh0987<span>| 2018-03-02, 4:00pm | 경력 : 2년차  |</span><span><img src="images/store/star.png" alt="" style="margin: 0px; height: 20px;"/></span>
												</h6>
												<p style="margin-bottom: 5px;">
												   <strong><i class="fas fa-chevron-left"></i>스프링책 추천!!</strong><i class="fas fa-chevron-right"></i><br>
												
												스프링에 대해 좀 더 알고 싶어서 구매했는데 내용이 좀 어렵긴 하네요. 하지만
												    아주 유익한 책입니다.!! 추천합니다.</p>
											</div></li>
										<li>
										<li>
											<div class="comment">
												<h6 style="margin-top: 10px;">
													ohj1234<span>| 2018-03-13, 1:39pm | 경력 : 없음  |</span><span><img src="images/store/star.png" alt="" style="margin: 0px; height: 20px;"/></span>
												</h6>
												<p style="margin-bottom: 5px;">
												 <strong><i class="fas fa-chevron-left"></i>생각보다 어렵네요 ㅠㅠ</strong><i class="fas fa-chevron-right"></i><br>
												스프링 공부하려고 샀는데 생각보다 많이 어렵네요 ㅠㅠ </p>
											</div>
											</li>
										<li>
										
									</ul>
									<!-- 유저 댓글 목록 끝 -->
								</div>
								<!-- 댓글 목록 끝 -->
						</div>
					</div>

				<!-- //독자리뷰 -->

				<div id="tabs_5">
					<a id="review_tab"></a>
					<p class="detail_tit" style="display: none;">교환/반품/품절</p>

					<!-- *** s:.box_detail_content - 교환/반품/품절 *** -->
					<div class="box_detail_content">
						<h2 class="title_detail_basic">교환/반품/품절안내</h2>
						<p class="margin_top20">※ 상품 설명에 반품/교환 관련한 안내가 있는 경우 그 내용을
							우선으로 합니다. (업체 사정에 따라 달라질 수 있습니다.)</p>
						<table class="table_simple2 table_detail_guide margin_top10"
							summary="교환/반품/품절안내 상세테이블로 목록으로 반품/교환방법, 반품/교환가능 기간, 반품/교환비용, 반품/교환 불가 사유, 상품 품절, 소비자 피해보상 환불지연에 따른 배상">
							<caption class="caption_hidden">교환/반품/품절안내</caption>
							<colgroup>
								<col width="22%" />
								<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row">반품/교환방법</th>
									<td><strong>마이룸 &gt; 주문관리 &gt; 주문/배송내역 &gt; 주문조회&gt; 반품/교환신청<br /> 
											[1:1상담&gt;반품/교환/환불]또는 고객센터 (1000-1000)</strong>
								</tr>
								<tr>
									<th scope="row">반품/교환가능 기간</th>
									<td>변심반품의 경우 수령 후 7일 이내,<br /> 상품의 결함 및 계약내용과 다를 경우 문제점
										발견 후 30일 이내
									</td>
								</tr>
								<tr>
									<th scope="row">반품/교환비용</th>
									<td>변심 혹은 구매착오로 인한 반품/교환은 반송료 고객 부담</td>
								</tr>
								<tr>
									<th scope="row">반품/교환 불가 사유</th>
									<td>
										<ul class="list_normal">
											<li>소비자의 책임 있는 사유로 상품 등이 손실 또는 훼손된 경우<br /> (단지 확인을 위한
												포장 훼손은 제외)
											</li>
											<li>소비자의 사용, 포장 개봉에 의해 상품 등의 가치가 현저히 감소한 경우<br /> 예)
												화장품, 식품, 가전제품(악세서리 포함) 등
											</li>
											<li>복제가 가능한 상품 등의 포장을 훼손한 경우<br /> 예) 음반/DVD/비디오,
												소프트웨어, 만화책, 잡지, 영상 화보집
											</li>
											<li>소비자의 요청에 따라 개별적으로 주문 제작되는 상품의 경우 ((1)해외주문도서)</li>
											<li>디지털 컨텐츠인 eBook, 오디오북 등을 1회 이상 다운로드를 받았을 경우</li>
											<li>시간의 경과에 의해 재판매가 곤란한 정도로 가치가 현저히 감소한 경우</li>
											<li>전자상거래 등에서의 소비자보호에 관한 법률이 정하는 소비자 청약철회 제한 내용에<br />
												해당되는 경우
											</li>
										</ul> (1) 해외주문도서 : 이용자의 요청에 의한 개인주문상품으로 단순변심 및 착오로 인한 취소/교환/반품 시
										‘해외주문 반품/취소 수수료’ 고객 부담 (해외주문 반품/취소 수수료 : ①양서-판매정가의 12%,
										②일서-판매정가의 7%를 적용)

									</td>
								</tr>
								<tr>
									<th scope="row">상품 품절</th>
									<td>공급사(출판사) 재고 사정에 의해 품절/지연될 수 있으며, 품절 시 관련 사항에 대해서는<br />
										이메일과 문자로 안내드리겠습니다.
									</td>
								</tr>
								<tr>
									<th scope="row">소비자 피해보상<br /> 환불지연에 따른 배상
									</th>
									<td>
										<ul class="list_normal">
											<li>상품의 불량에 의한 교환, A/S, 환불, 품질보증 및 피해보상 등에 관한 사항은<br />
												소비자분쟁해결 기준 (공정거래위원회 고시)에 준하여 처리됨
											</li>
											<li>대금 환불 및 환불지연에 따른 배상금 지급 조건, 절차 등은 전자상거래 등에서의<br />
												소비자 보호에 관한 법률에 따라 처리함
											</li>
										</ul>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- *** //e:.box_detail_content - 교환/반품/품절 *** -->
				</div>



				<!-- 추천도서 -->
				<!-- //추천도서 -->
			</div>
			<!-- //텝메뉴 -->
		</div>
		<!-- //하단 컨텐츠 -->
	</div>

	<div class="store_payment_area">
		<!-- 결재 정보 -->
		<fieldset>
			<legend>결재하기</legend>
			<!-- 2차 상품이 있는 경우 -->
			<!-- 2차 상품이 없는 책 일 경우 -->
			<label class="payment_box curr">
				<p>
					<span class="pbl">정가 : </span><span class="pbr"><del>75,000원 </del></span>
				</p>
				<p>
					<span class="pbl"><strong>판매가 : </strong></span><span class="pbr"><strong>75,000</strong>원<span>
					(0%	off)</span></span>
				</p>
				<p>
					<span class="pbl">마일리지 : </span><span class="pbr">750점 (3%)</span>
				</p>
			</label>

			<!-- 2차 상품이 없는 eBook 일 경우 -->


			<!-- 2차 상품이 없고 무료인 eBook 일 경우-->


			<!-- 배송료 -->
			<div class="shopping_charge">
				<div class="shopping_charge_tit">
					<span>배송료 : </span>0원<a href="javascript:;"
						onClick="view_hover('shopping_charge_open','','show')"><img
						src="http://www.hanbit.co.kr/images/store/ico_question.gif"
						alt="배송료란?" /></a>
				</div>

				<div id="shopping_charge_open" class="shopping_charge_open">
					<p class="tit">배송료 안내</p>
					<ul>
						<li>책, 아이템 등 상품을 3만원 이상 구매시 무료배송</li>
						<li>브론즈, 실버, 골드회원이 주문하신 경우 무료배송</li>
					</ul>
					<p>무료배송 상품을 포함하여 주문하신 경우에는 구매금액에 관계없이 무료로 배송해 드립니다.</p>
					<a href="javascript:;"
						onClick="view_hover('shopping_charge_open','','hide')"><img
						src="http://www.hanbit.co.kr/images/store/btn_shipping_charge.png"
						alt="닫기" /></a>
				</div>
			</div>
			<!-- //배송료 -->

			<input type="hidden" name="p_type_kind" id="p_type_kind" value="B">
			<!-- 결재버튼 -->

			<label>
				<button name="btnAddCart" id="btnAddCart" type="button" value="장바구니"
					class="btn_baket">장바구니</button>
			</label> <label>
				<button name="" type="submit" value="위시리스트" class="btn_wish">위시리스트</button>
			</label> <label>
				<button name="btnBuy" id="btnBuy" type="submit" value="구매하기" class="btn_buy" >구매하기</button>
			</label>

			<!-- //결재버튼 -->
		</fieldset>

		<!-- //결재 정보 -->

		<!-- 관련 사이트 -->
		<!-- //관련 사이트 -->
	</div>
</div>

<!-- //카테고리 상세 wrap --> 



<!-- //레이어 팝업 - 리뷰쓰기 --> <!-- 레이어 팝업 - 도서인증 --> </main>
<!-- Main Content -->
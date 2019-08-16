<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <link rel="stylesheet" type="text/css" href="/ITBook/css/book/book.css">

<!-- Inner Banner -->
<div class="parallax-window inner-banner tc-padding overlay-dark"
	style="background: url(images/inner-banner/img-10.jpg)">
	<div class="container">
		<div class="inner-page-heading style-2 h-white">
			<h2 style="font-size: 30px; color: #2c2255">전체 도서</h2>
			<p style="font-size: 20px; color: #2c2255">다양한 도서들을 만나보세요.</p>
		</div>
	</div>
</div>
<!-- Inner Banner -->
    
	<!-- breadcrumb -->
  	<div class="breadcrumb-holder white-bg">
  		<div class="container">
  			<div class="breadcrumbs">
  				<ul>
  					<li><a href="#">Home</a></li>
  					<li>Shop</li>
  				</ul>
  			</div>
  		</div>
  	</div>
  	<!-- Breadcrumb -->

<!-- Main Content -->
<main class="main-content"> <!-- Shop Grid -->
	<div class="product-grid-holder tc-padding">
		<div class="container">
			<div class="row">	
				<!-- Content -->
				<div class="col-lg-12 col-md-12 pull-right pull-none">
					<!-- 드랍다운 카테고리 시작 -->
					<div class="col-lg-12" style="margin-bottom: 50px;">
						<div class="dropdown dropdown_wrap" style="position: absolute;">
							<button class="btn btn_category dropdown-toggle"
								id="categoryTarget" data-toggle="dropdown" type="button">
								<div class="pull-left">카테고리</div>
								<div class="pull-right">
									<div class="bar_ico">
										<div></div>
										<div></div>
										<div></div>
									</div>
								</div>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Javascript</a></li>
								<li><a href="#">Java</a></li>
								<li><a href="#">c#</a></li>
								<li><a href="#">c/c++</a></li>
								<li><a href="#">Oracle</a></li>
								<li><a href="#">MySQL/Maria DB</a></li>
								<li><a href="#">MsSQL</a></li>
								<li><a href="#">웹디자인</a></li>
								<li><a href="#">기획/설계</a></li>
								<li><a href="#">IT교양</a></li>
							</ul>
						</div>
						<!-- 드랍다운 카테고리 끝 -->
	
						<div class="lft_sec" style="width: 600px; margin-left: 150px;">
							<ul class="txt_tab_menu cf">
								<li><a href="">맞춤도서</a></li>
								<li><a href="">신간도서</a></li>
								<li><a href="">전체 도서</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
	
		<!-- Filter Sort -->
			<div class="product2-sort">
				<div class="sort-dropdown pull-left">
					<button class="s-bn">정확도순|</button>
					<button class="s-bn">낮은가격순|</button>
					<button class="s-bn">높은가격순|</button>
					<button class="s-bn">평점순</button>
				</div>
				<div class="sort-dropdown pull-right">
						<form class="search-bar">
							<input type="text" class="form-control_search" required="required" placeholder="Search...">
						</form>
			   </div> 
			  
				<div class="sort-dropdown pull-right">
				    <select>
						<option>전체</option>
						<option>도서명</option>
						<option>저자/역자</option>
					</select>
				</div>
			</div>
			<div class="search_re2">
		         <button><i class="fas fa-search"></i></button>
		    </div>
			<!-- Filter Sort -->
			<!-- Products -->
			<div class="row">
					 	<c:forEach items="${bookList}" var="bookList" varStatus="status">
				<div class="col-lg-3 col-xs-6 r-full-width">
							<div class="product-box">
								<div class="product-img">
									<a href="bookDetail.do"><img
										src="${bookList.bImage}" alt=""></a>
									<ul class="product-cart-option position-center-x">
										<li><a href="#"><i class="fa fa-eye"></i></a></li>
										<li><a href="#"><i class="fa fa-cart-arrow-down"></i></a></li>
										<li><a href="#"><i class="fa fa-share-alt"></i></a></li>
									</ul>
								</div>
								<div class="product-detail">
									<span>${bookList.bAuthor}</span> <span>${bookList.publish} | ${bookList.publishDate}</span>
									<h5 class="ellipsis">${bookList.bTheme}</h5>
									<p class="ellipsis">${bookList.bIntro}</p>
									<div class="rating-nd-price">
										<strong><fmt:formatNumber pattern="###,###" value="${bookList.price}"/></strong>
										<ul class="rating-stars">
											<li><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
											<li><i class="fa fa-star"></i></li>
											<li><i class="far fa-star"></i></li>
										</ul>
									</div>
								</div>
							</div>	
				</div>	
					</c:forEach>				
			</div>
	<!-- Products -->
						
	
			<!-- Pagination -->
			<div class="col-lg-3 full-width"></div>
			<div class="col-lg-6 full-width">
				<div class="pagination-holder">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous">Prev</a></li>
						<li><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li><a href="#">7</a></li>
						<li><a href="#">...</a></li>
						<li><a href="#">23</a></li>
						<li><a href="#" aria-label="Next">Next</a></li>
					</ul>
				</div>
			</div><!-- Pagination -->						
	     </div> <!-- container -->             
	</div>
</main>
<!-- Main Content -->
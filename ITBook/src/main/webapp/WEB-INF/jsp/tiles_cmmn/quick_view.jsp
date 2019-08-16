<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Quick View  분야/신간 도서에서 책을 클릭시 나오는 모달창 -->
<div class="modal fade quick-view" id="quick-view" role="dialog">
	<div class="position-center-center" role="document">
		<div class="modal-content">
			<button class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<div class="single-product-detail">
				<div class="row">

					<!-- Product Thumnbnail -->
					<div class="col-sm-5">
						<div class="product-thumnbnail">
							<img src="/itbook/images/qiuck-view/img-01.jpg" alt="">
						</div>
					</div>
					<!-- Product Thumnbnail -->

					<!-- Product Detail -->
					<div class="col-sm-7">
						<div class="single-product-detail">
							<span class="availability">Availability :<strong>Stock<i class="fa fa-check-circle"></i></strong></span>
							<h3>Land the Earth Beach</h3>
							<ul class="rating-stars">
								<li><i class="fa fa-star"></i></li>
								<li><i class="fa fa-star"></i></li>
								<li><i class="fa fa-star"></i></li>
								<li><i class="fa fa-star"></i></li>
								<li><i class="fa fa-star-half-o"></i></li>
								<li>1 customer review</li>
							</ul>
							<div class="prics"><del class="was">$32.00</del><span class="now">$30.99</span></div>
							<h4>Overview</h4>
							<p>With this highly anticipated new novel, the author of the bestselling Life of Pi returns to the storytelling power and luminous wisdom of his master novel. The High Mountains of Portugal.</p>
							<div class="quantity-box">
								<label>Qty :</label>
								<div class="sp-quantity">
									<div class="sp-minus fff"><a class="ddd" data-multi="-1">-</a></div>
									<div class="sp-input">
									  <input type="text" class="quntity-input" value="1" />
									</div>
									<div class="sp-plus fff"><a class="ddd" data-multi="1">+</a></div>
								</div>
							</div>
							<ul class="btn-list">
								<li><a class="btn-1 sm shadow-0 " href="#">add to cart</a></li>
								<li><a class="btn-1 sm shadow-0 blank" href="#"><i class="fa fa-heart"></i></a></li>
								<li><a class="btn-1 sm shadow-0 blank" href="#"><i class="fa fa-repeat"></i></a></li>
								<li><a class="btn-1 sm shadow-0 blank" href="#"><i class="fa fa-share-alt"></i></a></li>
							</ul>
						</div>
					</div>
					<!-- Product Detail -->

				</div>
			</div>
			<!-- Single Product Detail -->

		</div>
	</div>
</div>
<!-- Quick View -->
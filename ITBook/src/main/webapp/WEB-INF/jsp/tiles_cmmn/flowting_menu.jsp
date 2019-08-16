<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--좌측 플로팅 메뉴-->
		<div class="lft_floating_menu">
			<div class="lfm_wrap">
				<ul>
					<li><strong>최근에 본 상품</strong></li>
					<li><a href="#"><img src="/itbook/images/upcoming-release/thumb/img-01.jpg" alt=""></a></li>
					<li><a href="#"><img src="/itbook/images/upcoming-release/thumb/img-02.jpg" alt=""></a></li>
					<li><a href="#"><img src="/itbook/images/upcoming-release/thumb/img-03.jpg" alt=""></a></li>
				</ul>
				<button id="btnTog" class="btn_tog">X</button>
			</div>
		</div>
		<script>
		(function(){
			var	btnTog = document.getElementById("btnTog");
			var isToggle = true;
			btnTog.addEventListener('click', function(){
				var target = document.querySelector('.lft_floating_menu');
				if(isToggle){
					target.setAttribute('class','lft_floating_menu isHide');
					this.innerText = "O";
				}else{
					target.setAttribute('class','lft_floating_menu isShow');
					this.innerText = "X";
				}
				isToggle = !isToggle;
			});
		}());
		</script>
		<!--좌측 플로팅 메뉴-->
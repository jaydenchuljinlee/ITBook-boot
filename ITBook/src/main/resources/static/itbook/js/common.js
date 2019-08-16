/**
 * 모든 소스에서 공통으로 사용할 자바스크립트
 * 문제 생기면 물어봐야하니깐 반드시 작업자 이름 써놓을 것
*/
$(function(){
	
	// [종민] 카테고리의 dropdown 일어날때 부가 효과
	var categoryFn = (function(){
	
		var dropdownState = true;
		$('#categoryTarget').on('click', function() {
			if(dropdownState){
				$('.bar_ico').addClass("rotate_on"); 	
			} else{
				$('.bar_ico').removeClass("rotate_on");
			}
			dropdownState =! dropdownState;		    	
		});
	
		$("body").on('click', function() {
		    var $target = $("#categoryTarget");
		    if (!$target.is(event.target) && $target.has(event.target).length === 0) {
				$('.bar_ico').removeClass("rotate_on");
				dropdownState = true;
		    }
		});	
	})();

}); // end of $(function() { })
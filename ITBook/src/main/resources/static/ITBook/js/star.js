/*별점 : .star-input*/
/*출처 : http://codepen.io/naradesign/pen/zxPbOw*/
var starRating = function(){
var $star = $(".star-input"),
    $result = $("#input_grade");
	
  	$(document)
	.on("focusin", ".star-input>.input", 
		function(){
   		 $(this).addClass("focus");
 	})
		 
   	.on("focusout", ".star-input>.input", function(){
    	var $this = $(this);
    	setTimeout(function(){
      		if($this.find(":focus").length === 0){
       			$this.removeClass("focus");
     	 	}
   		}, 100);
 	 })
  
    .on("change", ".star-input :radio", function(){
    	$("#input_grade").val($(this).next().text());
  	})
    .on("mouseover", ".star-input label", function(){
    	
    	$("#input_grade").val($(this).text());
    	
    })
    .on("mouseleave", ".star-input>.input ", function(){
    	var $checked = $(".star-input").find(":checked");
    	console.log($checked.length);
    		/*if($checked.length === 0){
    			$("#input_grade").val("0");
   		 	} else {
   		 		
     	 		
    		}*/
    	$("#input_grade").val($checked.next().text());
  	});
};

starRating();
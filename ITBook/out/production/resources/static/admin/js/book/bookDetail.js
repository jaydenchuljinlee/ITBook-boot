var select = {
		
	displayChildSelectBox : function(list) {
		
		if (list.length > 0) {
			
			$.each(list, function(i,item){
				
				var optionStr = "<option value=" + item.code + ">" + 
						item.name + "</option>";
						
						$("#category2").append(optionStr);
			})						
		} else {
			
			 $("#category2").append("<option value=''>없음</option>");
			
		}
	}
};


$(function() {
	
	
	
	var category = $("#category1").val();
	
	//createCategory(category);
			
	$("#category1").on("change",function() {
		
		category = $(this).val();
		
		createCategory(category);
	});
})
	
			
 function createCategory(category) {
	
	$("#category2").children().remove();
	
	var form = {"param" : category};
	
	$.ajax({
        url			: "categoryList_2",
        type		: "post",
        data 		: JSON.stringify(form), // Stirng, object, array 스트링이 아니면, 쿼리스트링(키 or 값)으로 바꿔줌
        contentType : "application/json",
        success		: function(data){
			
        	var changeBox	= "";
			
			if (data.result == "SUCCESS") {
				select.displayChildSelectBox(data.list);
			}
        }
	});
};


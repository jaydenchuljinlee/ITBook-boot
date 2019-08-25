$(function() {
		
		var recommend	= new Array(),
			r_tag		= new Array();
		var i			= 0;
		
		
		$(".hashtag").click(function() {
			
			for(var j = 0; j < $(".selected_recommend").find(".hashtag").length +1; j++) {
				recommend[i]	= $(".ul_tag_list_head").find("li:eq("+j+")").find(".hashtag").children().text().trim();
				r_tag[i]		= $(".ul_tag_list_head").find("li:eq("+j+")").find(".hashtag").val();
			} 
			
			for(var j = 0; j < $(".selected_recommend").find(".hashtag").length+1; j++) {
				
					if($(this).children().text().trim() === recommend[j]) {
						return;
					}
			}
			
			var rcmString = "<li class='Tag_recommend selected_recommend' style=''>" +
							"<button value='" + $(this).val() + "' type='button' class='hashtag recommended' id='recommend_"+i+"'>" +
							"#<span>" + $(this).children().text().trim() + "</span>"
							"</button>" +
							"</li>";
							
			$(".ul_tag_list_head").append(rcmString);
			
			recommend[i] 	= $(".ul_tag_list_head").find("li:eq("+i+")").find(".hashtag").children().text().trim();
			r_tag[i]		=$(".ul_tag_list_head").find("li:eq("+i+")").find(".hashtag").val();
			i++;
			
			$(".recommended").click(function() {
				$(this).remove();
			});
			
		});
		
		
		
		$(".selected_recommend").click(function() {
			
			console.log($(this).html());
		})
		
		$(".search_re").click(function() {
			var thisParam	= r_tag;
			var str			= "";
			
			r_tag.sort();
			
			for(var j = 0; j < r_tag.length; j++) {
				
				if (j === 0) {
					str = r_tag[j];
				} else {
					str += "," + r_tag[j];
				}
			}
			
			var form		= {"param" : str};
			console.log(form);
			
			console.log(JSON.stringify(form));
			$.ajax({
				
				url		: "hashtagSearch.do",
				type	:  "post",
				data	: JSON.stringify(form), // Stirng, object, array 스트링이 아니면, 쿼리스트링(키 or 값)으로 바꿔줌
		        contentType : "application/json",
		        success		: function(data) {
		        	alert("SUCCESS");
		        }
				
			})
	})
		
});
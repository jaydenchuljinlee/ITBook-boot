$(document).ready(function() {
		
		init_1();
			
		$("#category1").change(function() {
			var thisParam = this.value;
			
			$("#category2").children().remove();
			
			var form = {"param" : thisParam};
			
			//console.log(JSON.stringify(form));
			
			$.ajax({
			      //type:"GET",
			        url			: "categoryList_2",
			        type		: "post",
			        data 		: JSON.stringify(form), // Stirng, object, array 스트링이 아니면, 쿼리스트링(키 or 값)으로 바꿔줌
			        contentType : "application/json",
			        success		: function(data){
						
			        	console.log("success");
			        	
			        	var jobj 	= JSON.parse(data);
			        	var changeBox	= "";
			        	
						console.log(jobj.list);
						
						if (jobj.result == "SUCCESS") {
							select.displayChildSelectBox(jobj.list);
						}
			        }
			    })
		});
	});
	
			
		 function init_1() {
			
			$("#category2").children().remove();
			
			var str1 = $("#category1").val();
			
			var form1 = {"param" : str1};
			
			//console.log(JSON.stringify(form));
			
			$.ajax({
				//type:"GET",
		        url			: "categoryList_2",
		        type		: "post",
		        data 		: JSON.stringify(form1), // Stirng, object, array 스트링이 아니면, 쿼리스트링(키 or 값)으로 바꿔줌
		        contentType : "application/json",
		        success		: function(data){
					
		        	console.log("success");
		        	
		        	var jobj 	= JSON.parse(data);
		        	var changeBox	= "";
		        	
					console.log(jobj.list);
					
					if (jobj.result == "SUCCESS") {
						select.displayChildSelectBox(jobj.list);
					}
		        }
			});
		};

	var select = {
			
			displayChildSelectBox : function(list) {
				
				if (list.length > 0) {
					
					$.each(list, function(i,item){
						
						var optionStr = "<option value=" + item.scNo + ">" + 
								item.scCategory + "</option>";
								
								$("#category2").append(optionStr);
					})						
				} else {
					
					 $("#category2").append("<option value=''>없음</option>");
					
				}
			}
	};
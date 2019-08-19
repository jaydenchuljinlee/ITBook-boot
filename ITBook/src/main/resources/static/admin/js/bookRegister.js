$(function() {
	$("#searchBookBtn").click(function() {
		var that = $(this);
		var isbn = $("#searchIsbn").val();
		
		if (isbn === "") {
			alert("isbn을 입력해주세요!");
		} else {
			$("#loader").show();

			$.ajax({
				url			: "adminBookSearch",
				data		: {'isbn' : isbn},
				dataType	: "xml",
				type		: "get",
				success		: function(xml) {
					var result = $(xml).find("display").text().trim();
					
					if(result === "0") {
						$("#loader").hide();
						alert("결과가 없습니다. 다시 확인해 주세요");
					} else {
						var book = $(xml).find("item");
						console.log(book.find("image").text().split("?")[0]);
						$("#isbn").val($("#searchIsbn").val());
						$("#bookThumbnail").val(book.find("image").text().split("?")[0]);
						$("#thumbnail").attr("src", book.find("image").text().split("?")[0]);
						$("#title").val(book.find("title").text());
						$("#publisher").val(book.find("publisher").text());
						$("#price").val(book.find("price").text());
						var pubdate = book.find("pubdate").text();
						var pubdateYear = pubdate.substr(0,4);
						var pubdateMonth = pubdate.substr(4,2);
						var pubdateDate = pubdate.substr(6);
						$("#publishDate").val(pubdateYear + "-" + pubdateMonth + "-" + pubdateDate);
						
						var link = book.find("link").text();
						
						$.ajax({
							url			: "adminBookSearchDetail",
							data		: {'url' : link},
							dataType	: "json",
							type		: "get",
							success		: function(json) {
								var page = json.page;
								$("#author").val(json.author);
								$("#page").val(json.page);
								$("#originalTitle").val(json.originalTitle);
								$("#translator").val(json.translator);
								CKEDITOR.instances.info.insertHtml(json.info);
								CKEDITOR.instances.contents.insertHtml(json.contents);
								CKEDITOR.instances.authorInfo.insertHtml(json.authorInfo);
								$("#loader").hide();
								window.scrollTo(0,0);
							}
						});
						
					}
					
				}
				
			});
		}
		
	});
});

//CKEditor
$(function() {
	CKEDITOR.config.height = 300;
	CKEDITOR.config.language = 'ko';
	CKEDITOR.replace('info');
	CKEDITOR.replace('contents');
	CKEDITOR.replace('authorInfo');
});
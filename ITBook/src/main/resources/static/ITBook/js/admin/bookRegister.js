$(function() {
	//isbn 검색 시작
	$("#searchBookBtn").click(function() {
		var that = $(this);//현재 검색한 이벤트
		var isbn = $("#searchIsbn").val();//isbn 번호
		
		if (isbn === "") {//isbn 검색 input이 비어있을 때,
			alert("isbn을 입력해주세요!");
		} else {
			$("#loader").show();

			//isbn을 통해 네이버 책 검색을 위한 크롤링 컨트롤러를 요청
			$.ajax({
				url			: "adminBookSearch.do",
				data		: {'isbn' : isbn},
				dataType	: "xml",//네이버 책 정보의 return type
				type		: "get",//보낼 정보가 보안상 중요하지 않고, isbn 하나이므로 get을 통해 요청
				success		: function(xml) {
					var result = $(xml).find("display").text().trim();//결과값
					
					if(result === "0") {
						$("#loader").hide();
						alert("결과가 없습니다. 다시 확인해 주세요");
					} else {
						var book = $(xml).find("item");//책 전체 정보를 book이라는 변수에 담는다.
						console.log(book.find("image").text().split("?")[0]);
						
						$("#isbn").val($("#searchIsbn").val());//isbn
						$("#bookThumbnail").val(book.find("image").text().split("?")[0]);//섬네일
						$("#thumbnail").attr("src", book.find("image").text().split("?")[0]);//섬네일
						$("#title").val(book.find("title").text());//책 제목
						$("#publisher").val(book.find("publisher").text());//출판사
						$("#price").val(book.find("price").text());//가격
						
						var pubdate = book.find("pubdate").text();//출판 전체 날짜
						var pubdateYear = pubdate.substr(0,4);//출판 년도
						var pubdateMonth = pubdate.substr(4,2);//출판 월
						var pubdateDate = pubdate.substr(6);//출판 일
						
						$("#publishDate").val(pubdateYear + "-" + pubdateMonth + "-" + pubdateDate);//출판 날짜를 형식에 맞게 다시 제공
						
						var link = book.find("link").text();
						
						//책의 상세 정보는 현재 크롤링한 페이지에서 나오지 않기 때문에 상세 정보 페이지에서 한 번 더 요청
						$.ajax({
							url			: "adminBookSearchDetail.do",
							data		: {'url' : link},//현재 크롤링 되어있는 isbn 페이지
							dataType	: "json",//여기서 return 되는 데이터 타입은 json 
							type		: "get",
							success		: function(json) {
								
								var page = json.page;//상세 페이지 정보
								
								$("#author").val(json.author);//작가
								$("#page").val(json.page);//총 페이지 수
								$("#originalTitle").val(json.originalTitle);//원래 책 이름
								$("#translator").val(json.translator);//역자
								
								//글자 수가 많기 때문에 에디터에 추가
								CKEDITOR.instances.info.insertHtml(json.info);
								CKEDITOR.instances.contents.insertHtml(json.contents);
								CKEDITOR.instances.authorInfo.insertHtml(json.authorInfo);
								
								$("#loader").hide();
								
								window.scrollTo(0,0);//창을 맨위로
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

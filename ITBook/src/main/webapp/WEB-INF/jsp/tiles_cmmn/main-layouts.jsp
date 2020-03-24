<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<tiles:insertAttribute name="head" />
</head>
<body>
	
	<div class="wrapper push-wrapper">
		<!-- Header start-->
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="search_bar" />
		<tiles:insertAttribute name="flowting_menu" />
		<!-- Header end-->
		<!-- 메인 컨텐츠 -->
		<tiles:insertAttribute name="best_saler" />
		<tiles:insertAttribute name="new_book" />
		<tiles:insertAttribute name="category_book" />
		<tiles:insertAttribute name="semina" />
		<tiles:insertAttribute name="blog_study" />
		<!-- 메인 컨텐츠 -->
		<tiles:insertAttribute name="footer" />
	</div>

	<tiles:insertAttribute name="best_saler_modal" />
	<tiles:insertAttribute name="login_modal" />
	<tiles:insertAttribute name="quick_view" />
	<!-- Switcher  Panel -->
	<tiles:insertAttribute name="link_js" />

	<script type="text/javascript">
		$(function() {
			$(".btn_social").click(function() {
				var socialType = $(this).data("social");
				location.href = "/oauth2/authorization/" + socialType;
			});

			$(".pageMove").on("click",function() {
				var page = $(this).data("page");

				$("#pageMoveFrm").attr("action",page);
				$("#pageMoveFrm").submit();

			});

			$("#loginBtn").on("click",function() {

				var id	= $("#id_input").val(),
					pwd = $("#pwd_input").val();

				$("#loginFrm").attr("action","/main");
				$("#loginFrm").attr("method","post");
				$("#loginFrm").submit();

				/*$.ajax({
					url			: "/login",
					data		: {"identity" : id, "password" : pwd},
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
					},
					error		: function(error) {
						console.log("adminBookSearchDetail 에 대한 에러");
						console.log(error);
						alert("데이터를 가져오는 중에 오류가 발생하였습니다.");

					}
				});*/
			});
		})
	</script>
	<form id="pageMoveFrm">
	</form>
</body>
</html>
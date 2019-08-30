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
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>로그인</title>
	    <link rel="stylesheet" href="/css/base.css">
	    <link rel="stylesheet" href="/css/bootstrap.min.css">
	    
	    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body>
		
		<!-- header -->
		<tiles:insertAttribute name="head"/>
		<!-- header -->

		<!--content-->
	    <tiles:insertAttribute name="content"/>
		
		<!--footer-->
		<tiles:insertAttribute name="footer"/>
		<!--/footer-->
		
		<script>
		    $(".btn_social").click(function() {
		        var socialType = $(this).data("social");
		        location.href = "/oauth2/authorization/" + socialType;
		    });
		</script>
	</body>
</html>

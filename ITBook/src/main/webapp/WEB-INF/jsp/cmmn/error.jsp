<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

<!--nav-->
<div >
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/" class="navbar-brand" style="text-decoration:none;">
                    <img src="/images/spring_boot_gray.png" class="img-rounded" style="display:inline-block;height:100%;margin-right:5px" />
                    <span style="vertical-align:middle;">Spring Community Web</span>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/logout">LOGOUT</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!--/nav-->

<div class="container">
   <div class="text-center">
   		<c:out value="${msg}"/>
   </div>
</div>


<!--footer-->
<div >
    <footer class="footer">
        <div class="container">
            <p>Copyright 2017 young891221. All Right Reserved. Designed by ssosso</p>
        </div>
    </footer>
</div>
<!--/footer-->

</body>
</html>

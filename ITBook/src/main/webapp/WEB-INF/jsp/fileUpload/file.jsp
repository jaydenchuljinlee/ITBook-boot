<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
<div class="container"style="text-align: center;">
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="files">
        <input type="submit" value="업로드">
    </form>
</div>
		



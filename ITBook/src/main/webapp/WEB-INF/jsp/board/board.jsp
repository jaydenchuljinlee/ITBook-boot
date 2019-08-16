<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="page-header">
        <h1>게시글 목록</h1>
    </div>

    <div class="pull-right" style="width: 100px; margin: 10px 0;">
        <a href="/board" class="btn btn-primary btn-block">등록</a>
    </div>

    <div>
        <table class="table table-hover">
            <thead>
	            <c:forEach var="board" items="${boardList}">
	            	<tr>
	            		<td>
	            			<c:out value="${board.index}"/>
	            		</td>
	            		<td>
	            			<c:out value="${board.board_type}"/>
	            		</td>
	            		<td>
	            			<a href="'/board?index=' + <c:out value='${board.board_type}'/>" >
	            				<c:out value="${board.title}"/>
	            			</a>
	            		</td>
	            		<td>
	            			<c:out value="${board.created_date}"/>
	            		</td>
	            		<td>
	            			<c:out value="${board.updated_date}"/>
	            		</td>
	            	</tr>
	            </c:forEach>
            </thead>
        </table>
    </div>

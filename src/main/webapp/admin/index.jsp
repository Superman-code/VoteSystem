<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员首页</title>
<style type="text/css">
ul.pagination {
    display: inline-block;
    padding: 0;
    margin: 0;
}

ul.pagination li {display: inline;}

ul.pagination li a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    border-radius: 5px;
}

ul.pagination li a.active {
    background-color: #4CAF50;
    color: white;
    border-radius: 5px;
}

ul.pagination li a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<body>
	<div class="row">
	  <%@ include file="leftContent.jsp" %>
	  <div class="column" style="text-align:center;height:700px;width:70%;border: 1px solid lightgray;">
	    <table style="margin: auto;margin-top: 100px;">
			<tr id="header">
				<th>投票序号</th>
				<th>投票名</th>
				<th>投票选项1</th>
				<th>投票选项2</th>
				<th>投票选项3</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${requestScope.voteResults}" var="voteResult">
				<tr>
					<td>${voteResult.vote.voteID}</td>
					<td>${voteResult.vote.voteName}</td>
					<c:forEach items="${voteResult.voteOptions}" end="2" var="voteOption">
						<td>${voteOption.voteOptionName}</td>
					</c:forEach>
					<td><a href="deleteVote?voteID=${voteResult.vote.voteID}">[删除]</a></td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination">
		  <c:choose>
		  	<c:when test="${requestScope.page.prePage}">
		  		<li><a href="showVote?currentPage=${requestScope.page.currentPage-1}">❮</a></li>
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="#" style="pointer-events: none;">❮</a></li>
		  	</c:otherwise>
		  </c:choose>
		  
		  <c:forEach begin="1" end="${requestScope.page.totalPage}" var="i">
		  	<li><a href="showVote?currentPage=${i}">${i}</a></li>
		  </c:forEach>
		  
		  <c:choose>
		  	<c:when test="${requestScope.page.nextPage}">
		  		<li><a href="showVote?currentPage=${requestScope.page.currentPage+1}">❯</a></li>
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="#" style="pointer-events: none;">❯</a></li>
		  	</c:otherwise>
		  </c:choose>
		</ul>
	  </div>
	</div>
</body>
</html>
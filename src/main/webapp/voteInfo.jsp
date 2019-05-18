<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投票页面</title>
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
	<%@ include file="header.jsp" %>
	<c:choose>
		<c:when test="${empty requestScope.voteResults}">
			<h2 style="color: lightblue;text-align: center;margin-top: 100px;">该频道没有任何投票内容！</h2>
		</c:when>
		<c:otherwise>
			<c:if test="${!empty requestScope.error}">
				<h2 style="color: red;text-align: center;margin-top: 70px;">${requestScope.error}</h2>
			</c:if>
			<c:forEach items="${requestScope.voteResults}" var="voteResult">
				<div style="margin-top: 50px;margin-bottom: 100px;">
					<form action="doVote" method="post">
						<input type="hidden" name="voteID" value="${voteResult.vote.voteID}">
						<p style="font-weight: bold;">${voteResult.vote.voteName}</p>
						<p>
							<c:forEach items="${voteResult.voteOptions}" var="voteOption">
								<input type="radio" name="voteOptionID" value="${voteOption.voteOptionID}">${voteOption.voteOptionName}<br>
							</c:forEach>
							<input type="radio" name="voteOptionID" value="0">其他
						</p>
						<p>
							<input type="text" name="voteOptionName">
							<a style="text-decoration: none;font-weight: bold;" href="voteResult?voteID=${voteResult.vote.voteID}">查看投票结果</a>
						</p>
						<p>
							<button type="submit" style="margin-right: 20px;">投票</button>
							<button type="reset">重置</button>
						</p>
					</form>
				</div>
			</c:forEach>
			<ul class="pagination">
			  <c:choose>
			  	<c:when test="${requestScope.page.prePage}">
			  		<li><a href="getVoteInfo?currentPage=${requestScope.page.currentPage-1}">❮</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="#" style="pointer-events: none;">❮</a></li>
			  	</c:otherwise>
			  </c:choose>
			  
			  <c:forEach begin="1" end="${requestScope.page.totalPage}" var="i">
			  	<li><a href="getVoteInfo?currentPage=${i}">${i}</a></li>
			  </c:forEach>
			  
			  <c:choose>
			  	<c:when test="${requestScope.page.nextPage}">
			  		<li><a href="getVoteInfo?currentPage=${requestScope.page.currentPage+1}">❯</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li><a href="#" style="pointer-events: none;">❯</a></li>
			  	</c:otherwise>
			  </c:choose>
			</ul>
		</c:otherwise>
	</c:choose>
	
</body>
</html>
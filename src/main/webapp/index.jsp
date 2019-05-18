<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty channels}">
			<h2 style="text-align: center;margin-top: 100px;color: lightblue;">
				<a style="text-decoration: none;" href="findAllChannel_index">点击获取投票频道信息</a>
			</h2>
		</c:when>
		<c:otherwise>
			<%@ include file="header.jsp" %>
			<h2 style="color: lightblue;text-align: center;margin-top: 100px;">点击上方的频道，选择您想要的投票</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>
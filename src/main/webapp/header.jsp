<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
}

li {
    float: left;
}

li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 14px 50px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #ddd;
}

li a.hover {
    color: white;
    background-color: #4CAF50;
}
</style>
</head>
<body>
	<ul>
	  <c:forEach items="${channels}" var="channel">
		<li><a href="getVoteInfo?channelID=${channel.channelID}">${channel.channelName}</a></li>
	  </c:forEach>
	</ul>
</body>
</html>
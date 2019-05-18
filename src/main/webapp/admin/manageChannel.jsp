<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>频道管理</title>
</head>
<body>
	<div class="row">
	  <%@ include file="leftContent.jsp" %>
	  <div class="column" style="text-align:center;height:700px;width:70%;border: 1px solid lightgray;">
	    <table style="margin: auto;margin-top: 100px;">
			<tr id="header">
				<th>频道ID</th>
				<th>频道名</th>
				<th>删除</th>
			</tr>
			<c:forEach items="${requestScope.channels}" var="channel">
				<tr>
					<td>${channel.channelID}</td>
					<td>${channel.channelName}</td>
					<td><a href="deleteChannel?channelID=${channel.channelID}">[删除]</a></td>
				</tr>
			</c:forEach>
		</table>
	  </div>
	</div>
</body>
</html>
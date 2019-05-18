<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加频道</title>
</head>
<body>
	<div class="row">
	  <%@ include file="leftContent.jsp" %>
	  <div class="column" style="text-align:center;height:700px;width:70%;border: 1px solid lightgray;">
	  	<form action="addChannel" method="post" style="margin: auto;margin-top: 100px;">
	  		<p>
	  			请输入频道名称：
	  			<input type="text" name="channelName">
	  		</p>
	  		<p>
	  			<button type="submit">提交</button>
	  			<button type="reset">重置</button>
	  		</p>
	  	</form>
	  </div>
	</div>
</body>
</html>
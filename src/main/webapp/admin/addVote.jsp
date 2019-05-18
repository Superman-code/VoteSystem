<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员页面</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<div class="row">
	  <%@ include file="leftContent.jsp" %>
	  <div class="column" style="text-align:center;height:700px;width:70%;border: 1px solid lightgray;">
	    <form style="margin-top: 100px;" action="addVote" method="post" id="addForm">
			<p>选择投票频道：
			<select name="channel">
				<c:forEach items="${requestScope.channels}" var="channel">
					<option value="${channel.channelID}">${channel.channelName}</option>
				</c:forEach>
			</select></p>
			<p>请输入投票名称：<input type="text" name="voteName"><br></p>
			<div id="voteOptionList">
				<p><span>选项1名称：</span><input type="text" name="voteOption"><br></p>
				<p><span>选项2名称：</span><input type="text" name="voteOption"><br></p>
				<p><span>选项3名称：</span><input type="text" name="voteOption"><br></p>
			</div>
			<p><button type="button" id="addVoteOption">新增投票选项</button>
			<button type="submit">发布</button>
			<button type="reset">重置</button></p>
		</form>
	  </div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			addVoteOption();
		});
		function addVoteOption(){
			var addBtn = $("button#addVoteOption");
			var voteOptionList = $("div#voteOptionList");
			var i = 4;
			addBtn.click(function(){
				var spanInfo = $("<span>选项"+(i++)+"名称：</span>");
				var input = $("<input type='text' name='voteOption'><br>");
				voteOptionList.append(spanInfo,input);
			});
		}
	</script>
</body>
</html>
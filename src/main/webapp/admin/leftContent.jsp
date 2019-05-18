<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
	* {
	  box-sizing: border-box;
	}
	
	body {
	  margin: 0;
	}
	
	/* 链接 - 修改颜色 */
	.topnav a:hover {
	  background-color: #ddd;
	  color: black;
	}
	
	/* 创建三个相等的列 */
	.column {
	  float: left;
	  width: 33.33%;
	}
	 
	/* 列后清除浮动 */
	.row:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	 
	/* 响应式布局 - 小于 600 px 时改为上下布局 */
	@media screen and (max-width: 600px) {
	  .column {
	    width: 100%;
	  }
	}
	table{
		border-collapse: collapse;
		width: 80%;
	}
	table, td, th {
	    border: 1px solid black;
	}
	th{
		background-color: #e7e7e7;
	}
	td{
		text-align: center;
	}
	a{
		text-decoration: none;
	}
	li{
		float: left;
		display:inline;
		margin:3px;
	}
</style>
</head>
<body>
	<div class="column" style="height:700px;width:30%;padding-right: 10px;">
	  	<div style="background-color: lightblue;">
	  		<img style="padding-left:3px;padding-top:3px;width: 20px;height: 20px;" alt="图片" src="${pageContext.request.contextPath}/images/calculator.png">
	  		<span style="margin-bottom:5px;background-color: lightgray;">管理选项</span>
	  	</div>
	  	<div>
	  		<ul>
	  			<li>
	  				<a href="findAllChannel_addVote"><img align="bottom" alt="图片" src="${pageContext.request.contextPath}/images/setting.jpg" style="width: 40px;height:40px;"></a>
	  				<p>新增投票</p>
	  			</li>
	  			<li>
	  				<a href="showVote"><img align="bottom" alt="图片" src="${pageContext.request.contextPath}/images/notepad.jpg" style="width: 40px;height:40px;"></a>
	  				<p>投票管理</p>
	  			</li>
	  			<li>
	  				<a href="${pageContext.request.contextPath}/admin/addChannel.jsp"><img align="bottom" alt="图片" src="${pageContext.request.contextPath}/images/addChannel.png" style="width: 40px;height:40px;"></a>
	  				<p>新增频道</p>
	  			</li>
	  			<li>
	  				<a href="findAllChannel_manageChannel"><img align="bottom" alt="图片" src="${pageContext.request.contextPath}/images/manageChannel.jpg" style="width: 40px;height:40px;"></a>
	  				<p>频道管理</p>
	  			</li>
	  		</ul>
	  	</div>
	  </div>
</body>
</html>
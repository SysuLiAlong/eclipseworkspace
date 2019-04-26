<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<h1>main.jsp</h1>
请输入：<input id="input1" type="text" placeholder="1无效，2跳转">
<button onclick="click()">确定</button>
<script type="text/javascript">
	function click(){
		var value = document.getElementById("input1");
		if(value=="2"){
			/* <jsp:forward page="date.jsp"/> */
		}
	}
</script>
</body>
</html>
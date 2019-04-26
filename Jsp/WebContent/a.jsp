<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>a</title>
</head>
<body>
<p>b</p>
<%! int a = 4; %>
<%request.setAttribute("a", a); %>
<jsp:forward page="b.jsp"></jsp:forward>
</body>
</html>
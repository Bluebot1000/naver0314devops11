<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
    </style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8"); //한글 엔코딩 추가
	//post방식의 폼타임(한글 꼭 깨져)
	String home=request.getParameter("home");
	String email=request.getParameter("email");
	String []hobby=request.getParameterValues("hobby");//체크박스 여러개 가져올때 배열로 가져오기
%>

<h5>나의 주거지 : <%=home %></h5>
<h5>나의 이메일 : <%=email %></h5>
<h5>나의 취미 : <% if(hobby==null){%>
	<b>취미가 없어요</b>
<%} else{
	for(String h:hobby){%>
	
	<b>[<%=h %>]</b>
	
	<%}
} %></h5>
</body>
</html>

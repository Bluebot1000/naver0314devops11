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
        
        body{
            background-color:black;}
        
        div.a{
        	border:3px solid beige;
        	width:400px;
        	text-align:left;
        	line-height:50px;
        	color:white;
        }
        div img{
        	border:5px dotted white;
        }
    </style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String mn=request.getParameter("menuname");
	String []fp=request.getParameter("foodphoto").split(",");
	String grade=request.getParameter("grade");
	String mem=request.getParameter("member");
%>
<body>
<div class="a" style="margin:50px;font-size:30px;text-shadow:5px 5px 5px gray;">
	<div style="margin:30px;">
	메뉴이름 : <%=mn %><br>

	만족도 : <%=grade %><br>
	<script>
	console.log(mem)
	</script>
	회원등급 : <%=mem==null? "일반회원" : "우수회원" %><br>
	
	음식사진<br>
	<img src="<%=fp[0] %>" width=200><br>
	
	<br><br>
	<a href="javascript:history.back()">다시 선택 # 1</a>
	<br><br>
	<a href="Ex10_formtag.jsp">다시 선택 # 2</a>
	

	</div>
</div>
</body>
</html>

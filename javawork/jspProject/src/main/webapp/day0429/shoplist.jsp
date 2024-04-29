<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
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
<%
	//dao선언
	ShopDao dao=new ShopDao();
	//db에 등록된 상품들 가져오기
	List<ShopDto> list=dao.getShopDatas();
%>
<body>
	<div style="margin:10px; width:400px;">
		<h5 class="alert alert-danger"><b>총 <%=list.size() %>개의 상품이 등록되어 있습니다</b></h5>
		<button type="button" class="btn btn-outline-primary" 
		style="margin-top:10px; margin-left:300px;" 
		onclick="location.href='./shopform.jsp'">상품 추가</button>
	</div>
</body>
</html>

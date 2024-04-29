<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>
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
	//1. 엔코딩
	request.setCharacterEncoding("utf-8");
	
	//2. 5개 상품 데이터 읽기
	String sname=request.getParameter("sname");
	int sprice=Integer.parseInt(request.getParameter("sprice"));
	int scount=Integer.parseInt(request.getParameter("scount"));
	String scolor=request.getParameter("scolor");
	String sphoto=request.getParameter("sphoto");
	
	//3. dto에 넣기(생성자로 넣기)
	ShopDto dto=new ShopDto(sname, sprice, scount, scolor, sphoto);

	//4. dao 선언
	ShopDao dao=new ShopDao();
	
	//5. insert 메서드 호출
	dao.insertShop(dto);
	
	//6. shoplist.jsp로 이동
	response.sendRedirect("shoplist.jsp"); //url 주소 바뀜

%>
<body>
</body>
</html>

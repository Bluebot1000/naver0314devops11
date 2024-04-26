<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
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
		String []flower={"장미꽃","안개꽃","다알리아","국화꽃","프리지아"};
		String []colors={"orange","red","pink","brown","gold"};
		List <String> list=Arrays.asList("2000원","3000원","5000원","2300원","9000원");
	%>
<body>
	<table class="table table-bordered" style="width:400px; caption-side:top;'">
	
		<caption><b>배열 및 리스트 출력</b></caption>
		
		<tr class="table-success">
			<td width="60">번호</td>
			<td width="120">꽃이름</td>
			<td width="120">단가</td>
			<td>색상</td>
		</tr>
		<%
		for(int i=0 ; i<flower.length;i++){%>
			<tr>
				<td align="center"><%=i+1%></td>
				<td align="center"><%=flower[i]%></td>
				<td align="center"><%=list.get(i)%></td>
				<td align="center" style="background-color:<%=colors[i]%>;"><%=colors[i]%></td>
			</tr>
		<%}
		%>
		
	</table>
</body>
</html>

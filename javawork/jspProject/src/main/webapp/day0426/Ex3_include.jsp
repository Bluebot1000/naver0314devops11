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
    <script>
    $(function(){
    	$("#a2").hide();
    	$("#a4").hide();
    	$("h5.a1").mouseover(function(){
    		$("#a2").show();
    	});
    	$("h5.a1").mouseout(function(){
    		$("#a2").hide();
    	});
    	$("h5.a3").hover(function(){$("#a4").show();},function(){$("#a4").hide();})
    })

    </script>
</head>
<body>
	<h3 class="alert alert-danger">JSP의 action tag include</h3>
	<h5 class="a1">2024년 4월 26일 1번 예제</h5>
	<div id=a2>
		<jsp:include page="./Ex1_test.jsp"/>
	</div>
		<h5 class="a3">2024년 4월 26일 2번 예제</h5>
	<div id=a4>
		<jsp:include page="./Ex2_gugudan.jsp"/>
	</div>
</body>
</html>

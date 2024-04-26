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
	<form action="./Ex10_action.jsp" method="post"><!-- post면 인코딩해준다 -->
	<table class="table table-bordered" style="width:400px;">
		<tr>
			<th class="table-info" width="100">메뉴명</th>
			<td>
				<input type="text" name="menuname" class="form-control" 
				required autofocus>
			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">음식사진</th>
			<td class="input-group">
				<select class="form-select-sm" name="foodphoto" id="foodcourt">
					<option value="../food/1.jpg,9000">샌드위치 1
					<option value="../food/8.jpg,11000">샌드위치 2
					<option value="../food/11.jpg,13000">망빙
					<option value="../food/10.jpg,8000">햄마요덮밥
				</select>
				<img src="../food/1.jpg" id="photo" width="60" height="60" style="margin-left : 10px">
				<!-- 제이쿼리 이벤트는 요기에 -->
				<script>

				$("#foodcourt").change(function(){
					let fsrc=$(this).val();
					let f=fsrc.split(",");
					$("#photo").attr("src",f[0])
				})
				
				</script>
				
			
			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">만족도</th>
			<td>
				<label>
					<input type="radio" name="grade" value="매우만족" checked>매우만족
				</label>
				<label>
					<input type="radio" name="grade" value="만족">만족
				</label>
				<label>
					<input type="radio" name="grade" value="보통">보통
				</label>
				<label>
					<input type="radio" name="grade" value="불만">불만
				</label>

			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">우수회원</th>
			<td>
				<input type="checkbox" name="member" value="우수회원">우수회원
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-outline-success">서버전송</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>

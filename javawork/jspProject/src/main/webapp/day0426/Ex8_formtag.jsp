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
	<form action="./Ex8_action.jsp" method="post">
	<table class="table table-bordered" style="width:400px;">
		<tr>
			<th class="table-info" width="100">이름</th>
			<td>
				<input type="text" name="name" class="form-control" required autofocus>
			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">비밀번호</th>
			<td>
				<input type="password" name="pass" class="form-control" required autofocus>
			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">성별</th>
			<td>
				<label><input type="radio" name="gender" value="남자" checked>남자</label>
				<label><input type="radio" name="gender" value="여자">여자</label>
			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">운전면허</th>
			<td>
				<label><input type="checkbox" name="lic" value="1종">운전면허 1종</label>
				<label><input type="checkbox" name="lic" value="2종">운전면허 2종</label>
			</td>
		</tr>
		<tr>
			<th class="table-info" width="100">혈액형</th>
			<td>
				<select name="blood" multiple="multiple" size="2" class="form-select"> <!-- 멀티플은 한번에 몇개 보이나 정해 -->
					<option value="A">A</option>
					<option value="B" selected>B</option>
					<option value="AB">AB</option>
					<option value="O">O</option>
				</select>
			</td>
		</tr>
				<tr>
			<th class="table-info" width="100">혈액형</th>
			<td colspan="2" align="center">
				<input type="image" src="../image/mycar10.png" style="width:150px">
			</td>
		</tr>
	</table>
</form>
</body>
</html>

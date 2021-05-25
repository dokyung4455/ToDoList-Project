<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<C:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/todo.css?ver2021-05-25-00"
	rel="stylesheet" />
</head>
<style>
	form {
		text-align: center;
	}
	div {
		display: inline-block;
		width:200px;
		padding:10px;
		margin:30px auto;
	}
	div.btn{
		
	}
	input {
		width:200px;
	}
	button {
		width:100px;
	}
	h2{
		color:white;
		font-size: 15px;
		margin:2px;
	
	}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() { //왜 있어야 실행이 되는가
		
		document.querySelector("button.btn_insert").addEventListener(
				"click",
				function(ev) {
					let li_todo = document
							.querySelector("input[name='li_todo']");
					let li_date = document
							.querySelector("input[name='li_date']");
					let li_time = document
							.querySelector("input[name='li_time']");
					let li_place = document
							.querySelector("input[name='li_place']");
					if (li_todo.value == "") {
						alert("할일을 입력하세요.")
						li_todo.focus();
						return false;
					}
					if (li_date.value == "") {
						alert("날짜를 지정하세요.")
						li_date.focus();
						return false;
					}
					if (li_time.value == "") {
						alert("시간을 입력하세요.")
						li_time.focus();
						return false;
					}

					document.querySelector("form.v1").submit();
				})

	})
</script>
<body>
	<h1>TO DO LIST</h1>
	<form class="v1" method="post">
	
		<div>
			<h2>날짜</h2>
			<input name="li_date" type="date" value="${TD.li_date}" />
		</div>
		<div>
			<h2>시간</h2>
			<input name="li_time" type="time" value="${TD.li_time}" />
		</div>
		<div>
			<h2>할일</h2>
			<input name="li_todo" value="${TD.li_todo}" />
		</div>
		<div>
			<h2>장소</h2>	
			<input name="li_place" value="${TD.li_place}" />
		</div>
		<div class="btn">
			<h2>  </h2>
		<button class="btn_insert">추가</button>
		</div>	
	</form>

</body>
</html>
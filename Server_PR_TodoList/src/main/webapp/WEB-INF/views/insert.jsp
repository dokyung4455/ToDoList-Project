<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
					alert("저장버튼" + li_todo.value + "\n" + li_date.value + "\n"
							+ li_time.value + "\n" + li_place.value + "\n")

					document.querySelector("form.v1").submit();
				})

	})
</script>
<body>
	<h1>TO DO LIST</h1>
	<form class="v1" method="post">
		<div>
			<input name="li_date" type="date" value="${TD.li_date}" /><input
				name="li_time" type="time" value="${TD.li_time}" />
		</div>
		<div>
			<input name="li_todo" value="${TD.li_todo}" />
		</div>
		<div>
			<input name="li_place" value="${TD.li_place}" />
			<button class="btn_insert">추가</button>
		</div>
	</form>

</body>
</html>
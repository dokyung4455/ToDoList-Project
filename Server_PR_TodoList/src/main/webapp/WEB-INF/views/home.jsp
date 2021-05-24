<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<C:set value ="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOLIST</title>
</head>
<script>
	document.addEventListener("DOMContentLoaded", function() { //왜 있어야 실행이 되는가
		document.querySelector("button.btn_todo").addEventListener("click",function(ev) {
					document.location.href="${rootPath}/todo/insert";
				})
	})
</script>
<body>
	<h1>TO DO LIST</h1>
		
	<button class="btn_todo">계획 입력하기</button>

	<table>
		<tr>
			<th>No.</th>
			<th>할일</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>장소</th>
		</tr>


		<C:forEach items="${TDLIST}" var="TD" varStatus="index">
			<tr data-seq="${TD.li_seq}">
				<td>${index.count}</td>
				<td>${TD.li_todo}</td>
				<td>${TD.li_date}</td>
				<td>${TD.li_time}</td>
				<td>${TD.li_place}</td>
			</tr>
		</C:forEach>
	</table>



</body>
</html>
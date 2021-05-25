<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<C:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOLIST</title>
<link href="${rootPath}/static/css/todo.css?ver2021-05-25-00"
	rel="stylesheet" />
<style>

table {
	color: white;
	width:50%;
	margin: 100px auto;
	padding:5px;
	text-align: center;
}
button {
	padding:30px;
	font-size: 25px;
	color: purple;
	
}
td#class{
	color:white;
}
</style>
<script>


	document.addEventListener("DOMContentLoaded",function(ev) {//왜 있어야 실행이 되는가 
		document.querySelector("button.btn_todo").addEventListener("click",function(ev) {
				document.location.href = "${rootPath}/todo/insert";
		})
	
		document.querySelector("table.td_list").addEventListener("click",function(ev) {
				let tag_name = ev.target.tagName;
				if (tag_name == "TD") {
						let li_seq = ev.target.closest("TR").dataset.seq
						document.location.href = "${rootPath}/todo/update?li_seq="+li_seq
				}
		})
	})
</script>
</head>

<body>
	<h1>TO DO LIST</h1>
	<div class="btn_all" align="center">
		<button class="btn_todo">새로 입력하기</button>
		<br>
	</div>
	<table class="td_list" align="center">
		<tr>
			<th>No.</th>
			<th>할일</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>장소</th>
			<th>삭제</th>
		</tr>


		<C:forEach items="${TDLIST}" var="TD" varStatus="index">
			<tr data-seq="${TD.li_seq}">
				<td>${index.count}</td>
				<td>${TD.li_todo}</td>
				<td>${TD.li_date}</td>
				<td>${TD.li_time}</td>
				<td>${TD.li_place}</td>
				<td class="href" style="color: white"><a type="button" href="todo/delete?li_seq=${TD.li_seq}">삭제</a></td>
			</tr>
			
			
			
		</C:forEach>
	</table>


</body>
</html>
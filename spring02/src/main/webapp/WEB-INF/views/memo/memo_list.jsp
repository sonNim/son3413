<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- views/memo/memo_list.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- include libraries(bootstrap) -->
<link
href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
rel="stylesheet">
<script src=
"http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js -->
<link href="${path}/summernote/summernote.css" 
rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script>


<script>
$(function() {
	//id가 memo인 태그를 summernote로 변경
	$("#memo").summernote({
		height : 150,
		width : 600
	});
});

function memo_view(idx){
	location.href="${path}/memo/view/"+idx;
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>메모장</h2>
<form method="post" action="${path}/memo/insert.do">
	이름 : <input name="writer" size="10"><br>
	메모 : <!-- <input id="memo" name="memo" size="40"> -->
	<textarea rows="3" cols="50" name="memo" id="memo"></textarea>
	<input type="submit" value="확인">
</form>

<table border="1" width="500px">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.idx}</td>
		<td>${row.writer}</td>
		<td><a href="#" onclick="memo_view('${row.idx}')">
			${row.memo}</a></td>
		<td><fmt:formatDate value="${row.post_date}"
			pattern="yyyy-MM-dd HH:mm:ss" /> </td>
	</tr>
</c:forEach>		
</table>
</body>
</html>




















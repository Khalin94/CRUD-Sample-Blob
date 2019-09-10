<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>tno</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="item">
		<tr>
			<td><a href="/getTestpage?tno=${item.tno }" >${item.tno }</a></td>
		</tr>
	</c:forEach>
	</tbody>
	
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple BBS</title>
<script
  src="/resources/js/jquery-3.4.1.min.js"></script>
</head>
<style>
table{
	width : 100%;
	border : 1px solid black;
}

th{
	border : 1px solid black;
}

h1{
	text-align : center;
}
</style>

<body>
<div class="title">
	<h1>LIST</h1>
</div>

	<div class="menu">
	<span>
	<input type="button" class="registerBtn" value="등록" onclick="location.href='/register'">
	</span>
	<span>
	<input type="button" class="removeList" value="삭제">
	</span>
	</div>
	
	<div>
	<br>
	</div>
	
	<table>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="allCheck" id="allCheck"></th>
				<th>#</th>
				<th>id</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="bbs">
			<tr>
				<th><input type="checkbox" name="check" class="chbox" data-bno="${bbs.bno }"></th>	
				<th><c:out value="${bbs.bno}" /></th>
				<th><a class="pageMove" href='/bbsGet?bno=<c:out value="${bbs.bno }"/>'><c:out value="${bbs.id }" /></a></th>
				<th><c:out value="${bbs.name }" /></th>
				<th><c:out value="${bbs.adress }" /></th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	

<script type="text/javascript">
$(document).ready(function(e){
	$("#allCheck").on("click", function(){
		var allCheck = $("#allCheck").prop("checked");
		if(allCheck){
			$(".chbox").prop("checked", true);
		} else{
			$(".chbox").prop("checked", false);
		}
	});
	
	$(".removeList").on("click", function(){
		var checkArr = new Array();
		
		$("input[class='chbox']:checked").each(function(){
			checkArr.push($(this).attr("data-bno"));
		});
		
		$.ajax({
			url : "/removeList",
			type : "post",
			data : {chbox : checkArr},
			success : function(e){
				location.href = "/bbsList";
			}
		});
	});
});
</script>
</body>
</html>
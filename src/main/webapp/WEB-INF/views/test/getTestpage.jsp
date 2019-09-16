<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<!-- 
image : <input name="image" type="image" src="/viewImage?tno=${tno }">
<br>
preview : <input name="pdf" type="image" src="/preview?tno=${tno }"> <br>
 <img src="/resources/img/adobe-pdf-icon.png">
 -->
<!-- download : <input id="downloadBtn" type="button" value="${vo.filename }"> <br> -->
<c:if test="${vo.ext eq 'png' or vo.ext eq 'jpg' or vo.ext eq 'jpeg'}">
view Image : <img alt="${vo.filename }" src="/viewImage?tno=${tno }"><br>
</c:if>
<br>
<c:if test="${vo.ext eq 'pdf' }">
preview use embed : <embed id="pdfFile" src="/resources/img/adobe-pdf-icon.png" /><br>
</c:if>
download : <a href="/download?tno=${tno }">${vo.filename }</a>
<ul>
	<li>
	</li>
</ul>

<input type="button" value="목록" id="goList">

</body>

<script type="text/javascript">
$(document).ready(function(){
	$("#goList").on("click", function(e){
		e.preventDefault();
		
		location.href = "/testList";
	});
	
	$("li").hide();
/*	
	$("input[name='image']").on("click", function(e){
		e.preventDefault();
		var type = $("input[name=image]");
//		window.open(type);
		
		$.ajax({
			url : "/download?tno="+${tno},
			type : "get",
			success : function(data){
				alert("success : " + data);
			},
			error : function(data){
				alert("Error : " + data);
			}
		});
	});
	*/
	$("#downloadBtn").on("click", function(e){
		e.preventDefault();
		
		$.ajax({
			url : "/download?tno=${tno}",
			type : "get",
			success : function(data){
				alert("success");
			},
			error : function(data){
				alert("error : " + data);
			}
		});
	});
	
	$("#pdfFile").on("click", function(e){
		e.preventDefault();
		window.open("/preview?tno=${tno}");
	
	});
});
</script>
</html>
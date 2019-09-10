<%@page import="org.simple.domain.EduVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info</title>

<script
  src="/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="title">
<h1>info</h1>
</div>
<table>
	<tr>
		<td>#</td>
		<td><input name="bno" value="${bbs.bno }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>id</td>
		<td><input name="id" value="${bbs.id }" readonly="readonly"/></td>
	</tr>
	
	<tr>
		<td>name</td>
		<td><input name="name" value="${bbs.name }" readonly="readonly"/></td>
	</tr>
	
	<tr>
		<td>Address</td>
		<td><input name="adress" value="${bbs.adress }" readonly="readonly"/></td>
	</tr>
	<c:set var="gender" value="${bbs.gender }" />
	<tr>
		<td>성별</td>
		
		<c:if test="${gender eq 1 }">
	
		<td><input name="gender" value="남" readonly="readonly"/></td>
		
		</c:if>
		<c:if test="${gender eq 2 }">
		
		<td><input name="gender" value="여" readonly="readonly"/></td>
		
		</c:if>
<!-- <td><input name="gender" value="${bbs.gender }" readonly="readonly"/></td> -->		
 		
	<tr>
		<c:if test="${fileVo ne null }">
		<td>사진</td>
		
		<td>
			<img src="/ViewImage?bno=${bbs.bno }" id="image">
		</td>
		
		<td>
			<form name="downForm" action="/download" method="Post"> 
<!-- <input type="button" name="fileVo" value="${fileVo.filename }" class="uploadResult" onclick="location.href='/download?bno=${fileVo.bno}'"> -->	  	
 				<input type="hidden" name="bno" value="${fileVo.bno}">
				<button onclick="javascript:document.downForm.submit()">${fileVo.filename}</button>
			</form>
		</td>
		</c:if>
	</tr>

 	<!-- <tr>
 		<td>
 			<input type="image" value=""
 		</td>
 	</tr> -->
<table>
<thead class="edu">
		<tr class = "eduList"><td width="100px"><h3>학력사항</h3></td></tr>
		<tr class="edu">
			<th></th>
			<th>학교명</th>
			<th>전공</th>
			<th>입학년도</th>
			<th>졸업년도</th>
			<th>구분</th>
		</tr>
	</thead>
	
	
	<c:forEach items="${eduVo}" var="item" varStatus="i" >
	<tbody class="edu">
		<tr class="edu">
			<th></th>
			<td><input name="sName" value="${item.sName }" readonly="readonly"></td>
			<td><input name="major" value="${item.major }" readonly="readonly"></td>
			<td>
			
			<input name="startYear" value="${item.startDate }" readonly="readonly">
	
			<!-- 
			<select name="startMonth" id="startMonth">

			</select>
			 <select name="startDay" id="startDay">	

			</select>
			-->
			</td>
			<td>
					<input name="endYear" value="${item.endDate }" readonly="readonly">
			<!-- 
			<select name="endYear" id="endYear">
			</select>
			<select name="endMonth" id="endMonth">
	
			</select>
			<select name="endDay" id="endDay">

			</select>
		 -->
			</td>
			
		
			<td>
			
<!-- 			<input type="radio" name="division" value="graduate" class="division" checked="checked">졸업 -->
			
			<input name="division" value="${item.division }" readonly="readonly">
			
			</td>
	<!--   <td><input type="radio" name="division" value="drop" class="division">중퇴</td>  -->		
			
		</tr>
	</tbody>
	</c:forEach>
</table>

</table>

	<div>
		<br>
	</div>
	
<form name="myForm" action="/remove" method="POST">
<input type="hidden" name="bno" value="${bbs.bno }" />
</form>


<button onclick="javascript:document.myForm.submit();">삭제</button>

<!-- <button onclick="/modify?bno=${bbs.bno}">수정</button> -->
<input type="button" onclick="location.href='/modify?bno=${bbs.bno}'" value="수정">
<input type="button" name="listBtn" value="목록">

</body>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name='listBtn']").on("click", function(){
		location.href = "/bbsList";
	});
	
     $(function() {
         $("#imgInp").on('change', function(){
             readURL(this);
         });
     });

     function readURL(input) {
         if (input.files && input.files[0]) {
         var reader = new FileReader();

         reader.onload = function (e) {
                 $('#image').attr('src', e.target.result);
             }

           reader.readAsDataURL(input.files[0]);
         }
     }

});
</script>
</html>
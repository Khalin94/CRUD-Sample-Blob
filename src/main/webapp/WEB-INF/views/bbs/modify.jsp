<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
<script
  src="/resources/js/jquery-3.4.1.min.js"></script>
  <style>
  .noBorder{
  	border : 0px;
  }
  input{
  
  }
  </style>
</head>
<body>
	<div class="title">
		<h1>modify</h1>
	</div>


	<form action="/modify" method="post">
		<table>
			<tr>
				<td>#</td>
				<td><input class='noBorder'   name="bno" value="${bbs.bno }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>id</td>
				<td><input  class='noBorder' name="id" value="${bbs.id }" /></td>
			</tr>

			<tr>
				<td>name</td>
				<td><input class='noBorder'  name="name" value="${bbs.name }" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input class='noBorder'  name="adress" value="${bbs.adress }" /></td>
			</tr>

			<tr>
				<td>file</td>
				<td>
					<form name="downForm" action="/download" method="Post">
						<!-- <input type="button" name="fileVo" value="${fileVo.filename }" class="uploadResult" onclick="location.href='/download?bno=${fileVo.bno}'">  -->
						<input type="hidden" name="bno" value="${fileVo.bno}">
						<button onclick="javascript:document.downForm.submit()">${fileVo.filename}</button>
					</form>
				</td>
			</tr>


			<table>
				<thead class="edu">
					<tr class="eduList">
						<td width="100px"><h3>학력사항</h3></td>
					</tr>
					<tr class="edu">
						<th></th>
						<th>학교명</th>
						<th>전공</th>
						<th>입학년도</th>
						<th>졸업년도</th>
						<th>구분</th>
					</tr>
				</thead>


				<c:forEach items="${eduVo}" var="item" varStatus="i">
				
	 			
					<tbody class="eduInfo[${i.index }]" id="eduCount">
					<input type="hidden" name="eno" class="eno[${i.index }]" value="${item.eno }">
						<tr class="edu">
							<th></th>
							<td><input name="sName" value="${item.sName }"
								readonly="readonly"></td>
							<td><input name="major" value="${item.major }"
								readonly="readonly"></td>
							<td><input name="startYear" value="${item.startDate }"
								readonly="readonly"> <!-- 
			<select name="startMonth" id="startMonth">

			</select>
			 <select name="startDay" id="startDay">	

			</select>
			--></td>
							<td><input name="endYear" value="${item.endDate }"
								readonly="readonly"> <!-- 
			<select name="endYear" id="endYear">
			</select>
			<select name="endMonth" id="endMonth">
	
			</select>
			<select name="endDay" id="endDay">

			</select>
		 --></td>


							<td>
								<!-- 			<input type="radio" name="division" value="graduate" class="division" checked="checked">졸업 -->

								<input name="division" value="${item.division }"
								readonly="readonly">

							</td>
							<!--   <td><input type="radio" name="division" value="drop" class="division">중퇴</td>  -->
							<td><input type="button" name="delBtn" value="정보 삭제">
							</td>

						</tr>
						
					</tbody>
				</c:forEach>
				
				
				<tbody class="edu">
		<tr class="edu">
			<th></th>
			<td><input type="text" name="uniName" class="eduData"></td>
			<td><input type="text" name="uniMajor" class="eduData"></td>
			<td>
			
			<select name="uniStartYear" id="startYear">
			<%
  			  Calendar cal = Calendar.getInstance();
 
 			  int sYear = cal.get(Calendar.YEAR);

				out.println("<option selected=\"selected\">선택</option>");
  			  for(int i = sYear - 5; i < sYear + 5; i++) { 
        /*
     				   if(i == sYear) {
      				      out.println("<option value='"+i+"' selected=\"selected\">" + i + "</option>");
     				   } else {
    				        out.println("<option value='"+i+"'>" + i + "</option>");
    				    }
        */
        				out.println("<option value='"+i+"'>"+i+"</option>" );
   				 }
  			  
			%>


			</select>
			<select name="uniStartMonth" id="startMonth">
			<%
		    int sMonth = cal.get(Calendar.MONTH) + 1;
	
			out.println("<option selected=\"selected\">선택</option>");
			
			for(int i=1; i <= 12; i++){
  		/*		if(i == sMonth){
  					out.println("<option selected=\"selected\" value='"+i+"'>"+i+"</option>");
  				}else{
  					out.println("<option value='"+i+"'>"+i+"</option>");
  				}
  		*/
  				out.println("<option value='"+i+"'>"+i+"</option>");
  			  }
			 %>
			</select>
			 <select name="uniStartDay" id="startDay">	
			
			<%
				int sDate = cal.get(Calendar.DATE);
			
				out.println("<option selected=\"selected\">선택</option>");
				for(int i=1; i<=31; i++){
			/*		if(i == sDate){
					out.println("<option selected=\"selected\" value='"+i+"'>"+i+ "</option>");
					}else{
						out.println("<option value='"+i+"'>"+i+"</option>");
					}
			*/
					out.println("<option value='"+i+"'>"+i+"</option>");
				}
			%>
			</select>
			
			</td>
			<td>
			<select name="uniEndYear" id="endYear">
			<%
  			
 
 			  int eYear = cal.get(Calendar.YEAR);

    
				out.println("<option selected=\"selected\">선택</option>");
			  for(int i = eYear - 5; i < eYear + 5; i++) { 
      /*
   				   if(i == sYear) {
    				      out.println("<option value='"+i+"' selected=\"selected\">" + i + "</option>");
   				   } else {
  				        out.println("<option value='"+i+"'>" + i + "</option>");
  				    }
      */
      				out.println("<option value='"+i+"'>"+i+"</option>" );
 				 }
  			  
    		%>
			</select>
			<select name="uniEndMonth" id="endMonth">
			<%
		    int eMonth = cal.get(Calendar.MONTH) + 1;
	
out.println("<option selected=\"selected\">선택</option>");
			
			for(int i=1; i <= 12; i++){
  		/*		if(i == sMonth){
  					out.println("<option selected=\"selected\" value='"+i+"'>"+i+"</option>");
  				}else{
  					out.println("<option value='"+i+"'>"+i+"</option>");
  				}
  		*/
  				out.println("<option value='"+i+"'>"+i+"</option>");
  			  }
			 %>
			</select>
			<select name="uniEndDay" id="endDay">
			<%
				int eDate = cal.get(Calendar.DATE);
			
			out.println("<option selected=\"selected\">선택</option>");
			for(int i=1; i<=31; i++){
		/*		if(i == sDate){
				out.println("<option selected=\"selected\" value='"+i+"'>"+i+ "</option>");
				}else{
					out.println("<option value='"+i+"'>"+i+"</option>");
				}
		*/
				out.println("<option value='"+i+"'>"+i+"</option>");
			}
			%>
			</select>
			</td>
			
		
			<td><input type="radio" name="uniDivision" value="graduate" class="division" checked="checked">졸업</td>
			<td><input type="radio" name="uniDivision" value="drop" class="division">중퇴</td>
			
		</tr>
		
	</tbody>
			</table>
			
			
			
			<input type="button" name="eduReg" value="학력 등록">
			추가된 학력
			
			<ul class="eduLi">
			
			</ul>
			
			<br />
			<br />
		</table>
		<input type="submit" value="저장">
	</form>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("input[name='delBtn']").on("click", function() {
			
//			var tbody = $("#eduCount");
			
			var tbodyArr = new Array($("#eduCount"));
			
			var enoArr = new Array($("input[name='eno']"));
			var eno = enoArr[0].val();
			
			console.log("eno : "  + eno);
			console.log(enoArr[0]);
			
			console.log(tbodyArr[0].html());
			
			tbodyArr[0].remove();
			
			var eduInfo = $(".eduInfo").val();
			console.log(eduInfo);
			
			var formData = new FormData();
			
			formData.append("eno", eno);
			
			$.ajax({
				url : "/removeByEno",
				type : 'post',
				data : formData,
				processData : false,
				contentType : false,
				success : function(data){
					alert("삭제되었습니다.");
				},
				error : function(data){
					alert("삭제 에러");
				}
			});
		});
		
		$("input[name='eduReg']").on("click", function(e){
			e.preventDefault();
			var sNameVal = $("input[name='uniName']").val();
			var majorVal = $("input[name='uniMajor']").val();
			var divisionVal = $("input[name='uniDivision']:checked").val();
			var startYearVal = $("select[name='uniStartYear']").val();
			var startMonthVal = $("select[name='uniStartMonth']").val();
			var startDayVal = $("select[name='uniStartDay']").val();
			var endYearVal = $("select[name='uniEndYear']").val();
			var endMonthVal = $("select[name='uniEndMonth']").val();
			var endDayVal = $("select[name='uniEndDay']").val();

			
			var str = ""
			
			str += "<li id='newData'>";
			str += "<label width='20px'>학교명  :    </label><input class='noBorder' name = 'sName' value='"+ sNameVal + "' readonly='readonly'>";
			str += "<br><label width='20px'>전공   :    </label><input class='noBorder'  name = 'major' value='"+ majorVal+ "' readonly='readonly'>";
			str += "<br><label>구분   :    </label><input class='noBorder'  name = 'division' value='"+ divisionVal + "' readonly='readonly'>";
			str += "<br><label>입학년도 :    </label><input class='noBorder'  name = 'startYear' value='"+ startYearVal+ "' readonly='readonly'>";
			str += "<br><label>입학월  :    </label><input class='noBorder'  name = 'startMonth' value='"+ startMonthVal + "' readonly='readonly'>";
			str += "<br><label>입학일  :    </label><input class='noBorder'  name = 'startDay' value='"+ startDayVal+ "' readonly='readonly'>";
			str += "<br><label>졸업년도 :    </label><input class='noBorder'  name = 'endYear' value='"+ endYearVal + "' readonly='readonly'>";
			str += "<br><label>졸업월  :    </label><input class='noBorder'  name = 'endMonth' value='"+ endMonthVal+ "' readonly='readonly'>";
			str += "<br><label>졸업일  :    </label><input class='noBorder'  name = 'endDay' value='"+ endDayVal + "' readonly='readonly'>";
			str += "</li>";
			
			$(".eduLi").append(str);
			
			
		});
	
	});
</script>
</html>
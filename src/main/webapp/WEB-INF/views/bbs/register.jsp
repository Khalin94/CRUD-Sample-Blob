<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>

<script
  src="/resources/js/jquery-3.4.1.min.js"></script>
  
  <style>
  	.edu{
  		border : 1px solid black;
  	}
  	.eduList{
  		padding-top : 20px;
  		text-align: center;
  	}
  	.noBorder{
  		border : 0px;
  	}
  	.basicInfo{
  		width : 300px;
  	}
  </style>
</head>

<body>
<div class="title">
<h1>Register</h1>
</div>
<!-- 
<form action="/pictureUpload" method="post" enctype="multipart/form-data" id="pictureForm">
	<input type="file" name="picture">
	<img src="#" id="image">
</form>
 --> 

<form role="form" action="register" method="post" enctype="multipart/form-data" class="tableForm" id="uploadForm">
<table>
<!-- 	<input type="hidden" name="bno" value="${bno }" '> -->
	

	<thead>
		<tr>
			<th>id</th>
			<td><input class="basicInfo" name="id" placeholder="id를 입력하세요."></td>
		</tr>
		<tr>
			<th>name</th>
			<td><input class="basicInfo"  name="name" placeholder="이름을 입력하세요."></td>
		</tr>
		<tr>
			<th>Address</th>
			<td><input class="basicInfo"  name="adress" placeholder="주소를 입력하세요."></td>
		</tr>
		<tr>
			<th>주민등록번호</th>
			<td><input class="basicInfo"  type="password" name="idNum" placeholder="주민등록번호 13자리를 입력하세요."></td>
		</tr>
 		<tr>
 			<th>사진</th>
			<td><input type="file" name="picture"></td>
			<td><img src="#" id="image" width="195" height="254"></td>
		</tr>
	</thead>
 	
	

</table>

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
		<ul class="eduLi">
			
		</ul>

<div>
	<br>
</div>

<!-- 	<input type="file" name="uploadFile" class="uploadFile"> -->
	<div class="uploadResult">
		<ul>
			<li>
		
			</li>
		</ul>
	</div>
	<input type="submit" name = "bbsUpload" value="저장">
</form>



<script type="text/javascript">
$("#image").hide();

$(document).ready(function(){
  	
	function readUrl(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				$("#image").attr("src", e.target.result);
			}
			
			reader.readAsDataURL(input.files[0]);
			$("#image").show();
			
		}
	}
	
	$("input[name='picture']").change(function(){
		readUrl(this);
/*		
		var formData = new FormData(document.getElementById('pictureForm'));
		
		var inputFile = $("input[name='picture']");
		
		var files = inputFile[0].files;
		
		$.ajax({
			url : "/pictureUpload",
			type : 'post',
			enctype : "multipart/form-data",
			data : formData,
			processData : false,
			contentType : false,
			success : function(data){
				alert("사진 업로드");
			},
			error : function(data){
				alert("사진 에러");
			}
		});
	*/	
	});
	

	var array = new Array();
	var i=0;
	
	$("input[name=eduReg]").on("click", function(e){
		e.preventDefault();
	/*	
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
		
		str += "<li>";
		str += "<input name = 'sName' value='"+ sNameVal + "'>";
		str += "<input name = 'major' value='"+ majorVal+ "'>";
		str += "<input name = 'division' value='"+ divisionVal + "'>";
		str += "<input name = 'startYear' value='"+ startYearVal+ "'>";
		str += "<input name = 'startMonth' value='"+ startMonthVal + "'>";
		str += "<input name = 'startDay' value='"+ startDayVal+ "'>";
		str += "<input name = 'endYear' value='"+ endYearVal + "'>";
		str += "<input name = 'endMonth' value='"+ endMonthVal+ "'>";
		str += "<input name = 'endDay' value='"+ endDayVal + "'>";
		str += "</li>";
		*/
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
		
		$("input[name='uniName']").val('');
		$("input[name='uniMajor']").val('');
		$("select[name='uniStartYear']").val('선택');
		$("select[name='uniStartMonth']").val('선택');
		$("select[name='uniStartDay']").val('선택');
		$("select[name='uniEndYear']").val('선택');
		$("select[name='uniEndMonth']").val('선택');
		$("select[name='uniEndDay']").val('선택');

	});
	
	
	
	$("input[name='bbsUpload']").on("click", function(e){
		e.preventDefault();
		
		var id = $("input[name='id']").val().trim();
		var name = $("input[name='name']").val().trim();
		
		console.log("id.length : "+id.length + "id : "+":"+id+":");
		console.log("name.length : " + name.length + "name : "+":"+name+":");

		if(id.length < 1){
			alert("id를 입력하세요");
			return false;
		}else if(name.length < 1){
			alert("이름을 입력하세요");
			return false;
		}
		
		
		console.log($("input[name='idNum']").val());
		var idNum = $("input[name='idNum']").val();
		var ch = idNum.charAt(6);
		
//		var tableForm = $(".tableForm");
		
		if(idNum.length < 13){
			alert("잘못된 주민등록번호");
			return false;
		}
		
		console.log(ch);
		if(ch == 1 || ch == 2){
		}else{
			alert("잘못된 주민등록 번호");
			return false;
		}
		
		var division = $(".division");
		
		console.log(division);
		
		if(division == null){
			alert("구분을 선택하세요");
			return false;
		}
		
		var formData = new FormData(document.getElementById('uploadForm'));
		
		var inputFile = $("input[name='picture']");
		
		var files = inputFile[0].files;
		
		console.log(files);
		
//		var fileStr =  "<input type='hidden' name='filename' value='"+files[0].name +"'>";
//		fileStr += "<input type='hidden' name='path' value='G:\\upload\\'>";
//		console.log(files[0].name, files[0].size);

//		$("li").append(fileStr);
		
		$.ajax({
//			url : "/uploadFile",
			url : "/register",
			type : 'post',
			enctype : "multipart/form-data",
			data : formData,
			processData : false,
			contentType : false,
			success : function(data){
				alert("업로드 성공!");
				location.href = "/bbsList";
			},
			error : function(data){
				alert("파일 업로드 에러!");
				console.log(data);
			}
		});
	
//		e.submit();
	});
	
	
	$("li").hide();
	
	/*
	$("input[type='file']").change(function(e){
		
		
		
	});
	*/
	
});

</script>


</body>
</html>
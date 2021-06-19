<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
      	
      	function transmit(latitude, longitude){
      		
      	   	document.getElementsByName("latitude")[0].value = latitude;
      	  	document.getElementsByName("longitude")[0].value = longitude;
      	  	document.getElementById("locationinfo").submit();
      	}
 </script> 

</head>
<body>
	<form id="locationinfo" method="post" action="kakaomap.jsp"">
    	<input type="hidden" name="latitude" />
        <input type="hidden" name="longitude"/>
</form>
</body>
</html>
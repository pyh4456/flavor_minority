<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "jsp.RestaurantDAO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
	html,
	body{
		width: 100%;
		height: 100%;
	}
</style>

<title>Insert title here</title>
</head>

<body>
	<%
	request.setCharacterEncoding("euc-kr");

	String restaurantName = request.getParameter("restaurant");
	
	RestaurantDAO dao = RestaurantDAO.getInstance();
	String menu = dao.getMenu(restaurantName);
	System.out.println(restaurantName+menu);
		
	%>
	
	<script type="text/javascript">
	
	function send(){
		var name = "<%=restaurantName%>";
		var menu = "<%=menu%>";
		var url = "app://"+name+ menu;
		var urlString = encodeURI(url);
		
		window.location.href = urlString;
}
	send();
	
	</script>
  
</body>

</html>
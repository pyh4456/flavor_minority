<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	String ID = null;
	String bin_result = null;
	if(request.getParameter("ID") != null){
		ID = (String) request.getParameter("ID");
	}
	if(request.getParameter("bin_result") != null){
		bin_result = (String) request.getParameter("bin_result");
	}
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String statement = "UPDATE user_information SET "
			+ "buckwheat = ?,"
			+ "wheat = ?,"
			+ "soybean =?,"
			+ "walnut =?,"
			+ "peanut =?,"
			+ "peach =?,"
			+ "tomato =?,"
			+ "pork =?,"
			+ "poultry =?,"
			+ "milk =?,"
			+ "chiken =?,"
			+ "beef =?,"
			+ "shrimp =?,"
			+ "mackerel =?,"
			+ "mussel =?,"
			+ "abalon =?,"
			+ "oyster =?,"
			+ "shellfish =?,"
			+ "crab =?,"
			+ "squid =?,"
			+ "cucumber =?,"
			+ "onion =?,"
			+ "carrot =?,"
			+ "branch =?,"
			+ "broccoli =?,"
			+ "seaweed =?,"
			+ "mushroom =?,"
			+ "coriander =?"
			+ " WHERE id = ?;";
	try {
		System.out.println(bin_result);
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://the4456.iptime.org:3306/flavor_minority","root","");
		pstmt = conn.prepareStatement(statement);
		for (int i = 1; i <= 28; i++){
			pstmt.setString(i, String.valueOf(bin_result.charAt(i-1)));
		}
		pstmt.setString(29, ID);
		pstmt.executeUpdate();
		
	} catch (ClassNotFoundException e) {
		System.out.println("JDBC드라이버 로드 실패");
	} catch(SQLException e) {
		System.out.println("sql error");
	}
%>

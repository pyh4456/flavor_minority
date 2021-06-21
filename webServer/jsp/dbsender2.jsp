<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>
    <%@ page import = "jsp.RestaurantDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String restaurant = null;
	String bin_result = null;
	String dishName = "", array[];
	if(request.getParameter("ID") != null){
		restaurant = request.getParameter("ID");
	}
	System.out.println(restaurant);
	if(request.getParameter("bin_result") != null){
		bin_result = (String) request.getParameter("bin_result");
		array = bin_result.split(",");
		dishName = array[0];
		bin_result = array[1];	
	}
	
	RestaurantDAO dao = RestaurantDAO.getInstance();
	dao.addMenu(restaurant, dishName, bin_result);
%>

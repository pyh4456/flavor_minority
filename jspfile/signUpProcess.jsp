<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "jsp.MemberDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
	<script type="text/javascript">
	
		function goLogin() {
        	location.href="login.jsp";
    	}
		function goSignUp() {
        	location.href="signUpPage.jsp";
    	}
     	var duplicate = false;
		<%		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		MemberDAO dao = MemberDAO.getInstance();
		
		boolean result = dao.duplicateCheck(id);
		if(result){
			dao.signUp(id,password,name);
		}
		%>
		duplicate = <%=result%>;
		if(!duplicate){
			alert("ID가 이미 사용중입니다.");
			goSignUp();
		}else{
			alert("회원가입 성공.");
			goLogin();
		}
		
	</script>
</head>
<body>

</body>
</html>
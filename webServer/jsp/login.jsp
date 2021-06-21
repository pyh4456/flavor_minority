<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login page</title>

<script type="text/javascript">

function checkValue()
{
    inputForm = eval("document.loginInfo");
    if(!inputForm.id.value)
    {
        alert("아이디를 입력하세요");    
        inputForm.id.focus();
        return false;
    }
    if(!inputForm.password.value)
    {
        alert("비밀번호를 입력하세요");    
        inputForm.password.focus();
        return false;
    }
}

// 회원가입 버튼 클릭시 회원가입 화면으로 이동
function signUp() {
    location.href="signUpPage.jsp";
}    
</script>

</head>
<body>
<div id="wrap">
<form name="loginInfo" method="post" action="LoginProcess.jsp" 
        onsubmit="return checkValue()">
    <br><br>
    
    <table>
        <tr>
            <td bgcolor="skyblue">아이디</td>
            <td><input type="text" name="id" maxlength="50"></td>
        </tr>
        <tr>
            <td bgcolor="skyblue">비밀번호</td>
            <td><input type="password" name="password" maxlength="50"></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="로그인"/>
</form>
<br>
	<input type="button" value="회원가입" onclick="signUp()" />
	

<% 
    // 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
    // LoginPro.jsp에서 로그인 처리 결과에 따른 메시지를 보낸다.
    String msg=request.getParameter("msg");
    
    if(msg!=null && msg.equals("0")) 
    {
        out.println("<br>");
        out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
    }
    else if(msg!=null && msg.equals("-1"))
    {    
        out.println("<br>");
        out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
    }
%>    
</div>    
</body>
</html>
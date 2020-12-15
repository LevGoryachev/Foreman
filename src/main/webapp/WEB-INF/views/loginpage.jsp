<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>Constructions</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body class="presentational">
<h2>Welcome to FOREMAN!</h2>
<h3>- please, login</h3>

<c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>

<form name='login' action="${pageContext.request.contextPath}/customlogin" method='POST'>
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
    <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
</form>
</body>

</html>
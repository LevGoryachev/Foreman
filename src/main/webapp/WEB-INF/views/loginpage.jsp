<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>Constructions</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body class="presentational">

<div>
    <h1>Welcome to FOREMAN!</h1>
    <h3>supply service for building construction</h3>
        <p>
            You can try Foreman using these authorizations:
        </p>
    <table>
        <tr>
            <td>I.I. Ivanov (CEO) - login: <b>ivanov</b>, password: <b>ivanov</b>, has role CHIEF</td>
        </tr>
        <tr>
            <td>P.P. Petrov (technician) - login: <b>petrov</b>, password: <b>petrov</b>, has role EMPLOYEE</td>
        </tr>
        <tr>
            <td>S.S. Sidorov (supply) - login: <b>sidorov</b>, password: <b>sidorov</b>, has role SUPPLIER</td>
        </tr>
        <tr>
            <td>Admin - login: <b>admin</b>, password: <b>admin</b>, has role ADMIN</td>
        </tr>
    </table>
    <p>
       APP exhibits different behaviors for each role.
    </p>
</div>

<div>
    <!--<c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>-->
    <div class="mainearblock">
    <form name='login' action="${pageContext.request.contextPath}/customlogin" method='POST'>
        <table align="center">
            <tr>
                <td>login:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td></td>
                <td><input class="mainearbutton buttonblick" name="submit" type="submit" value="submit" /></td>
            </tr>
        </table>
        <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
    </form>
    </div>
</div>

<div id="copyrightline">
    <p>Foreman createdByLevGoryachev();</p>
</div>

</body>

</html>
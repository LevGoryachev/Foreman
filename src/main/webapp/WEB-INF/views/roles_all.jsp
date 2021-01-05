<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Roles</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
    </div>
    <div class="headerleftinfo">
        <h1>FOREMAN admin panel</h1>
        <p>Roles only available: ADMIN, CHIEF, EMPLOYEE, SUPPLIER</p>
    </div>
    <div class="headerightbtns">
    </div>
</div>

<div class="mainer">
    <p><h2>Roles (authorities)</h2></p>
    <table align="center" border="1" cellpadding="5">
        <tr>
            <td>ID</td>
            <td>RANK (authority)</td>
        </tr>
        <c:forEach items="${rolesList}" var="rolesList">
            <tr>
                <td>${rolesList.id}</td>
                <td>${rolesList.rank}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a class="buttonblicklighted" href="${pageContext.request.contextPath}/admin">Back to admin panel</a>
    </p>
</div>

<div  class="footer">
    <div class="footerleftbtns">
    </div>
    <div id="copyrightline">
        <p>Foreman createdByLevGoryachev();</p>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/user-info" target="_blank">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>
</html>
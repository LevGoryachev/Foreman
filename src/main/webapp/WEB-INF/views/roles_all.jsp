<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Roles</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<p><h2>Roles (authorities)</h2></p>
<table border="1" cellpadding="5">
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

<h3><a href="./admin">Back to admin panel</a></h3>

</body>
</html>
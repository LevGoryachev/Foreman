<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Users</title>
</head>

<body>
<p><h2>APP users</h2></p>
<table border="1" cellpadding="5">
    <tr>
        <td>ID</td>
        <td>FIRST NAME</td>
        <td>MIDDLE NAME</td>
        <td>LAST NAME</td>
        <td>LOGIN</td>
        <td>PASSWORD</td>
        <td>ROLE</td>
    </tr>
    <c:forEach items="${userList}" var="userList">
        <tr>
            <td>${userList.id}</td>
            <td>${userList.firstName}</td>
            <td>${userList.middleName}</td>
            <td>${userList.lastName}</td>
            <td>${userList.login}</td>
            <td>${userList.password}</td>
            <td>${userList.roleId}</td>
            <form name = "edit" action = "${pageContext.request.contextPath}/users/edit/${userList.id}" method="get">
                <td><input type="submit" value="EDIT"></td>
            </form>
            <form name = "delete" action = "${pageContext.request.contextPath}/users/del/${userList.id}" method="post" onsubmit="return confirm('Delete this?');">
                <td><input type="submit" value="DELETE"></td>
            </form>
        </tr>
    </c:forEach>
    <form name = "appUserAttr" action = "${pageContext.request.contextPath}/users/add" method="post" onsubmit="return confirm('Add new?');">
        <tr>
            <td><input title="ID" type="text" name="id"></td>
            <td><input title="FIRST NAME" type="text" name="firstName"></td>
            <td><input title="MIDDLE NAME" type="text" name="middleName"></td>
            <td><input title="LAST NAME" type="text" name="lastName"></td>
            <td><input title="LOGIN" type="text" name="login"></td>
            <td><input title="PASSWORD" type="text" name="password"></td>
            <td><input title="ROLE" type="text" name="roleId"></td>
            <td></td>
            <td><input type="submit" value="ADD NEW"></td>
        </tr>
    </form>
</table>
<p>
<h3><a href="./admin">Back to admin panel</a></h3>
</p>
</body>

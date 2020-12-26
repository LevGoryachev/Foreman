<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Users</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
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
        <td>PASSWORD (To generate password use <a href="https://bcrypt-generator.com/" target="_blank">BCrypt generator</a>)</td>
        <td>ROLE</td>
        <td colspan="2">EDIT DATA</td>
    </tr>
    <c:forEach items="${userList}" var="userList">
        <tr>
            <td>${userList.id}</td>
            <td>${userList.firstName}</td>
            <td>${userList.middleName}</td>
            <td>${userList.lastName}</td>
            <td>${userList.login}</td>
            <td>${userList.password}</td>
            <td>${userList.entityRoleRank}</td>
            <form name = "edit" action = "${pageContext.request.contextPath}/admin/users/edit/${userList.id}" method="get">
                <td><input type="submit" value="EDIT"></td>
            </form>
            <form name = "delete" action = "${pageContext.request.contextPath}/admin/users/del/${userList.id}" method="post" onsubmit="return confirm('Delete this?');">
                <td><input type="submit" value="DELETE"></td>
            </form>
        </tr>
    </c:forEach>
    <form name = "appUserAttr" action = "${pageContext.request.contextPath}/admin/users/add" method="post" onsubmit="return confirm('Add new?');">
        <tr>
            <td><input title="ID" type="text" name="id"></td>
            <td><input title="FIRST NAME" type="text" name="firstName"></td>
            <td><input title="MIDDLE NAME" type="text" name="middleName"></td>
            <td><input title="LAST NAME" type="text" name="lastName"></td>
            <td><input title="LOGIN" type="text" name="login"></td>
            <td><input title="PASSWORD" type="text" name="password"></td>
            <td>
                <select name="roleId">
                    <c:forEach items="${allRolesList}" var="allRolesList">
                        <option value="${allRolesList.id}">${allRolesList.rank}</option>
                    </c:forEach>
                </select>
            </td>
            <td colspan="2"><input type="submit" value="ADD NEW"></td>
        </tr>
    </form>
</table>
<p>
<h3><a href="${pageContext.request.contextPath}/admin">Back to admin panel</a></h3>
</p>
</body>

</html>
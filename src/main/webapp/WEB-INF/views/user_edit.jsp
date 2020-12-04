<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Edit user</title>
</head>

<body>
<p><h2>Edit user</h2></p>
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
    <form name = "appUserAttr" action = "${pageContext.request.contextPath}/users/upd" method="post" onsubmit="return confirm('Update this?');">
        <tr>
            <td><input title="ID" type="text" name="id" value="${userEdit.id}" readonly></td>
            <td><input title="FIRST NAME" type="text" name="firstName" value="${userEdit.firstName}"></td>
            <td><input title="MIDDLE NAME" type="text" name="middleName" value="${userEdit.middleName}"></td>
            <td><input title="LAST NAME" type="text" name="lastName" value="${userEdit.lastName}"></td>
            <td><input title="LOGIN" type="text" name="login" value="${userEdit.login}"></td>
            <td><input title="PASSWORD" type="text" name="password" value="${userEdit.password}"></td>
            <td><input title="ROLE" type="text" name="roleId" value="${userEdit.roleId}"></td>
            <td></td>
            <td><input type="submit" value="UPDATE"></td>
        </tr>
    </form>
</table>
</body>

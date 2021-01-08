<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Edit user</title>
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
    <p><h2>Edit user</h2></p>
    <table border="1" cellpadding="5">
        <tr>
            <td>ID</td>
            <td>FIRST NAME</td>
            <td>MIDDLE NAME</td>
            <td>LAST NAME</td>
            <td>LOGIN</td>
            <td>PASSWORD (<a href="https://bcrypt-generator.com/" target="_blank">BCrypt generator</a>)</td>
            <td>EMAIL</td>
            <td>ROLE</td>
            <td>Confirm</td>
        </tr>
        <form name = "appUserAttr" action = "${pageContext.request.contextPath}/admin/users/upd" method="post" onsubmit="return confirm('Update this?');">
            <tr>
                <td><input title="ID" type="text" name="id" value="${userEdit.id}" readonly></td>
                <td><input title="FIRST NAME" type="text" name="firstName" value="${userEdit.firstName}" required pattern="^[^\s]*$"></td>
                <td><input title="MIDDLE NAME" type="text" name="middleName" value="${userEdit.middleName}"></td>
                <td><input title="LAST NAME" type="text" name="lastName" value="${userEdit.lastName}" required pattern="^[^\s]*$"></td>
                <td><input title="LOGIN" type="text" name="login" value="${userEdit.login}" required pattern="^[^\s]*$"></td>
                <td><input title="PASSWORD" type="text" name="password" value="${userEdit.password}" required></td>
                <td><input title="EMAIL" type="text" name="email" value="${userEdit.email}"></td>
                <td>
                    <select name="roleId">
                        <option value="${userEdit.roleId}" selected>${userEdit.entityRoleRank}</option>
                        <c:forEach items="${changeRoles}" var="changeRoles">
                            <option value="${changeRoles.id}">${changeRoles.rank}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="UPDATE"></td>
            </tr>
        </form>
    </table>
    <p>
        <a class="buttonblicklighted" href="${pageContext.request.contextPath}/admin/users-editable">Back to users</a>
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
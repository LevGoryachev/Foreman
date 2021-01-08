<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Users</title>
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
    <p><h2>APP users</h2></p>
    <table border="1" cellpadding="5">
        <tr>
            <td>ID</td>
            <td>FIRST NAME</td>
            <td>MIDDLE NAME</td>
            <td>LAST NAME</td>
            <td>LOGIN</td>
            <td>PASSWORD (before saving passwords, use <a href="https://bcrypt-generator.com/" target="_blank">BCrypt generator</a>) (12 rounds)</td>
            <td>EMAIL</td>
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
                <td>${userList.email}</td>
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
                <td><input title="ID" type="text" name="id" required pattern="^[ 0-9]+$"></td>
                <td><input title="FIRST NAME" type="text" name="firstName" required pattern="^[^\s]*$"></td>
                <td><input title="MIDDLE NAME" type="text" name="middleName"></td>
                <td><input title="LAST NAME" type="text" name="lastName" required pattern="^[^\s]*$"></td>
                <td><input title="LOGIN" type="text" name="login" required pattern="^[^\s]*$"></td>
                <td><input title="PASSWORD" type="text" name="password" required></td>
                <td><input title="EMAIL" type="text" name="email"></td>
                <td>
                    <select name="roleId">
                        <c:forEach items="${allRolesList}" var="allRolesList">
                            <option value="${allRolesList.id}">${allRolesList.rank}</option>
                        </c:forEach>
                    </select>
                </td>
                <td colspan="2"><input type="submit" value="ADD"></td>
            </tr>
        </form>
    </table>
    <p>
        Before saving passwords, use BCrypt generator: <a href="https://bcrypt-generator.com/" target="_blank">https://bcrypt-generator.com</a> (12 rounds).
    </p>
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
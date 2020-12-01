<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Roles</title>
</head>

<body>
<p><h2>Edit roles</h2></p>
<table border="1" cellpadding="5">
    <tr>
        <td>ID</td>
        <td>ROLE</td>
    </tr>
    <c:forEach items="${rolesList}" var="rolesList">
        <tr>
            <td>${rolesList.id}</td>
            <td>${rolesList.rank}</td>
            <form name = "delete" action = "${pageContext.request.contextPath}/roles/del/${rolesList.id}" method="get" onsubmit="return confirm('Delete this?');">
                <td><input type="submit" value="DELETE"></td>
            </form>
        </tr>
    </c:forEach>
    <form name = "construction" action = "${pageContext.request.contextPath}/roles/add" method="post" onsubmit="return confirm('Add new?');">
        <tr>
            <td><input title="ID" type="text" name="id"></td>
            <td><input title="ROLE" type="text" name="rank"></td>
            <td><input type="submit" value="ADD NEW"></td>
        </tr>
    </form>
</table>
<p>
<h3><a href="./">Back to main page</a></h3>
</p>
</body>
</html>
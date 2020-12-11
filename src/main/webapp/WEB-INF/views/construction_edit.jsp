<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Edit construction</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<p><h2>Edit construction</h2></p>
<table border="1" cellpadding="5">
    <tr>
        <td>ID</td>
        <td>CODENUMBER</td>
        <td>NAME</td>
        <td>DESCRIPTION</td>
        <td>Confirm</td>
    </tr>
    <form name = "construction" action = "${pageContext.request.contextPath}/constructions/upd" method="post" onsubmit="return confirm('Update this?');">
        <tr>
            <td><input title="ID" type="text" name="id" value="${constructionEdit.id}" readonly></td>
            <td><input title="CODENUMBER" type="text" name="codenumber" value="${constructionEdit.codenumber}"></td>
            <td><input title="NAME" type="text" name="name" value="${constructionEdit.name}"></td>
            <td><input title="DESCRIPTION" type="text" name="description" value="${constructionEdit.description}"></td>
            <td><input type="submit" value="UPDATE"></td>
        </tr>
    </form>
</table>
</body>

</html>
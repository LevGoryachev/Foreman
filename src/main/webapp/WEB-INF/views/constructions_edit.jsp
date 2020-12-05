<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Constructions</title>
</head>

<body>
<p><h2>List of constructions</h2></p>
<table border="1" cellpadding="5">
        <tr>
            <td>ID</td>
            <td>CODE-NUMBER</td>
            <td>Name of project</td>
            <td>Description</td>
            <td colspan="2">EDIT DATA</td>
        </tr>
    <c:forEach items="${constructionsList}" var="constructionsList">
        <tr>
            <td>${constructionsList.id}</td>
            <td>${constructionsList.codenumber}</td>
            <td><a href="./construction/${constructionsList.name}">${constructionsList.name}</a></td>
            <td>${constructionsList.description}</td>
            <form name = "edit" action = "${pageContext.request.contextPath}/constructions/edit/${constructionsList.id}" method="get">
                <td><input type="submit" value="EDIT"></td>
            </form>
            <form name = "delete" action = "${pageContext.request.contextPath}/constructions/del/${constructionsList.id}" method="post" onsubmit="return confirm('Delete this?');">
                <td><input type="submit" value="DELETE"></td>
            </form>
        </tr>
    </c:forEach>
    <form name = "construction" action = "${pageContext.request.contextPath}/constructions/add" method="post" onsubmit="return confirm('Add new?');">
        <tr>
            <td><input title="ID" type="text" name="id"></td>
            <td><input title="CODENUMBER" type="text" name="codenumber"></td>
            <td><input title="NAME" type="text" name="name"></td>
            <td><input title="DESCRIPTION" type="text" name="description"></td>
            <td colspan="2"><input type="submit" value="ADD NEW"></td>
        </tr>
    </form>
</table>
<p>
<h3><a href="./">Back to main page</a></h3>
</p>
</body>
</html>
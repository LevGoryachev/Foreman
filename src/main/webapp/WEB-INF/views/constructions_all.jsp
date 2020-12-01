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
        </tr>
    <c:forEach items="${constructionsList}" var="constructionsList">
        <tr>
            <td>${constructionsList.id}</td>
            <td>${constructionsList.codenumber}</td>
            <td><a href="./construction/${constructionsList.name}">${constructionsList.name}</a></td>
            <td>${constructionsList.description}</td>
        </tr>
    </c:forEach>
</table>
<form name = "construction" action = "${pageContext.request.contextPath}/constructions-editable" method="get">
    <input type="submit" value="EDIT CONSTRUCTIONS">
</form>
<p>
<h3><a href="./">Back to main page</a></h3>
</p>
</body>
</html>
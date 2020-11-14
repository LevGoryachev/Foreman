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
    <c:forEach items="${constructionsList}" var="constructionlst">
        <tr>
            <td>${constructionlst.id}</td>
            <td>${constructionlst.codenumber}</td>
            <td><a href="./construction/${constructionlst.name}">${constructionlst.name}</a></td>
            <td>${constructionlst.description}</td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
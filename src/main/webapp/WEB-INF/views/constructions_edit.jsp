<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Constructions</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
    </div>
    <div class="headerleftinfo">
        <h3>Be careful! Changed data will be saved in database after confirmation.</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide" target="_blank">Guide</a>
    </div>
</div>

<p><a name="top"></a></p>

<div class="mainer">
    <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ID</td>
                <td width="200px">CODE-NUMBER</td>
                <td width="200px">Name of project</td>
                <td width="400px">Description</td>
                <td colspan="2">EDIT DATA</td>
            </tr>
        <c:forEach items="${constructionsList}" var="constructionsList">
            <tr>
                <td width="100px">${constructionsList.id}</td>
                <td width="200px">${constructionsList.codenumber}</td>
                <td width="200px"><a href="./construction/${constructionsList.name}">${constructionsList.name}</a></td>
                <td width="400px">${constructionsList.description}</td>
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
                <td width="100px"><input class="smallfield" title="ID" type="text" name="id"></td>
                <td width="200px"><input class="averagefield" title="CODENUMBER" type="text" name="codenumber"></td>
                <td width="200px"><input class="averagefield" title="NAME" type="text" name="name"></td>
                <td width="400px"><textarea cols="50" rows="5" title="DESCRIPTION" type="text" name="description"></textarea></td>
                <td colspan="2"><input type="submit" value="ADD NEW"></td>
            </tr>
        </form>
    </table>
</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="#top">PageUP</a>
        <a class="linearbutton buttonblick" href="#bottom">PageDOWN</a>
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/constructions">Back to Constructions</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/user-info" target="_blank">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
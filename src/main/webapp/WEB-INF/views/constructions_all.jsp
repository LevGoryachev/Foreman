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
        <h3>List of constructions. Click on the construction to enter.</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblickdimmed" href="${pageContext.request.contextPath}/constructions">Constructions</a>
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
            </tr>
        <c:forEach items="${constructionsList}" var="constructionsList">
            <tr>
                <td width="100px">${constructionsList.id}</td>
                <td width="200px">${constructionsList.codenumber}</td>
                <td width="200px"><a href="./construction/${constructionsList.name}"><b>${constructionsList.name}</b></a></td>
                <td width="400px">${constructionsList.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="#top">PageUP</a>
        <a class="linearbutton buttonblick" href="#bottom">PageDOWN</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions-editable">EDIT LIST</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Edit construction</title>
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
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide">Guide</a>
    </div>
</div>

<div class="mainer">
    <p><h3 class="maineartableinfo">Edit construction</h3></p>
    <table border="1" cellpadding="5">
        <tr>
            <td width="100px">ID</td>
            <td width="200px">CODENUMBER</td>
            <td width="200px">NAME</td>
            <td width="400px">DESCRIPTION</td>
            <td>Confirm</td>
        </tr>
        <form name = "construction" action = "${pageContext.request.contextPath}/constructions/upd" method="post" onsubmit="return confirm('Update this?');">
            <tr>
                <td width="100px"><input class="smallfield" title="ID" type="text" name="id" value="${constructionEdit.id}" readonly></td>
                <td width="200px"><input class="averagefield" title="CODENUMBER" type="text" name="codenumber" value="${constructionEdit.codenumber}"></td>
                <td width="200px"><input class="averagefield" title="NAME" type="text" name="name" value="${constructionEdit.name}"></td>
                <td width="400px"><textarea cols="50" rows="5" title="DESCRIPTION" type="text" name="description">${constructionEdit.description}</textarea></td>
                <td><input type="submit" value="UPDATE"></td>
            </tr>
        </form>
    </table>
</div>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/constructions-editable">Back to List</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
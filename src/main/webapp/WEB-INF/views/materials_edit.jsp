<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Edit list of materials</title>
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
            <td width="400px">NAME</td>
            <td width="100px">UNIT MEASURE</td>
            <td width="100px">UNIT WEIGHT, KG</td>
            <td width="400px">NOTES</td>
            <td colspan="2">EDIT DATA</td>
        </tr>
        <c:forEach items="${materialList}" var="materialList">
            <tr>
                <td width="100px">${materialList.id}</td>
                <td width="400px">${materialList.name}</td>
                <td width="100px">${materialList.um}</td>
                <td width="100px">${materialList.unitWkg}</td>
                <td width="400px">${materialList.notes}</td>
                <form name = "edit" action = "${pageContext.request.contextPath}/materials/edit/${materialList.id}" method="get">
                    <td><input type="submit" value="EDIT"></td>
                </form>
                <form name = "delete" action = "${pageContext.request.contextPath}/materials/del/${materialList.id}" method="post" onsubmit="return confirm('Delete this?');">
                    <td><input type="submit" value="DELETE"></td>
                </form>
            </tr>
        </c:forEach>
    <form name = "material" action = "${pageContext.request.contextPath}/materials/add" method="post" onsubmit="return confirm('Add new?');">
        <tr>
            <td width="100px"><input class="smallfield" title="ID" type="text" name="id"></td>
            <td width="400px"><input class="widefield" title="NAME" type="text" name="name"></td>
            <td width="100px"><input class="smallfield" title="UNIT MEASURE" type="text" name="um"></td>
            <td width="100px"><input class="smallfield" title="UNIT WEIGHT, KG" type="text" name="unitWkg"></td>
            <td width="400px"><textarea cols="50" rows="5" title="NOTES" type="text" name="notes"></textarea></td>
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
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/materials">Back to Materials</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>


</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Genaral list of materials</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
    </div>
    <div class="headerleftinfo">
        <h3>Materials (catalog). These materials can be added to the bills (specification).</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblickdimmed" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide" target="_blank">Guide</a>
    </div>
</div>

<p><a name="top"></a></p>

<div class="mainer">
    <p class="maineartableinfo">To add materials to the bill (specification) go to: Constructions -> Your construction -> Bill of materials -> Edit list</p>
    <table border="1" cellpadding="5">
        <tr>
            <td width="100px">ID</td>
            <td width="400px">NAME</td>
            <td width="100px">UNIT MEASURE</td>
            <td width="100px">UNIT WEIGHT, KG</td>
            <td width="400px">NOTES</td>
        </tr>
        <c:forEach items="${materialList}" var="materialList">
            <tr>
                <td width="100px">${materialList.id}</td>
                <td width="400px">${materialList.name}</td>
                <td width="100px">${materialList.um}</td>
                <td width="100px">${materialList.unitWkg}</td>
                <td width="400px">${materialList.notes}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="#top">PageUP</a>
        <a class="linearbutton buttonblick" href="#bottom">PageDOWN</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials-editable">EDIT LIST</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
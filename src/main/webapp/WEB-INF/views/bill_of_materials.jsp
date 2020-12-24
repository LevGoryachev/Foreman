<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Bill</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<c:forEach items="${serviceList}" var="constructionList">
    <c:set var="currentCodeNumber" value="${constructionList.entityConstructionCodeNumber}" scope="page"/>
    <c:set var="currentName" value="${constructionList.entityConstructionName}" scope="page"/>
</c:forEach>

<div class="header">
    <div class="headerleftinfo">
        <div>
            <a class="buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
            <a class="buttonblick" href="${pageContext.request.contextPath}/construction/${currentName}">Back to ${currentName}</a>
        </div>
        <div>
            <h3>Bill of materials (specification) of construction site - ${currentName}, codenumber: ${currentCodeNumber}</h3>
        </div>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide">Guide</a>
    </div>
</div>

<p><a name="top"></a></p>

<div class="mainer">

    <div class="maineartableinfo">
        <p>You are allowed to add only these materials to orders for ${currentName}.</p>
    </div>

<table border="1" cellpadding="5">
    <tr>
        <td width="400px">MATERIAL</td>
        <td width="100px">UNIT MEASURE</td>
        <td width="100px">UNIT WEIGHT, KG</td>
        <td width="100px">QUANTITY</td>
        <td width="400px">NOTES</td>
    </tr>
    <c:forEach items="${serviceList}" var="attributeList">
        <tr>
            <td width="400px">${attributeList.entityMaterialName}</td>
            <td width="100px">${attributeList.entityMaterialUm}</td>
            <td width="100px">${attributeList.entityMaterialUnitWkg}</td>
            <td width="100px">${attributeList.billqty}</td>
            <td width="400px">${attributeList.entityMaterialNotes}</td>

<!--uncomment these fields for possibility to see all from result-set (join)-->
            <!--<td>${attributeList.constructionId}</td>-->
            <!--<td>${attributeList.materialId}</td>-->
            <!--<td>${attributeList.entityConstructionName}</td>-->
            <!--<td>${attributeList.entityConstructionId}</td>-->
        </tr>
    </c:forEach>

</table>

</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="#top">PageUP</a>
        <a class="linearbutton buttonblick" href="#bottom">PageDOWN</a>
        <a class="linearbutton buttonblick" href="../${currentName}/materials-editable">EDIT LIST</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
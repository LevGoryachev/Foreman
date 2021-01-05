<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Bill edit</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<c:forEach items="${serviceList}" var="constructionList">
    <c:set var="currentCodeNumber" value="${constructionList.entityConstructionCodeNumber}" scope="page"/>
    <c:set var="currentName" value="${constructionList.entityConstructionName}" scope="page"/>
    <!--<c:set var="currentID" value="${constructionList.entityConstructionId}" scope="page"/>-->
</c:forEach>

<div class="header">
    <div class="headerleftbtns">
        <div>
            <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
            <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/construction/${currentName}">Construction main page</a>
        </div>
    </div>
    <div class="headerleftinfo">
        <h3>Bill of materials (specification) of construction site - ${currentName}, codenumber: ${currentCodeNumber}</h3>
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
            <td width="400px">MATERIAL</td>
            <td width="100px">UNIT MEASURE</td>
            <td width="100px">UNIT WEIGHT, KG</td>
            <td width="100px">QUANTITY</td>
            <td width="400px">NOTES</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${serviceList}" var="attributeList">
            <tr>
                <td width="400px">${attributeList.entityMaterialName}</td>
                <td width="100px">${attributeList.entityMaterialUm}</td>
                <td width="100px">${attributeList.entityMaterialUnitWkg}</td>
                <td width="100px">${attributeList.billqty}</td>
                <td width="400px">${attributeList.entityMaterialNotes}</td>
            <form name = "delete" action = "${pageContext.request.contextPath}/construction/${currentName}/materials/editable/del/${attributeList.materialId}" method="post" onsubmit="return confirm('Delete this?');">
                <td><input type="submit" value="DELETE"></td>
            </form>

<!--uncomment these fields for possibility to see all from result-set (join)-->
            <!--<td>${attributeList.constructionId}</td>-->
            <!--<td>${attributeList.materialId}</td>-->
            <!--<td>${attributeList.entityConstructionName}</td>-->
            <!--<td>${attributeList.entityConstructionId}</td>-->
            </tr>
        </c:forEach>
            <tr>
                <form name = "billposition" action = "${pageContext.request.contextPath}/construction/${currentName}/materials/editable/add" method="post" onsubmit="return confirm('Add new?');">
                    <input title="C_ID" type="text" name="constructionId" value="${currentID}" readonly hidden>
                    <td>
                        <select class="widefield" name="materialId">
                            <c:forEach items="${allMaterialsList}" var="materialList">
                                <option value="${materialList.id}">${materialList.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                    <td></td>
                    <td><input title="BILLQTY" type="text" name="billqty"></td>
                    <td></td>
                    <td><input type="submit" value="ADD"></td>
                </form>
            </tr>
    </table>
</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="#top">PageUP</a>
        <a class="linearbutton buttonblick" href="#bottom">PageDOWN</a>
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/construction/${currentName}/materials">Back to Bill</a>
    </div>
    <div id="copyrightline">
        <p>Foreman createdByLevGoryachev();</p>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/user-info" target="_blank">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Bill</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<p>Bill of materials</p>

<c:forEach items="${serviceList}" var="constructionList">
    <c:set var="currentCodeNumber" value="${constructionList.entityConstructionCodeNumber}" scope="page"/>
    <c:set var="currentName" value="${constructionList.entityConstructionName}" scope="page"/>
</c:forEach>

<p>Construction site - ${currentName}, codenumber: ${currentCodeNumber}</p>

</p>
<table border="1" cellpadding="5">
    <tr>
        <td>MATERIAL</td>
        <td>UNIT MEASURE</td>
        <td>UNIT WEIGHT, KG</td>
        <td>QUANTITY</td>
        <td>NOTES</td>
    </tr>
    <c:forEach items="${serviceList}" var="attributeList">
        <tr>
            <td>${attributeList.entityMaterialName}</td>
            <td>${attributeList.entityMaterialUm}</td>
            <td>${attributeList.entityMaterialUnitWkg}</td>
            <td>${attributeList.billqty}</td>
            <td>${attributeList.entityMaterialNotes}</td>

<!--uncomment these fields for possibility to see all from result-set (join)-->
            <!--<td>${attributeList.constructionId}</td>-->
            <!--<td>${attributeList.materialId}</td>-->
            <!--<td>${attributeList.entityConstructionName}</td>-->
            <!--<td>${attributeList.entityConstructionId}</td>-->
        </tr>
    </c:forEach>

</table>
    <p><a href="../${currentName}/materials/editable">Edit list</a></p>
    <h3><a href="../${currentName}">Back to construction page</a></h3>

</body>

</html>
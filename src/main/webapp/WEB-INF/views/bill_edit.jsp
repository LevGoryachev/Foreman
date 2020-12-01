<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title></title>
</head>

<body>
<p>EDIT BILL OF MATERIALS</p>
<c:forEach items="${serviceList}" var="constructionList">
    <c:set var="currentCodeNumber" value="${constructionList.entityConstructionCodeNumber}" scope="page"/>
    <c:set var="currentName" value="${constructionList.entityConstructionName}" scope="page"/>
    <!--<c:set var="currentID" value="${constructionList.entityConstructionId}" scope="page"/>-->
</c:forEach>
<p>
    Construction site - ${currentName}, codenumber: ${currentCodeNumber}
</p>

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
            <form name = "delete" action = "${pageContext.request.contextPath}/construction/${currentName}/materials/editable/del/${attributeList.materialId}" method="get" onsubmit="return confirm('Delete this?');">
                <td><input type="submit" value="DELETE"></td>
            </form>

<!--uncomment these fields for possibility to see all from result-set (join)-->
            <!--<td>${attributeList.constructionId}</td>-->
            <!--<td>${attributeList.materialId}</td>-->
            <!--<td>${attributeList.entityConstructionName}</td>-->
            <!--<td>${attributeList.entityConstructionId}</td>-->
        </tr>
    </c:forEach>
</table>
<p>
    Add new material to specification
</p>

<table border="1" cellpadding="5">
    <tr>
        <td>technical info: id</td>
        <td>CHOOSE MATERIAL</td>
        <td>SET QUANTITY</td>
    </tr>
    <form name = "billposition" action = "${pageContext.request.contextPath}/construction/${currentName}/materials/editable/add" method="post" onsubmit="return confirm('Add new?');">
        <tr>
            <td><input title="C_ID" type="text" name="constructionId" value="${currentID}" readonly></td>
            <td>
                <select name="materialId">
                    <c:forEach items="${allMaterialsList}" var="materialList">
                        <option value="${materialList.id}">${materialList.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input title="BILLQTY" type="text" name="billqty"></td>
        </tr>
        <td><input type="submit" value="ADD NEW"></td>
    </form>
</table>

    <h3><a href="../materials">Back to bill of materials</a></h3>

</body>
</html>
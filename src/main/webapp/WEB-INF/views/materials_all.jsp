<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Genaral list of materials</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<p><h2>General list of materials</h2></p>
<table border="1" cellpadding="5">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>UNIT MEASURE</td>
        <td>UNIT WEIGHT, KG</td>
        <td>NOTES</td>
    </tr>
    <c:forEach items="${materialList}" var="materialList">
        <tr>
            <td>${materialList.id}</td>
            <td>${materialList.name}</td>
            <td>${materialList.um}</td>
            <td>${materialList.unitWkg}</td>
            <td>${materialList.notes}</td>
        </tr>
    </c:forEach>
</table>
<form name = "construction" action = "${pageContext.request.contextPath}/materials-editable" method="get">
    <input type="submit" value="EDIT MATERIALS">
</form>

<h3><a href="./">Back to main page</a></h3>

</body>

</html>
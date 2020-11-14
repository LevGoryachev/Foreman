<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Genaral list of materials</title>
</head>

<body>
<p><h2>Genaral list of materials</h2></p>
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
</body>

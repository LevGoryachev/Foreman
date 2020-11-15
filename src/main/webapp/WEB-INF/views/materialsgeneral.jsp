<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Genaral list of materials</title>
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
            <td><a href="./materials/edit/${materialList.id}">UPDATE</a></td>
            <td><a href="./materials/del/${materialList.id}">DELETE</a></td>
        </tr>
    </c:forEach>
    <form name = "material" action = "${pageContext.request.contextPath}/materials/add" method="post">
        <tr>
            <td><input title="ID" type="text" name="id"></td>
            <td> <input title="NAME" type="text" name="name"></td>
            <td> <input title="UNIT MEASURE" type="text" name="um"></td>
            <td><input title="UNIT WEIGHT, KG" type="text" name="unitWkg"></td>
            <td><input title="NOTES" type="text" name="notes"></td>
        </tr>

        <tr>
            <td><input type="submit" value="OK"></td>
        </tr>
    </form>
</table>
</body>

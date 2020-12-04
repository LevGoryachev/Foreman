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
            <td><input title="ID" type="text" name="id"></td>
            <td> <input title="NAME" type="text" name="name"></td>
            <td> <input title="UNIT MEASURE" type="text" name="um"></td>
            <td><input title="UNIT WEIGHT, KG" type="text" name="unitWkg"></td>
            <td><input title="NOTES" type="text" name="notes"></td>
            <td></td>
            <td><input type="submit" value="ADD NEW"></td>
        </tr>
    </form>
</table>
<p>
<h3><a href="./">Back to main page</a></h3>
</p>
</body>

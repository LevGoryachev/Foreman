<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Edit material</title>
</head>

<body>
<p><h2>Edit material</h2></p>
<table border="1" cellpadding="5">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>UNIT MEASURE</td>
        <td>UNIT WEIGHT, KG</td>
        <td>NOTES</td>
        <td>Confirm</td>
    </tr>
    <form name = "material" action = "${pageContext.request.contextPath}/materials/upd" method="post" onsubmit="return confirm('Update this?');">
        <tr>
            <td><input title="ID" type="text" name="id" value="${materialEdit.id}" readonly></td>
            <td><input title="NAME" type="text" name="name" value="${materialEdit.name}"></td>
            <td><input title="UNIT MEASURE" type="text" name="um" value="${materialEdit.um}"></td>
            <td><input title="UNIT WEIGHT, KG" type="text" name="unitWkg" value="${materialEdit.unitWkg}"></td>
            <td><input title="NOTES" type="text" name="notes" value="${materialEdit.notes}"></td>
            <td><input type="submit" value="UPDATE"></td>
        </tr>
    </form>
</table>
</body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Edit material</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
    </div>
    <div class="headerleftinfo">
        <h3>Be careful! Changed data will be saved in database after confirmation.</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide/rus" target="_blank">Guide</a>
    </div>
</div>

<div class="mainer">
    <p><h3 class="maineartableinfo">Edit material</h3></p>
    <table border="1" cellpadding="5">
        <tr>
            <td  width="100px">ID</td>
            <td  width="400px">NAME</td>
            <td  width="100px">UNIT MEASURE</td>
            <td  width="100px">UNIT WEIGHT, KG</td>
            <td  width="400px">NOTES</td>
            <td>Confirm</td>
        </tr>
        <form name = "material" action = "${pageContext.request.contextPath}/materials/upd" method="post" onsubmit="return confirm('Update this?');">
            <tr>
                <td width="100px"><input class="smallfield" title="ID" type="text" name="id" value="${materialEdit.id}" readonly></td>
                <td width="400px"><input class="widefield" title="NAME" type="text" name="name" value="${materialEdit.name}"></td>
                <td width="100px"><input class="smallfield" title="UNIT MEASURE" type="text" name="um" value="${materialEdit.um}"></td>
                <td width="100px"><input class="smallfield" title="UNIT WEIGHT, KG" type="text" name="unitWkg" value="${materialEdit.unitWkg}"></td>
                <td width="400px"><textarea cols="50" rows="5" title="NOTES" type="text" name="notes">${materialEdit.notes}</textarea></td>
                <td><input type="submit" value="UPDATE"></td>
            </tr>
        </form>
    </table>
</div>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/materials-editable">Back to List</a>
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
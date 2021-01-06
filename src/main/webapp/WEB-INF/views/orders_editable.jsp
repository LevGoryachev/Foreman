<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Orders</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/construction/${showConstruction.name}">Construction main page</a>
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

<p><a name="top"></a></p>

<div class="mainer">

    <div class="doubledash">
        <p class="maineartableinfo">Construction: ${showConstruction.name}; status: EDITABLE (1)</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="200px">DATE, TIME</td>
                <td width="200px">AUTHOR</td>
                <td colspan="3">ACTION</td>
            </tr>
            <c:forEach items="${changeableList}" var="changeableList">
                <tr>
                    <td width="100px">${changeableList.id}</td>
                    <td width="200px">${changeableList.orderTime}</td>
                    <td width="200px">${changeableList.appUserLastName}</td>
                    <form name = "delete" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/orders/${changeableList.id}/del" method="post" onsubmit="return confirm('Delete this order?');">
                        <td><input type="submit" value="DELETE"></td>
                    </form>
                    <form name = "edit" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/order/${changeableList.id}/orderpositions-edit" method="get">
                        <td><input type="submit" value="EDIT"></td>
                    </form>
                    <form name = "posting" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/orders/${changeableList.id}/posted" method="post" onsubmit="return confirm('Post the order (to supplier)?');">
                        <td><input type="submit" value="POST"></td>
                    </form>
                </tr>
            </c:forEach>
            <form name = "order" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/orders/add" method="post" onsubmit="return confirm('Add new?');">
                <tr>
                    <td colspan="6"><input type="submit" value="ADD NEW ORDER"></td>
                </tr>
            </form>
        </table>
        <p>When you add a new order the form fields (order-id, time, author) will be filled in automatically.</p>
    </div>

    <div class="doubledash">
        <p class="maineartableinfo">Construction: ${showConstruction.name}, status: POSTED to supplier (2)</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="200px">DATE, TIME</td>
                <td width="200px">AUTHOR</td>
                <td width="200px">CONDITION</td>
            </tr>
            <c:forEach items="${postedList}" var="postedList">
                <tr>
                    <td width="100px">${postedList.id}</td>
                    <td width="200px">${postedList.orderTime}</td>
                    <td width="200px">${postedList.appUserLastName}</td>
                    <td width="200px">Posted to supplier</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblickdimmed" href="#">ORDERS</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-acceptable">ACCEPTANCE</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/archive" target="_blank">ARCHIVE</a>
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
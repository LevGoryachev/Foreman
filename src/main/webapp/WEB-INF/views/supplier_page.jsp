<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Orders</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftinfo">
        <a class="buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
        <h3>Be careful! Changed data will be saved in database after confirmation.</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide">Guide</a>
    </div>
</div>

<p><a name="top"></a></p>

<div class="mainer">

    <div class="doubledash">
        <p class="maineartableinfo">Status: POSTED (2). Please, send these materials to construction site and click SEND.</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="300px">CONSTRUCTION</td>
                <td width="200px">DATE, TIME</td>
                <td width="200px">AUTHOR</td>
                <td colspan="2">Status</td>
            </tr>
            <c:forEach items="${postedAllList}" var="postedAllList">
                <tr>
                    <td width="100px">${postedAllList.id}</td>
                    <td width="300px">${postedAllList.constructionName}</td>
                    <td width="200px">${postedAllList.orderTime}</td>
                    <td width="200px">${postedAllList.appUserLastName}</td>
                    <td width="100px">Recieved from construction site</td>
                    <form name = "sending" action = "${pageContext.request.contextPath}/orders/${postedAllList.id}/sent" method="post" onsubmit="return confirm('Have the materials of order been sent?');">
                        <td><input type="submit" value="SEND"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="doubledash">
        <p class="maineartableinfo">Positions of order: </p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="200px">DATE, TIME</td>
                <td width="200px">AUTHOR</td>
                <td colspan="2">Status</td>
            </tr>
            <!-- place for orderpositions-->
        </table>
    </div>

</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-editable">ORDERS</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-acceptable">ACCEPTANCE</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}">Construction page</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
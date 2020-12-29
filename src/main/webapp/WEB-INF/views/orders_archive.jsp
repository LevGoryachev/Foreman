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
        <p class="maineartableinfo">Archive. Orders with status: EXECUTED (4). Materials are in the construction site and confirmed.</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="300px">CONSTRUCTION</td>
                <td width="200px">DATE, TIME</td>
                <td width="200px">AUTHOR</td>
                <td width="100px">Status</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${executedAllList}" var="executedAllList">
                <tr>
                    <td width="100px">${executedAllList.id}</td>
                    <td width="300px">${executedAllList.constructionName}</td>
                    <td width="200px">${executedAllList.orderTime}</td>
                    <td width="200px">${executedAllList.appUserLastName}</td>
                    <td width="100px">Confirmed</td>
                    <form name = "open" action = "${pageContext.request.contextPath}/archive/${executedAllList.id}/orderpositions" method="get">
                        <td><input type="submit" value="OPEN"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="doubledash">
        <p class="maineartableinfo">ORDER-ID: ${orderAttributes.id}, Status: EXECUTED (4), author:  ${orderAttributes.appUserLastName}, construction site: ${orderAttributes.constructionName}</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="300px">MATERIAL</td>
                <td width="100px">QUANTITY</td>
            </tr>
            <c:forEach items="${orderpositionsList}" var="orderpositionsList">
                <tr>
                    <td width="100px">${orderpositionsList.orderId}</td>
                    <td width="300px">${orderpositionsList.materialName}</td>
                    <td width="100px">${orderpositionsList.orderqty}</td>
                </tr>
            </c:forEach>
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
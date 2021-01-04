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
    </div>
    <div class="headerleftinfo">
        <h3>Supplier (Supply Department)</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide" target="_blank">Guide</a>
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
                <td width="100px">AUTHOR</td>
                <td width="100px">CONDITION</td>
                <td colspan="2">ACTION</td>
            </tr>
            <c:forEach items="${postedAllList}" var="postedAllList">
                <tr>
                    <td width="100px">${postedAllList.id}</td>
                    <td width="300px">${postedAllList.constructionName}</td>
                    <td width="200px">${postedAllList.orderTime}</td>
                    <td width="100px">${postedAllList.appUserLastName}</td>
                    <td width="100px">Materials required</td>
                    <form name = "open" action = "${pageContext.request.contextPath}/supplier/${postedAllList.id}/orderpositions" method="get">
                        <td><input type="submit" value="SHOW"></td>
                    </form>
                    <form name = "sending" action = "${pageContext.request.contextPath}/orders/${postedAllList.id}/sent" method="post" onsubmit="return confirm('Have the materials of order been sent?');">
                        <td><input type="submit" value="SEND"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="doubledash">
        <p class="maineartableinfo">ORDER-ID: ${orderAttributes.id}, Status: POSTED (2), author:  ${orderAttributes.appUserLastName}, construction site: ${orderAttributes.constructionName}</p>
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
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/archive">ARCHIVE</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/user-info" target="_blank">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
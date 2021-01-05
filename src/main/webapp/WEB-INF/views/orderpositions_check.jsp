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
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide" target="_blank">Guide</a>
    </div>
</div>

<p><a name="top"></a></p>

<div class="mainer">

    <div class="doubledash">
        <p class="maineartableinfo">ORDER-ID: ${orderAttributes.id}, Status: SENT (3), author:  ${orderAttributes.appUserLastName}, construction site: ${orderAttributes.constructionName}</p>
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
            <tr>
                <form name = "executing" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/orders/${orderAttributes.id}/executed" method="post" onsubmit="return confirm('Have the materials been delivered?');">
                    <td colspan="3"><input type="submit" value="CONFIRM"></td>
                </form>
            </tr>
        </table>
        <p>Materials have been sent to this construction site. Check if delivered materials correspond to positions of order. If it is OK, click CONFIRM.</p>
    </div>

    <div class="doubledash">
        <div class="maineartableinfo">
            <p>Materials (specification) of ${showConstruction.name}.</p>
        </div>

        <table border="1" cellpadding="5">
            <tr>
                <td width="400px">MATERIAL</td>
                <td width="100px">UNIT MEASURE</td>
                <td width="100px">UNIT WEIGHT, KG</td>
                <td width="100px">QUANTITY</td>
            </tr>
            <c:forEach items="${billpositionList}" var="billpositionList">
                <tr>
                    <td width="400px">${billpositionList.entityMaterialName}</td>
                    <td width="100px">${billpositionList.entityMaterialUm}</td>
                    <td width="100px">${billpositionList.entityMaterialUnitWkg}</td>
                    <td width="100px">${billpositionList.billqty}</td>
                </tr>
            </c:forEach>

        </table>
    </div>

</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-editable">ORDERS</a>
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-acceptable">ACCEPTANCE</a>
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
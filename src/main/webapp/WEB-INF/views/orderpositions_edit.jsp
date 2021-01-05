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
        <p class="maineartableinfo">ORDER-ID: ${orderAttributes.id}, Status: EDITABLE (1), author:  ${orderAttributes.appUserLastName}, construction site: ${orderAttributes.constructionName}</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="300px">MATERIAL</td>
                <td width="100px">QUANTITY</td>
                <td>ACTION</td>
            </tr>
            <c:forEach items="${orderpositionsList}" var="orderpositionsList">
                <tr>
                    <td width="100px">${orderpositionsList.orderId}</td>
                    <td width="300px">${orderpositionsList.materialName}</td>
                    <td width="100px">${orderpositionsList.orderqty}</td>
                    <form name = "delete" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/order/${orderpositionsList.orderId}/orderposition/del/${orderpositionsList.materialId}" method="post" onsubmit="return confirm('Delete this?');">
                        <td><input type="submit" value="DELETE"></td>
                    </form>
                </tr>
            </c:forEach>
            <form name = "orderposition" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/order/${showOrderId}/orderposition/add" method="post" onsubmit="return confirm('Add new?');">
                <tr>
                    <input title="construction_id" type="text" name="constructionid" value="${showConstruction.id}" readonly hidden>
                    <td><input title="order_id" type="text" name="orderid" value="${showOrderId}" readonly></td>
                    <td>
                        <select class="widefield" name="materialid">
                            <c:forEach items="${billpositionList}" var="materialList">
                                <option value="${materialList.materialId}">${materialList.entityMaterialName}, <b>available: ${materialList.billqty} ${materialList.entityMaterialUm}</b></option>
                            </c:forEach>
                        </select>
                    </td>
                    <input title="statusDelivered" type="text" name="statusDelivered" value="false" readonly hidden>
                    <td><input title="ORDERQTY" type="text" name="orderqty"></td>
                    <td><input type="submit" value="ADD"></td>
                </tr>
            </form>

        </table>
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
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-editable">ORDERS</a>
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
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
        <p class="maineartableinfo">Construction: ${showConstruction.name}; Status: SENT (3). Materials have been sent to this construction site.</p>
        <table border="1" cellpadding="5">
            <tr>
                <td width="100px">ORDER ID</td>
                <td width="200px">DATE, TIME</td>
                <td width="200px">AUTHOR</td>
                <td width="100px">STATUS</td>
                <td>ACTION</td>
            </tr>
            <c:forEach items="${sentList}" var="sentList">
                <tr>
                    <td width="100px">${sentList.id}</td>
                    <td width="200px">${sentList.orderTime}</td>
                    <td width="200px">${sentList.appUserLastName}</td>
                    <td width="100px">Materials are expected</td>
                    <form name = "open" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/order/${sentList.id}/orderpositions-check" method="get">
                        <td><input type="submit" value="OPEN"></td>
                    </form>
                </tr>
            </c:forEach>
        </table>
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
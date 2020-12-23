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
    <table border="1" cellpadding="5">
        <tr>
            <td width="100px">ID</td>
            <td width="400px">CONSTRUCTION</td>
            <td width="200px">AUTHOR</td>
            <td colspan="2">ACTION</td>
        </tr>
        <c:forEach items="${changeableList}" var="changeableList">
            <tr>
                <td width="100px">${changeableList.id}</td>
                <td width="400px">${changeableList.constructionId}</td>
                <td width="200px">${changeableList.appUserId}</td>
                <form name = "delete" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/orders/${changeableList.id}/del" method="post" onsubmit="return confirm('Delete this?');">
                    <td><input type="submit" value="DELETE"></td>
                </form>
            </tr>
        </c:forEach>
        <form name = "order" action = "${pageContext.request.contextPath}/construction/${showConstruction.name}/orders/add" method="post" onsubmit="return confirm('Add new?');">
            <tr>
                <td colspan="4"><input type="submit" value="ADD NEW"></td>
            </tr>
        </form>
    </table>
</div>

<p><a name="bottom"></a></p>

<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="#top">PageUP</a>
        <a class="linearbutton buttonblick" href="#bottom">PageDOWN</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Back to Constructions</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
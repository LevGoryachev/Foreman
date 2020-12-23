<!DOCTYPE html>
<html>

<head>
    <title>${showConstruction.name}</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftinfo">
        <a class="buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
        <h3>You are in ${showConstruction.name} construction</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide">Guide</a>
    </div>
</div>


<div class="mainer">

    <div class="mainearblock">
        <h3>General information:</h3>
        <table border="1" cellpadding="5">
            <tr>
                <td width="200px">Construction site - ${showConstruction.name}</td>
                <td width="200px">code-number: ${showConstruction.codenumber}</td>
            </tr>
        </table>
        <h3>Description:</h3>
        <table>
            <td width="400px">${showConstruction.description}</td>
        </table>

    </div>

    <div class="mainearblock">
        <p>
            <a class="mainearbutton buttonblick" href="#">NEW ORDER</a>
        </p>
        <p>
            Click to create a new order.
        </p>
        <p>
            Creating new orders is also available in "Orders".
        </p>

    </div>


</div>
<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-editable">ORDERS</a>
        <a class="linearbutton buttonblick" href="../construction/${showConstruction.name}/materials">BILL of materials</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>
</body>

</html>
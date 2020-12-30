<!DOCTYPE html>
<html>

<head>
    <title>${showConstruction.name}</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
        <a class="linearbutton buttonblickdimmed" href="#">Construction main page</a>
    </div>
    <div class="headerleftinfo">
        <h3>Construction main page (${showConstruction.name})</h3>
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
        <table align="center" border="1" cellpadding="5">
            <tr>
                <td width="300px">Construction site - ${showConstruction.name}</td>
                <td width="200px">code-number: ${showConstruction.codenumber}</td>
            </tr>
        </table>
        <h3>Description:</h3>
        <table align="center">
            <td  align="left" width="500px">${showConstruction.description}</td>
        </table>

    </div>

    <div class="mainearblock">
        <p>
            <a class="mainearbutton buttonblick" href="../construction/${showConstruction.name}/materials">BILL of materials</a>
            <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-editable">ORDERS</a>
            <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/construction/${showConstruction.name}/orders-acceptable">ACCEPTANCE</a>
        </p>
        <p>
            BILL - is a specification of this construction (provided by <b>project</b>)
        </p>
        <p>
            ORDERS - to order the materials (materials are provided by <b>specification</b>)
        </p>
        <p>
            ACCEPTANCE - to confirm the delivered materials (which are provided by <b>orders</b>)
        </p>
    </div>

</div>
<div  class="footer">
    <div class="footerleftbtns">
        <a class="linearbutton buttonblick" href="">EDIT CONSTRUCTION</a>
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>
</body>

</html>
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
    </div>
    <div class="headerleftinfo">
        <h3>Information about user</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/guide" target="_blank">Guide</a>
    </div>
</div>


<div class="mainer">

    <div class="mainearblock">
        <h3>Account information:</h3>
        <table align="center" border="1" cellpadding="5">
            <tr>
                <td width="150px"><b>${userInfo.firstName}</b></td>
                <td width="150px"><b>${userInfo.middleName}</b></td>
                <td width="150px"><b>${userInfo.lastName}</b></td>
            </tr>
            <tr>
                <td colspan="3" align="left">login: ${userInfo.login}</td>
            </tr>
            <tr>
                <td colspan="3" align="left">email: ${userInfo.email}</td>
            </tr>
        </table>
        <h3>Credentials:</h3>
        <table align="center">
            <td  align="left" width="500px">${userInfo.entityRoleRank}</td>
        </table>

    </div>

</div>
<div  class="footer">
    <div class="footerleftbtns">
    </div>
    <div class="footerightbtns">
        <a class="linearbutton buttonblickdimmed" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>
</body>

</html>
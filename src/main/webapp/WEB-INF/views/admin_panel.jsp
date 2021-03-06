<!DOCTYPE html>
<html>

<head>
    <title>Admin</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
    </div>
    <div class="headerleftinfo">
        <h1>FOREMAN admin panel</h1>
        <p>Roles only available: ADMIN, CHIEF, EMPLOYEE, SUPPLIER</p>
    </div>
    <div class="headerightbtns">
    </div>
</div>

<div class="mainer">
    <p>
        <a class="mainearbutton buttonblicklighted" href="${pageContext.request.contextPath}/" target="_blank">APP main page</a>
        <a class="mainearbutton buttonblicklighted" href="${pageContext.request.contextPath}/admin/roles">Roles</a>
        <a class="mainearbutton buttonblicklighted" href="${pageContext.request.contextPath}/admin/users-editable">Users</a>
    </p>
</div>

<div  class="footer">
    <div class="footerleftbtns">
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
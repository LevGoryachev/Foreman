<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Access Denied</title>
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
    </div>
    <div class="headerleftinfo">
        <h1>FORBIDDEN</h1>
        <p></p>
    </div>
    <div class="headerightbtns">
    </div>
</div>

<div class="mainer">
    <p><h2>Access denied!!!</h2></p>
    <p><h2>Sorry, you have no access to view this page. Please, go back.</h2></p>
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
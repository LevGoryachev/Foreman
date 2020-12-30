<!DOCTYPE html>
<html>

<head>
    <title>Title</title>
    <meta charset="UTF-8" />
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body class="presentational">

<div>
    <h1>Welcome to FOREMAN!</h1>
    <h3>supply service for building construction</h3>
</div>

<div class="mainer">
    <p>
        <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/guide" target="_blank">Guide</a>
    </p>
    <p>
        <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/supplier">SUPPLIER</a>
        <a class="mainearbutton buttonblick" href="${pageContext.request.contextPath}/archive">ARCHIVE</a>
    </p>
    <p>
        <a class="mainearbutton buttonblick" href="#">Logout</a>
    </p>

</div>

<div id="copyrightline">
    <p>Foreman createdByLevGoryachev();</p>
</div>

</body>


</html>
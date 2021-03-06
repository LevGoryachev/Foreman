<!DOCTYPE html>

<head>
    <title>Guide</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${pageContext.request.contextPath}/sources/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="header">
    <div class="headerleftbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/index.jsp">Main page</a>
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/guide/rus">RUS</a>
        <a class="linearbutton buttonblickdimmed" href="">ENG</a>
    </div>
    <div class="headerleftinfo">
        <h3>Guide</h3>
    </div>
    <div class="headerightbtns">
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/constructions">Constructions</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/materials">Materials</a>
        <a class="linearbutton buttonblickdimmed" href="#">Guide</a>
    </div>
</div>

<div class="mainer">
    <h1>FOREMAN</h1>
    <h3>supply service for building constructions</h3>
    <div class="maineartableinfo">
        <p>The FOREMAN is a web application for organizations and individual entrepreneurs and people which are involved in building construction.</p>
        <p>Basic features:</p>
        <p><b>Using the internet browser, an employee (construction site) creates an order (list of building materials). And also using the internet browser, another employee (supply department) gets this order and should organise the delivery.
        After that, the employee of the construction site goes to the acceptance page and confirms the order. In its turn, APP does inventory accounting - recalculates materials and saves executed orders in archive.
        C-Level is able to control the process and correct all the data (construction sites, material catalog, specifications, etc.)</b></p>
        <p>This is a demo version for educational purposes. It will be possible to use this APP for real activity if only appropriate improvements are done. Database contains experimental data which are allowed to update.</p>
        <h3>To try:</h3>
        <p>You can try how it works and organize a basic presentation using the example of communication process between two workplaces (description below).</p>
        <p>Follow these steps to try the APP (or organize a presentation):</p>
        <ul>
            <li>Create two workplaces (using two different browsers or PC): log in as a user that has role EMPLOYEE or CHIEF (<b>workplace-1</b> in the first browser or PC)
                and log in as a user which has role SUPPLIER (<b>workplace-2</b> in the second browser or PC).
                Use trial authorizations from login page (top left).</li>
            <li><b>At workplace-1:</b></li>
                <ul>
                    <li>Go to: Constructions -> any link in the list -> Orders, push the button ADD NEW ORDER. New order will be created.</li>
                    <li>Push the button EDIT and fill out the form (choose material and set quantity). Go back to the page Orders (light button Orders at the bottom left).</li>
                    <li>Push the button POST. The Order will be moved from left part to right part of page and also supplier will be able to view it at workplace-2.</li>
                    <li>Go to: ACCEPTANCE (push the button ACCEPTANCE).</li>
                </ul>
            <li><b>At workplace-2:</b></li>
                <ul>
                    <li>Refresh the browser page for possibility to view the Order (you are in SUPPLIER section).</li>
                    <li>Push the button SHOW for possibility to view the list of materials of this Order (in the right part of page).</li>
                    <li>Push the button SEND. The Order will be moved to acceptance and removed from the list of SUPPLIER section.
                        Also first user (workplace-1) will be able to view it in ACCEPTANCE page.</li>
                </ul>
            <li><b>At workplace 1:</b></li>
                <ul>
                    <li>Refresh the browser page for possibility to view the Order (you are in ACCEPTANCE section).</li>
                    <li>Push the button OPEN for possibility to view the list of materials of this Order.</li>
                    <li>Push the button CONFIRM and the APP will redirect you back to ACCEPTANCE section. The Order will be moved to archive section
                        and removed from the list of ACCEPTANCE section.
                        In the right part of page (specifications) the inventory will be decreased.</li>
                </ul>
            <li>Now, the order is in ARCHIVE section. Users with any roles have access to ARCHIVE section and can observe executed orders there.</li>
        </ul>
        <p>For more details see Manual.</p>
        <h3><b>MANUAL</b></h3>
        <h3><b>...sorry, we are working on it...</b></h3>
    </div>
</div>

<div  class="footer">
    <div class="footerleftbtns">
        <p><b>For developers: <a href="https://github.com/LevGoryachev/Foreman" target="_blank">https://github.com/LevGoryachev/Foreman</a></b></p>
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
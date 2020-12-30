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
    <h1>Welcome to FOREMAN</h1>
    <h3>supply service for building construction</h3>
    <div class="maineartableinfo">
        <p>Веб-приложение FOREMAN предназначено для использования внутри организации, а так же индивидуальными предпринимателями и другими лицами, занятыми в строительстве.</p>
        <p>Основные функции:</p>
        <p><b>Сотрудник стройки логинится через браузер и заказывает материалы. Сотрудник отдела снабжения логинится через браузер, видит заказ и высылает материалы на стройку.
        Затем, сотрудник стройки заходит через браузер в соответствующий раздел приложения и подтверждает получение (остатки материалов вычитаются, заказ сохраняется в архиве).</b></p>
        <p>Данная версия является демонстрационной для образовательных целей. База заполнена учебными данными. Эксперементировать разрешается.</p>
        <p>В разделе <b>MATERIALS</b> описаны строительные материалы (можно редактировать, удалить или создать материал: EDIT LIST -> заполните поля -> ADD).
        Это главный каталог, и приложение позволит работать только с теми материалами, которые в нём описаны.</p>
        <p>В разделе <b>CONSTRUCTIONS</b> перейдите на соответствующую стройку (можно редактировать, удалить или создать стройку: EDIT LIST -> заполните поля -> ADD)</p>
        <p>На странице стройки перейдите в раздел спецификаций <b>BILL of materials</b> - перечень и количество материалов, предусмотренных для данной стройки.
        (отредактировать: EDIT LIST). Заказывать у снабженца по данной стройке можно только те материалы, которые присутствуют в спецификации по этой стройке (система не позволит выбрать иные материалы, а также
        превысить количество по спецификации).</p>
        <p>Заказы (<b>ORDERS</b>) меют 4 статуса. Редактировать можно только в первом статусе.</p>
        <ul>
            <li>1.EDITABLE - можно редактировать.</li>
            <li>2.POSTED - размещен (отправлен снабженцу). Становится виден в правой части окна сотрудника стройки, а также на странице снабженца (кнопка <b>SUPPLIER</b>)</li>
            <li>3.SENT - когда материалы отправлены на стройку, заказ становится виден в разделе ACCEPTANCE (приёмка).</li>
            <li>4.EXECUTED - в архиве. На стройке материал принят по факту и заказ подтверждён на стройке.</li>
        </ul>
        <p>В разделе <b>ORDERS</b> (левая часть) добавьте заказ (поля Order-ID, Time, Author (текущий пользователь) заполняются автоматически).
        Нажмите EDIT чтобы перейти на редактирование позиций (материалов и их количества). Когда заказ будет готов, нажмите POST.
        После этого заказ перейдёт в статус 2 и станет виден снабженцу.</p>
        <p>Снабженец (раздел <b>SUPPLIER</b>) по факту отправки материалов на стройку по этому заказу нажимает SEND. После этого заказ перейдёт в статус 3 и
        станет виден в разделе ACCEPTANCE (приёмка).</p>
        <p>В разделе <b>ACCEPTANCE</b> (левая часть) нажмите OPEN соответствующего заказа, чтобы проверить, соответствие полученных по факту
        материалов. Чтобы подтвердить заказ, нажмите CONFIRM. После этого заказ переходит в статус 4 (архив).
        В правой части отображается спецификация и там можно увидеть уменьшение остатков по позициям материалов при подтверждении.
        </p>
        <p>В приложении имеется <b>ADMIN</b> панель (маппинг /admin), в ней можно добавлять, редактировать и удалять пользователей и менять роли.</p>
        <p>Роли (пока ограничения доступа отключены, находятся в процессе настройки):</p>
        <ul>
            <li>1.ADMIN - может всё.</li>
            <li>2.CHIEF - может всё, но недоступен маппинг /admin</li>
            <li>3.EMPLOYEE - недоступы маппинги /admin, /supplier; недоступно изменение строек, каталога и спецификаций (может только смотреть). Может работать с заказами.</li>
            <li>4.SUPPLIER - не может ничего, кроме /supplier и /archive</li>
        </ul>
        <p>В настоящий момент security отключен (в процессе настройки), кнопка Account info не работает. Приложение ещё пока не работает с русскими символами,
        при попытке внести в базу русские символы будет работать некорректно (в процессе настройки).</p>
        <p>С наступающим 2021!!!</p>
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
        <a class="linearbutton buttonblick" href="#">Account info</a>
        <a class="linearbutton buttonblick" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>

</body>

</html>
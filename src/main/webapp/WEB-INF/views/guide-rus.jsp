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
        <a class="linearbutton buttonblickdimmed" href="#">RUS</a>
        <a class="linearbutton buttonblicklighted" href="${pageContext.request.contextPath}/guide/eng">ENG</a>
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
        <p>Веб-приложение FOREMAN предназначено для использования внутри организации, а так же индивидуальными предпринимателями и другими лицами, занятыми в строительстве.</p>
        <p>Основные функции:</p>
        <p><b>Сотрудник стройки логинится через браузер и заказывает материалы (формирует заказ). Сотрудник отдела снабжения логинится через браузер, видит заказ и высылает материалы на стройку.
        Затем, сотрудник стройки заходит через браузер в соответствующий раздел приложения и подтверждает получение (остатки материалов вычитаются, заказ сохраняется в архиве).
        Руководители стройки могут контролировать этот процесс и изменять основные данные (строительные объекты, каталог материалов, спецификации и т.д.)</b></p>
        <p>Данная версия является демонстрационной для образовательных целей. Многие моменты упрощены и для реального использования требуются некоторые доработки. База заполнена учебными данными, с которыми можно экспериментировать.</p>
        <h3>Попробовать:</h3>
        <p>Для пробной работы и минимальной демонстрации функций приложения (например, взаимодействие между двумя рабочими местами) проделайте следующее:</p>
        <ul>
            <li>Создайте два рабочих места: залогиньтесь как пользователь с ролью EMPLOYEE или CHIEF (<b>workplace 1</b>), а на другом браузере или компьютере как пользователь с ролью SUPPLIER (<b>workplace 2</b>).
            Пробные логины и пароли слева вверху на странице авторизации.</li>
            <li><b>На workplace 1:</b></li>
                <ul>
                    <li>перейдите: Constructions -> страница любой стройки -> Orders, нажмите ADD NEW ORDER. Появится новый заказ.</li>
                    <li>нажмите EDIT и наполните заказ материалами с указанием количества. Перейдите назад на страницу с заказами (подсвеченная кнопка Orders внизу).</li>
                    <li>нажмите POST. Заказ перейдет из левой таблицы в правую (он отправлен в работу снабженцу).</li>
                    <li>перейдите в раздел ACCEPTANCE (кнопка внизу).</li>
                </ul>
            <li><b>На workplace 2:</b></li>
                <ul>
                    <li>обновите страницу браузера (вы должны быть в разделе SUPPLIER). Появится заказ.</li>
                    <li>Нажмите SHOW и в правом окне отобразится список материалов, которые он содержит.</li>
                    <li>Нажмите SEND и заказ пропадет из списка (отправится на стройку для приёмки).</li>
                </ul>
            <li><b>На workplace 1:</b></li>
                <ul>
                    <li>обновите страницу браузера (вы должны быть в разделе ACCEPTANCE). Появится заказ.</li>
                    <li>нажмите кнопку OPEN, чтобы просмотреть материалы и подтвердить заказ (кнопка Confirm).</li>
                    <li>после нажатия кнопки CONFIRM, произойдёт переход обратно в раздел ACCEPTANCE, принятый заказ пропадёт из списка,
                        а в правой части окна произойдет уменьшение остатков по позициям материалов (спецификации).</li>
                </ul>
            <li>Теперь подтвержденный заказ находится в разделе ARCHIVE, куда можно перейти как с <b>workplace 1</b>, так и с <b>workplace 2</b>.</li>
        </ul>
        <p>Полный функционал описан в Manual.</p>
        <h3><b>MANUAL</b></h3>
        <h3><b>AUTHENTICATION</b></h3>
        <p>Для начала работы необходимо ввести логин и пароль. Пользователей для пробной работы (логины и пароли) можно найти на /customlogin или создать свои (под ролью ADMIN).
        На форму ввода (/customlogin) могут попасть только неаутентифицированные пользователи (нажмите logout).</p>
        <p>При входе в приложение происходят автоматические редиректы, в зависимости от роли пользователя:</p>
        <ul>
            <li>ADMIN - на админ-панель.</li>
            <li>CHIEF, EMPLOYEE - на главную страницу.</li>
            <li>SUPPLIER - на страницу отдела снабжения.</li>
        </ul>
        <p>Для удобства навигации, все пользователи имею доступ и могут перейти на главную страницу приложения, вне зависимости от роли.</p>
        <h3>Раздел <b>MATERIALS</b></h3>
        <p>В разделе <b>MATERIALS</b> описаны строительные материалы. Можно редактировать, удалять или создавать: кнопка EDIT LIST. Пользователи с ролями: ADMIN, CHIEF могут изменять; EMPLOYEE только просматривать.
        Это главный каталог, и приложение позволит работать только с теми материалами, которые в нём описаны.</p>
        <h3>Раздел <b>CONSTRUCTIONS</b></h3>
        <p>Раздел <b>CONSTRUCTIONS</b>: содержит список строек (объектов строительства) со ссылками на их страницы. Стройки также можно редактировать, удалять или создавать: кнопка EDIT LIST.
        Пользователи с ролями: ADMIN, CHIEF могут изменять; а с ролью EMPLOYEE только просматривать.</p>
        <p>В этом разделе (<b>CONSTRUCTIONS</b>) перейдите на соответствующую стройку.</p>
        <p>На странице стройки, в свою очередь, перейдите в подраздел спецификаций <b>BILL of materials</b> - перечень и количество материалов, предусмотренных для данной стройки (спецификации).
        Отредактировать: EDIT LIST. Заказывать у снабженца по данной стройке можно только те материалы, которые присутствуют в спецификации по этой стройке (система не позволит заказать иные материалы, а также
        превысить количество по данной спецификации). Пользователи с ролями: ADMIN, CHIEF могут изменять; EMPLOYEE только просматривать.</p>
        <p>Подраздел <b>ORDERS</b> предназначен для формирования заказа и отправки его снабженцу.</p>
        <p>Подраздел <b>ACCEPTANCE</b> предназначен для приёмки материалов, которые снабженец прислал (сверить с обработанным заказом и подтвердить).</p>
        <p>В данные подразделы (ORDERS, ACCEPTANCE) пользователи с ролями ADMIN, CHIEF и EMPLOYEE имеют полный доступ.</p>
        <p>Заказы (<b>ORDERS</b>) имеют 4 статуса. Редактировать можно только в первом статусе.</p>
        <ul>
            <li>1.EDITABLE - можно редактировать.</li>
            <li>2.POSTED - размещен (отправлен снабженцу). Становится виден в правой части окна сотрудника стройки, а также на странице снабженца (кнопка <b>SUPPLIER</b>).</li>
            <li>3.SENT - когда материалы отправлены на стройку, заказ становится виден в подразделе ACCEPTANCE (приёмка).</li>
            <li>4.EXECUTED - в архиве. На стройке материал принят по факту и заказ подтверждён на стройке.</li>
        </ul>
        <p>В подразделе <b>ORDERS</b> (левая часть) добавьте заказ (поля Order-ID, Time, Author (текущий пользователь) заполняются автоматически).
        Нажмите EDIT чтобы перейти на редактирование позиций (материалов и их количества). Когда заказ будет готов, нажмите POST.
        После этого заказ перейдёт в статус 2 и станет виден снабженцу.</p>
        <h3>Раздел <b>SUPPLIER</b> (для отдела снабжения).</h3>
        <p>Предназначен для обработки заказов, которые направляются в отдел снабжения.</p>
        <p>При входе в приложение с ролью SUPPLIER происходит автоматический редирект на страницу отдела снабжения.</p>
        <p>На странице отдела снабжения отображаются заказы сразу по всем существующим стройкам (в отличие от страницы стройки, где заказы только по данной стройки.)</p>
        <p>Снабженец (раздел <b>SUPPLIER</b>) по факту отправки материалов на стройку по этому заказу нажимает SEND. После этого заказ перейдёт в статус 3 и
        станет виден в подразделе ACCEPTANCE (приёмка на стройке). У снабженца в окне данный заказ исчезает.</p>
        <p>В подразделе ACCEPTANCE соответствующей стройки (левая часть) нажмите OPEN соответствующего заказа, чтобы проверить, соответствие полученных по факту
        материалов. Чтобы подтвердить заказ, нажмите CONFIRM. После этого заказ переходит в статус 4 (архив).
        В правой части отображается спецификация и там можно увидеть уменьшение остатков по позициям материалов при подтверждении.
        </p>
        <h3>Раздел <b>ARCHIVE</b></h3>
        <p>Предназначен для просмотра выполненных и подтвержденных заказов.</p>
        <h3><b>ADMIN PANEL</b></h3>
        <p>В приложении имеется админ-панель (кнопки и ссылки на админ-панель не предусмотрены; используйте маппинг /admin), где можно добавлять, редактировать и удалять пользователей и менять роли. Доступ в админ-панель - только с ролью ADMIN.</p>
        <p>При входе в приложение с ролью ADMIN происходит автоматический редирект на админ-панель.</p>
        <p>Роли и полномочия пользователей:</p>
        <ul>
            <li>1.ADMIN (администратор) - может всё.</li>
            <li>2.CHIEF (начальник) - может всё, но недоступен маппинг /admin</li>
            <li>3.EMPLOYEE (работник) - недоступны маппинги /admin, /supplier; недоступно изменение строек, каталога и спецификаций (может только смотреть). Может работать с заказами.</li>
            <li>4.SUPPLIER (снабженец) - не может ничего, кроме просмотра и действий на маппингах /supplier и /archive</li>
        </ul>
        <p>При изменении или добавлении паролей пользователей, их следует шифровать с использованием <b><a href="https://bcrypt-generator.com/" target="_blank">BCryptEncoder</a> (12 раундов)</b>.</p>
        <p>Приложение ещё пока не работает с русскими символами, при попытке внести в базу русские символы может работать некорректно (в процессе настройки).</p>
        <p>С новым 2021 годом!!!</p>
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
# Foreman
Foreman is a web-application for organizing remote supplying.
Employees who are located on construction sites can use this web-application to create and send orders on-line. In its turn, construction supply managers are able to recieve the orders and initiate the delivery.

Spring-Web-MVC, Spring JDBC, Servlet-API

<h2>1. Structure</h2>
<h3>ru/goryachev/foreman/app</h3>
<p><b>AppInit.java</b> - organizes ServletContext initialization (extends AbstractAnnotationConfigDispatcherServletInitializer), determines the classes of configuration (JdbcConfig, DAOConfig, ServiceConfig, WebConfig).</p>
<h3>ru/goryachev/foreman/config</h3>
<p> The classes of configurations (implementations of WebMvcConfigurer - org.springframework.web.servlet.config.annotation)
</p>

<p><b>JDBCConfig.java</b> - configures connection to database: beans JdbcTemplate, DataSource (dependency: spring-jdbc).</p>
<p>Use appropriate driver to connect to your database. In this example -  "org.postgresql.Driver", dependency: compile group: 'postgresql', name: 'postgresql', version: '9.0-801.jdbc4' from MavenCentral</p>
<p><b>Due to the fact that connection uses appUser name, appUser password, JDBCConfig.java class is NOT available. You can see JDBCConfigSample.java which is absolutely identical - you can use it and set your properties (take steps to hide confidential information).</b></p>
<p><b>DAOConfig.java</b> - configures data access object layer, contains beans of DAO.</p>
<p><b>ServiceConfig.java</b> - configures service layer, contains beans of services.</p>
<p><b>WebConfig.java</b> - sets ViewResolver (JSP pages), bean: InternalResourceViewResolver.</p>
<p>You can use other tool to generate text output based on templates, e.g. freemarker (dependency: org.freemarker in MavenCentral)</p>

<h3>ru/goryachev/foreman/controllers</h3>
<p><b>MainController.java</b> - mapping: </p>
<p>/login;</p>
<p>/registration;</p>
<p>/constructions - page that displays the list of constructions (construction sites, projects).</p>
<p><b>InternalController.java</b> - mapping: </p>
<p>/construction/main - the main page of construction (general information) with links;</p>
<p>/construction/materials - page that displays the list of materials which were included in specification of current construction (bill).</p>
<p>/construction/orders - page that displays the list of orders of current construction.</p>
<p><b>OrderController.java</b>-mapping:</p>
<p>/construction/order  - page that displays the order form with appropriate information (appUser, date) and with list of ordered materials.</p>
<h3>ru/goryachev/foreman/dao</h3>
<p>interface DataAccessible;</p>
<p>implementations of DataAccessible - dao classes (for each entity) contain methods with SQL queries</p>
<p>implementations of RowMapper (springframework.jdbc.core.RowMapper) - mappers for each dao class</p>
<h3>ru/goryachev/foreman/entities</h3>
<p>interface-marker Entity;</p>
<p>implementations of Entity that correspond to the entities of database</p>
<p>Setters (only for reference types) contain 'if' statement to check a null (get rid of nulls in case of nulls from database).</p>
<h3>ru/goryachev/foreman/services</h3>
<p>interface Applicable;</p>
<p>implementations of Applicable - classes of service logic (for each entity)</p>
<p>These classes exchange the data with <b>dao</b> layer and <b>controllers</b>.</p>

<h2>2. Database</h2>
<p>To create database use the files (you can customize it):</p>
<p>DDLscript_v2.0-db.md</p>
<p>SPscript_v2.0-db.md (plpgsql stored procedures)</p>
<p>The database contains:</p>
<p>tables: 7</p>
<p>stored procedures: 2</p>
<p>For connection to database use an appropriate driver. In this example - "org.postgresql.Driver", PostgreSQL version 13, but you can use different (see <b>1.Structure: ru/goryachev/foreman/config - about JDBCConfig.java).</b></p>

<h3>Database scheme</h3>

![DBscheme_v2 0-db](https://appUser-images.githubusercontent.com/61917893/98996869-a6b7cf80-2544-11eb-90aa-3e85d40af57d.jpg)
<p></p>
<p>Free software.  Intended for educational purposes. Lev Goryachev.</p>

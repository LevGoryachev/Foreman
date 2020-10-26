# Foreman
Foreman is a web-application for organizing remote supplying.
Employees who are located on construction sites can use this web-application to create and send orders on-line. In its turn, construction supply managers are able to recieve the orders and initiate the delivery.

Spring-Web-MVC, Spring JDBC, Servlet-API

<h2>1. Structure</h2>
<h3>ru/goryachev/foreman/app</h3>
<p><b>AppInit.java</b> - organizes ServletContext initialization (extends AbstractAnnotationConfigDispatcherServletInitializer),the method getServletConfigClasses() returns classes WebConfig, JdbcConfig and SpringConfig.</p>
<h3>ru/goryachev/foreman/config</h3>
<p><b>WebConfig.java</b> - configurer that implements WebMvcConfigurer, sets ViewResolver (JSP pages).</p>
<p><b>JDBCConfig.java</b> - configurer that implements WebMvcConfigurer and configures connection to database, using  beans JdbcTemplate, DataSource (dependency: spring-jdbc).</p>
<p>Use appropriate driver to connect to your database. In this example -  "org.postgresql.Driver", dependency: compile group: 'postgresql', name: 'postgresql', version: '9.0-801.jdbc4' from MavenCentral</p>
<p><b>Due to the fact that connection uses user name, user password, this class is NOT available. You can see JDBCConfigTemplate.java, you can use it and set your properties and take steps to hide confidential information.</b></p>
<p><b>SpringConfig.java</b> - configurer that implements WebMvcConfigurer for additional configuration.</p>
<h3>ru/goryachev/foreman/controllers</h3>
<p><b>MainController.java</b> - works with: </p>
<p>/login;</p>
<p>/registration;</p>
<p>/constructions - page that displays the list of constructions (construction sites, projects).</p>
<p><b>InternalController.java</b> - works with: </p>
<p>/construction/main - the main page of construction (general information) with links;</p>
<p>/construction/materials - page that displays the list of materials which were included in specification of current construction (bill).</p>
<p>/construction/orders - page that displays the list of orders of current construction.</p>
<p><b>OrderController.java</b>- works with:</p>
<p>/construction/order  - page that displays the order form with appropriate information (user, date) and with list of ordered materials.</p>
<h3>ru/goryachev/foreman/dao</h3>
<p>Contains interface DataAccessible and appropriate classes for implementation.</p>
<h3>ru/goryachev/foreman/entities</h3>
<p>Contains classes of entities that correspond to the entities of database. Include fields, getters, setters.</p>
<h3>ru/goryachev/foreman/services</h3>
<p>Contains classes of service logic. These classes use the data which are obtained from the database.</p>

<h2>2. Database</h2>
<p>To create database use the file DDLscript_v1.0-db.md (you can customize it).</p>
<p>For connection to database use an appropriate driver. In this example - "org.postgresql.Driver", but you can use different (see <b>1.Structure: ru/goryachev/foreman/config - about JDBCConfig.java).</b></p>
<h3>Database scheme</h3>

![DBscheme_v1 0-db](https://user-images.githubusercontent.com/61917893/97116617-6ddbc600-170f-11eb-94f4-f646b5e49360.jpg)

<p>Free software.  Intended for educational purposes. Lev Goryachev.</p>

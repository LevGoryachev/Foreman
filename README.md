# Foreman
Foreman is a web-application for supply service (construction industry).
Employees who are located on construction sites can use it to create and send orders on-line.
Construction supply managers are, in their turn, able to recieve the orders and initiate the delivery of materials.
<p><b>Summary: Java 11, Spring-Web-MVC, Spring JDBC, Spring Security, JSP</b></p>
<p><b>DB: relational database with stored procedures(PostgreSQL)</b></p>

<p>An example launched on: <a href="https://foreman-one.herokuapp.com" target="_blank">https://foreman-one.herokuapp.com</a> (first launch can take about 20-30 sec.)
Use trial authorizations (login page) and see <b>Guide</b>.</p>

<p><b>Contents:</b></p>
<ul>
<li><p><a href="#description"><b>1. Description</b></a></p></li>
<li><p><a href="#structure"><b>2. Structure</b></a></p></li>
<li><p><a href="#gui"><b>3. Graphical user interface</b></a></p></li>
<li><p><a href="#database"><b>4. Database</b></a></p></li>

</ul>

<p><a name="description"></a></p>
<h2>1. Description</h2>
<p>The operation of Foreman web-app is entirely based on data from database (see <b>4.Database</b>) and the GUI is completely based on Java server pages (JSP - see <b>3.GUI</b>).
The security settings are controlled by SpringSecurity (permissions, redirects, etc.).</p>
<p>Before authorization it is possible to view only the login page.
When a user is logged in, one will be redirected to the appropriate page (that depends on role).</p>

<p>As an example, if users have common roles (CHIEF, EMPLOYEE) they will be redirected to the main page (index.jsp).</p>

index.jsp
![screen_1](https://user-images.githubusercontent.com/61917893/103707527-d1ac2600-4fbf-11eb-9287-f2f870a80530.jpg)

<p>Basically, the web-pages contain presented forms with data to view and edit.</p>
<p>E.g., if user makes a new entry in the form "list of Constructions" the entry will be saved in the appropriate database table,
and the form "list of Constructions" will get a link for a new Construction page
(custom mapping will be formed - ConstructionSiteController.java (see <b>2.Structure</b>) will work with it),
 and user will be able to go to this page (construction_page.jsp).</p>
<p>Page of construction site displays custom context (data) and has control buttons (links to other functional pages).</p>

construction_page.jsp
![screen_2](https://user-images.githubusercontent.com/61917893/103707537-d5d84380-4fbf-11eb-96b1-ea3069c5fd46.jpg)

<p>E.g., the button "Orders" leads to the page for creating and modifying orders (orders_editable.jsp).
Lists of orders (taken from the database and reworked by service layer) are presented in the form of this page.</p>

orders_editable.jsp
![screen_3](https://user-images.githubusercontent.com/61917893/103707546-d83a9d80-4fbf-11eb-9a27-fca8b05ed48d.jpg)

<p>Generally, Foreman web-app provides for CRUD operations in database by different users
 (one user creates, the other reads - thus the way of exchanging data).</p>

<p><a name="structure"></a></p>
<h2>2. Structure</h2>

![STRUCTURE_Scheme](https://user-images.githubusercontent.com/61917893/104650332-14a88080-56c7-11eb-890c-75578780d38d.jpg)

<h3>ru/goryachev/foreman/app</h3>
<ul>
<li><p><b>AppInit.java</b> - ServletContext initialization (extends AbstractAnnotationConfigDispatcherServletInitializer), determines the classes of configuration (JdbcConfig, DAOConfig, ServiceConfig, WebConfig, SecurityConfig).</p></li>
<li><p><b>SecurityInit.java</b> - Spring Security initialization (extends AbstractSecurityWebApplicationInitializer)</p></li>
</ul>

<h3>ru/goryachev/foreman/config</h3>
<p> The classes of configurations (implementations of WebMvcConfigurer - org.springframework.web.servlet.config.annotation):
</p>

<ul>
<li><p><b>JDBCConfig.java</b> - configures connection to database: beans JdbcTemplate, DataSource (dependency: spring-jdbc).</p>
<p>Use appropriate driver to connect to your database. In this example -  "org.postgresql.Driver", dependency: compile group: 'postgresql', name: 'postgresql', version: '9.0-801.jdbc4' from MavenCentral.</p>
<p>There are three variables <b>username</b>, <b>password</b> and <b>databaseUrl</b> which are provided from Spring Datasource and they change their values depending on the environment (default values (for local usage) can be set automatically from <b>resources/jdbc.properties</b>).</p>

<li><p><b>DAOConfig.java</b> - data access object layer configuration (DAO beans, scan components @Repository).</p>
<li><p><b>ServiceConfig.java</b> - service layer configuration (beans of Service, scan components @Service).</p>
<li><p><b>WebConfig.java</b> - web configuration (ViewResolver (InternalResourceViewResolver) and scan components @Controller).</p>
</ul>
<p>The classes of Spring Security:</p>
<ul>
<li><p><b>SecurityConfig.java</b> - security configuration (extends WebSecurityConfigurerAdapter) - jdbc authentication (from DB), permissions, passwordencoder, AuthenticationSuccessHandler, AccessDeniedHandler.</p>
<li><p><b>SecurityAuthHandler.java</b> for redirect after authentication.</p>
<li><p><b>SecurityDeniedHandler.java</b> for redirect if access denied.</p>
</ul>

<h3>ru/goryachev/foreman/controllers</h3>
<ul>
<li><p><b>AdminController.java</b></p>
<li><p><b>LoginController.java</b></p>
<li><p><b>MainController.java</b></p>
<li><p><b>ConstructionSiteController.java</b></p>
<li><p><b>SupplyDepController.java</b></p>
</ul>
<p>The detailed information is available in <b>3.GUI</b> (see color code down below).</p>


<h3>ru/goryachev/foreman/entities</h3>
<p>Entities that represent persistent data maintained in a database and mapped to database tables.</p>
<ul>
<li><p>interface-marker Entity;</p>
<li><p>Entity-classes (implement Entity)</p>
</ul>

<h3>ru/goryachev/foreman/dto</h3>
<p>Data transfer objects are used to transfer data from service layer to JSP (mapped to views).</p>
<p>The package contains DTO classes (to show data on web page), and they can be further used for API.</p>

<h3>ru/goryachev/foreman/dao</h3>
<ul>
<li><p>interface DataAccessible includes 5 methods (CRUD operations and to get one entity by ID):</p>
<ul>
<li><p>List getAll();</p>
<li><p>void create(Entity entity);</p>
<li><p>void update(Entity entity);</p>
<li><p>void delete (int id);</p>
<li><p>Entity getById(int id);</p>
</ul>
<li><p>implementations of DataAccessible - dao classes (for each entity) contain methods with SQL queries</p>
<li><p>implementations of RowMapper (springframework.jdbc.core.RowMapper) - mappers for each dao class</p>
</ul>

<h3>ru/goryachev/foreman/service</h3>
<p>Services exchange data with each other and have the following functionality:</p>
<ul>
<li><p>conversion from entities (interface Entity) to DTO (either using standard selections from DAO or using their own methods (without SQL queries) to get custom selections);</p>
<li><p>getting data from sessions (current names and other user information);</p>
<li><p>automatic setting of parameters (current time, construction, etc);</p>
<li><p>provide data for view layer; get data from view layer;</p>
<li><p>conversion data to entities for DAO.</p>
</ul>

<p><a name="gui"></a></p>
<h2>3. Graphical user interface</h2>
<p>GUI based on JSP (JSTL-1.2) and configured in WebConfig.java.</p>

<ul>
<li><p>HTML5, block layout;</p></li>
<li><p>Styles: sources/style.css;</p></li>
</ul>
<p>GUI structure:</p>

![MAPPING_Scheme](https://user-images.githubusercontent.com/61917893/104068596-49738e00-5216-11eb-8359-2e519b0aa713.jpg)
<p>There are also available service-pages: </p>
<ul>
<li><p>user_info.jsp;</p></li>
<li><p>access_denied.jsp;</p></li>
</ul>
<p>(optional usage).</p>

<p><a name="database"></a></p>
<h2>4. Database</h2>

<p>Database structure in files:</p>
<ul>
<li><b>Foreman_DDL_v3.2-db.md</b> - tables (SQL)
<li><b>Foreman_SP_v3.2-db.md</b> - stored procedures(PL/pgSQL)
</ul>
<p>The database contains:</p>
<p>tables: 7</p>
<p>stored procedures: 6</p>
<p>For connection to database use an appropriate driver. In this example - "org.postgresql.Driver", PostgreSQL version 13 (see <b>2.Structure: ru/goryachev/foreman/config</b> - about JDBCConfig.java).</p>

<h3>Database scheme</h3>

![DBscheme_v3 2-db](https://user-images.githubusercontent.com/61917893/103481402-dae49980-4deb-11eb-812c-399686a56309.jpg)

<p></p>
<p>Free software for educational purposes. It will be possible to use Foreman web-app for real activity if only appropriate improvements are done. Author: Lev Goryachev.</p>

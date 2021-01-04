# Foreman
Foreman is a web-application for supply service (construction industry).
Employees who are located on construction sites can use this web-application to create and send orders on-line. In its turn, construction supply managers are able to recieve the orders and initiate the delivery of materials.
<p><b>Java 11, Spring-Web-MVC, Spring JDBC, Spring Security, JSP</b></p>
<p><b>DB: relational database with stored procedures(PostgreSQL)</b></p>

<p>An example launched on: <a href="https://foreman-one.herokuapp.com" target="_blank">https://foreman-one.herokuapp.com</a> (first launch can take about 20-30 sec.)</p>

<h2>1. Structure</h2>
<h3>ru/goryachev/foreman/app</h3>
<ul>
<li><p><b>AppInit.java</b> - ServletContext initialization (extends AbstractAnnotationConfigDispatcherServletInitializer), determines the classes of configuration (JdbcConfig, DAOConfig, ServiceConfig, WebConfig, SecurityConfig).</p></li>
<li><p><b>SecurityInit.java</b> - Spring Security initialization (extends AbstractSecurityWebApplicationInitializer)</p></li>
</ul>

<h3>ru/goryachev/foreman/config</h3>
<p> The classes of configurations (implementations of WebMvcConfigurer - org.springframework.web.servlet.config.annotation)
</p>

<ul>
<li><p><b>JDBCConfig.java</b> - configures connection to database: beans JdbcTemplate, DataSource (dependency: spring-jdbc).</p>
<p>Use appropriate driver to connect to your database. In this example -  "org.postgresql.Driver", dependency: compile group: 'postgresql', name: 'postgresql', version: '9.0-801.jdbc4' from MavenCentral.</p>
<p>There are three variables <b>username</b>, <b>password</b> and <b>databaseUrl</b> which are provided from Spring Datasource and they change their values depending on the environment (default values (for local usage) can be set automatically from <b>resources/jdbc.properties</b>).</p>

<li><p><b>DAOConfig.java</b> - data access object layer configuration (DAO beans, scan components @Repository).</p>
<li><p><b>ServiceConfig.java</b> - service layer configuration (beans of Service, scan components @Service).</p>
<li><p><b>WebConfig.java</b> - web configuration (ViewResolver (InternalResourceViewResolver) and scan components @Controller).</p>
<li><p><b>SecurityConfig.java</b> - security configuration (extends WebSecurityConfigurerAdapter) - jdbc authentication (from DB), permissions, passwordencoder, SecurityAuthHandler (for redirect after authentication).</p>
</ul>

<h3>ru/goryachev/foreman/controllers</h3>
<ul>
<li><p><b>AdminController.java</b></p>
<li><p><b>LoginController.java</b></p>
<li><p><b>MainController.java</b></p>
<li><p><b>ConstructionSiteController.java</b></p>
<li><p><b>SupplyDepController.java</b></p>
</ul>

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


<h3>ru/goryachev/foreman/entities</h3>
<ul>
<li><p>interface-marker Entity;</p>
<li><p>Entity-classes (implement Entity)</p>
<p>Setters in Entities (only for reference types) contain 'if' statement for getting rid of nulls (in case of null from database).</p>
<li><p>Entity-presentable classes (for views);</p>
</ul>

<h3>ru/goryachev/foreman/services</h3>
<ul>
<li><p>Interface Applicable includes 4 methods for CRUD operations:</p>
<ul>
<li><p>List getAll();</p>
<li><p>void create(Entity entity);</p>
<li><p>void update(Entity entity);</p>
<li><p>void delete (int id);</p>
</ul>
<li><p>Classes of services can implement Applicable and have the following functionality:</p>
<ul>
<li><p>conversion from entities to entities-presentable (either using standard selections from DAO or doing custom selections without SQL queries from full selection);</p>
<li><p>getting data from sessions;</p>
<li><p>automatic setting of parameters (current time, current names);</p>
<li><p>conversion data to entities (for tables) and transmitting them to DAO</p>
</ul>
<li><p>Classes of services running for third-party services or applications.</p>
</ul>

<h2>2. Database</h2>
<p>Database structure in files:</p>
<ul>
<li><b>Foreman_DDL_v3.2-db.md</b> - tables (SQL)
<li><b>Foreman_SP_v3.2-db.md</b> - stored procedures(PL/pgSQL)
</ul>
<p>The database contains:</p>
<p>tables: 7</p>
<p>stored procedures: 6</p>
<p>For connection to database use an appropriate driver. In this example - "org.postgresql.Driver", PostgreSQL version 13 (see <b>1.Structure: ru/goryachev/foreman/config - about JDBCConfig.java).</b></p>

<h3>Database scheme</h3>

![DBscheme_v3 2-db](https://user-images.githubusercontent.com/61917893/103481402-dae49980-4deb-11eb-812c-399686a56309.jpg)

<p></p>
<p>Free software for educational purposes. Lev Goryachev.</p>

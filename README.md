UPDATE for karaf 4.0.7

Our team recently upgraded from Karaf 2.3 to 4.0.7, and changed datasource.xml to etc/ops4j...cfg.
Flyway failed to start after the change. It turned out osgi.jndi.service.name filter no longer works, 
use dataSourceName without jdbc/ prefix instead does the trick.

e.g. change from **osgi.jndi.service.name=jdbc/**flyway-datasource
to **dataSourceName=**flyway-datasource

see https://ops4j1.jira.com/wiki/display/PAXJDBC/Create+DataSource+from+config for more details

---

This is a sample project to demo how to use Flyway on Karaf

This was devloped and tested on Karaf 2.3.1, and tested and verified on 3.0.6. To run this project, do the following,

Install MySQL driver and Flyway to karaf

* install -s mvn:mysql/mysql-connector-java/5.1.38
* install -s mvn:org.flywaydb/flyway-core/3.2.1

Create a test database as followed,

* create database flyway_demo;   
* grant all on flyway_demo.* to flyway@localhost identified by 'flyway';

Deploy datasource by copying flyway-datasource.xml to deploy folder

Build project with maven, and then copy the jar to deploy folder

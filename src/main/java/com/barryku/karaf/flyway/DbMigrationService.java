package com.barryku.karaf.flyway;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbMigrationService {
	private static final Logger logger = LoggerFactory.getLogger(DbMigrationService.class);

	private DataSource datasource;
	private Flyway flyway;

	public void doMigration() {
		logger.info("============== karaf flyway migrateion demo =============");
                LogFactory.setLogCreator(new Slf4jLogCreator());
		ClassLoader thisClassLoader = this.getClass().getClassLoader();
		getFlyway().setDataSource(datasource);
		getFlyway().setClassLoader(thisClassLoader);

		getFlyway().migrate();
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public Flyway getFlyway() {
		return flyway;
	}

	public void setFlyway(Flyway flyway) {
		this.flyway = flyway;
	}


}

package com.bit.saas_uac.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class CustomizeDataSourceInitializerConfig {
    @Value("classpath:sql/dropTables.sql")
    private Resource sqlDropTables;
    @Value("classpath:sql/createUserTable.sql")
    private Resource sqlUserSchema;
    @Value("classpath:sql/createRoleTable.sql")
    private Resource sqlRoleSchema;
    @Value("classpath:sql/createUserRoleTable.sql")
    private Resource sqlUserRoleSchema;
    @Value("classpath:sql/insertUserTestData.sql")
    private Resource sqlInsertUserTestData;
    @Value("classpath:sql/insertRoleTestData.sql")
    private Resource sqlInsertRoleTestData;
    @Value("classpath:sql/insertUserRoleTestData.sql")
    private Resource sqlInsertUserRoleTestData;


    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource){
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(databasePopulator());
        return dataSourceInitializer;
    }

    private DatabasePopulator databasePopulator(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(sqlDropTables);
        populator.addScript(sqlUserSchema);
        populator.addScript(sqlRoleSchema);
        populator.addScript(sqlUserRoleSchema);
        populator.addScript(sqlInsertUserTestData);
        populator.addScript(sqlInsertRoleTestData);
        populator.addScript(sqlInsertUserRoleTestData);
        return populator;
    }

}


package com.shapeshop;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbTestUtil {

    private DbTestUtil() {}

    public static void resetAutoIncrementColumns(ApplicationContext applicationContext,
                                                 String... tableNames) throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        String resetSqlTemplate = "ALTER TABLE %s ALTER COLUMN id RESTART WITH 1";
        try (Connection dbConnection = dataSource.getConnection()) {
            //Create SQL statements that reset the auto increment columns and invoke 
            //the created SQL statements.
            for (String resetSqlArgument: tableNames) {
                try (Statement statement = dbConnection.createStatement()) {
                    String resetSql = String.format(resetSqlTemplate, resetSqlArgument);
                    statement.execute(resetSql);
                }
            }
        }
    }

//    private static String getResetSqlTemplate(ApplicationContext applicationContext) {
//        //Read the SQL template from the properties file
////        Environment environment = applicationContext.getBean(Environment.class);
//
//        return "ALTER TABLE %s ALTER COLUMN id RESTART WITH 1";
//
////        return environment.getRequiredProperty("test.reset.sql.template");
//    }
}
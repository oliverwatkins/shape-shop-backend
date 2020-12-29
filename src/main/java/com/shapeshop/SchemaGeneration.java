package com.shapeshop;

import com.shapeshop.entity.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class SchemaGeneration {

    public static void mainX(String[] args) {

        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost/testdb?useSSL=false");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "");
        settings.put("hibernate.hbm2ddl.auto", "create");
        settings.put("show_sql", "true");

        MetadataSources metadataSources = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .applySettings(settings)
                        .build());



//        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        metadataSources.addAnnotatedClass(AddressEntity.class);
        metadataSources.addAnnotatedClass(CompanyEntity.class);
        metadataSources.addAnnotatedClass(CreditCardEntity.class);
        metadataSources.addAnnotatedClass(OrderItemEntity.class);
        metadataSources.addAnnotatedClass(OrderEntity.class);
        metadataSources.addAnnotatedClass(ProductEntity.class);
        metadataSources.addAnnotatedClass(UserEntity.class);

        Metadata metadata = metadataSources.buildMetadata();

        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true);
        schemaExport.setOutputFile("create.sql");
        schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
    }


    static void exportSchema() {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost/hibernate_examples");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "password");


        MetadataSources metadata  = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .applySettings(settings)
                        .build());
        metadata.addAnnotatedClass(AddressEntity.class);
        metadata.addAnnotatedClass(CompanyEntity.class);
        metadata.addAnnotatedClass(CreditCardEntity.class);
        metadata.addAnnotatedClass(OrderItemEntity.class);
        metadata.addAnnotatedClass(OrderEntity.class);
        metadata.addAnnotatedClass(ProductEntity.class);
        metadata.addAnnotatedClass(UserEntity.class);


        EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE);
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.execute(enumSet, SchemaExport.Action.BOTH, metadata.buildMetadata());

    }

    public static void main(String[] args) {

        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQLDialect");



//        settings.put("hibernate.connection.url", "jdbc:mysql://localhost/mysql");

        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/shapeshop");


        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "root");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(settings).build();

        MetadataSources metadata =
                new MetadataSources(serviceRegistry);
        metadata.addAnnotatedClass(AddressEntity.class);
        metadata.addAnnotatedClass(CompanyEntity.class);
        metadata.addAnnotatedClass(CreditCardEntity.class);
        metadata.addAnnotatedClass(OrderItemEntity.class);
        metadata.addAnnotatedClass(OrderEntity.class);
        metadata.addAnnotatedClass(ProductEntity.class);
        metadata.addAnnotatedClass(UserEntity.class);

        EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE);
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.execute(enumSet, SchemaExport.Action.BOTH, metadata.buildMetadata());
    }


//    static void exportSchema(
//            DataSource dataSource,
//            Class<? extends Dialect> dialect,
//            String... packagesToScan) {
//
//        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
//                .applySetting(DATASOURCE, dataSource)
//                .applySetting(DIALECT, dialect); // dialect could be omitted
//        MetadataSources metadataSources = new MetadataSources(registryBuilder.build());
//
//        PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
//        new LocalSessionFactoryBuilder(null, resourceLoader, metadataSources)
//                .scanPackages(packagesToScan);
//
//        Metadata metadata = metadataSources.buildMetadata();
//
//        new SchemaExport()
//                .setFormat(true)
//                .create(EnumSet.of(STDOUT, DATABASE), metadata);
//    }





}

package com.neusoft.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Bruce Lee on 2017/7/17.
 */
@Configuration
@EnableTransactionManagement()
@ComponentScan(basePackages = {"com.neusoft.service"})
public class ModuleConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(
            @Value("classpath:db.properties") Resource locations) {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(locations);
        return propertyPlaceholderConfigurer;
    }

//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource=new HikariDataSource();
//        // BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUsername("root");
//        dataSource.setPassword("123q456w");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jx?useUnicode=true&amp;characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull ");
//        return dataSource;
//    }

    @Bean
    public DataSource dataSource(@Value("${jdbc.username}") String userName,
                                 @Value("${jdbc.password}") String password,
                                 @Value("${jdbc.driver}") String driverClassName,
                                 @Value("${jdbc.url}") String jdbcUrl) {
        HikariDataSource dataSource=new HikariDataSource();
        // BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.neusoft.mapper");
        return mapperScannerConfigurer;
    }
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}

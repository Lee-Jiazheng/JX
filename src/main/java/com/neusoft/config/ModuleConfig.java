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
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import redis.clients.jedis.JedisPoolConfig;

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
            @Value("classpath:db.properties") Resource locationDB,
            @Value("classpath:redis.properties") Resource  locationsRedis) {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(locationDB, locationsRedis);
        return propertyPlaceholderConfigurer;
    }

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

    //redis配置参考http://www.cnblogs.com/s648667069/p/6473412.html
    //jedis连接池 配置
    @Bean
    public JedisPoolConfig poolConfig(@Value("${redis.maxIdle}") int maxIdle,
                                      @Value("${redis.maxWait}") int maxWaitMillis,
                                      @Value("${redis.testOnBorrow}") Boolean testOnBorrow) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }

    // redis服务器中心
    @Bean
    public JedisConnectionFactory connectionFactory(@Value("#{poolConfig}") JedisPoolConfig poolConfig , @Value("${redis.host}") String hostName,
                                                    @Value("${redis.port}") int port, @Value("${redis.maxWait}") int timeout) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(poolConfig);
        jedisConnectionFactory.setHostName(hostName);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setTimeout(timeout);
        return jedisConnectionFactory;
    }
    // redis template
    @Bean
    public RedisTemplate redisTemplate(@Value("#{connectionFactory}") JedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        StringRedisSerializer keySerializer=new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=new JdkSerializationRedisSerializer();
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        return redisTemplate;
    }

    // cache manager
    @Bean()
    public RedisCacheManager cacheManager(@Value("#{redisTemplate}") RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        return redisCacheManager;
    }
}

package com.example.demoserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @program: game_api
 * @description:
 * @author: Dading
 * @create: 2019-04-12 14:14
 * @version: 1.0
 **/
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = Da3DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "da3SqlSessionFactory")
public class Da3DataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.demoserver.dao.interfaces.da3";
    static final String MAPPER_LOCATION = "classpath:mapper/da3/*.xml";

    @Value("${da3.datasource.url}")
    private String url;

    @Value("${da3.datasource.username}")
    private String user;

    @Value("${da3.datasource.password}")
    private String password;

    @Value("${da3.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "da3DataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "da3TransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "da3SqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("da3DataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(Da3DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}

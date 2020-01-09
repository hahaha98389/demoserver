package com.example.demoserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * @program:
 * @description:
 * @author:
 * @create:
 * @version: 1.0
 **/
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = Da2DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "da2SqlSessionFactory")
public class Da2DataSourceConfig {


    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.demoserver.dao.interfaces.da2";
    static final String MAPPER_LOCATION = "classpath:mapper/da2/*.xml";

    @Value("${da2.datasource.url}")
    private String url;

    @Value("${da2.datasource.username}")
    private String user;

    @Value("${da2.datasource.password}")
    private String password;

    @Value("${da2.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "da2DataSource")
    @Primary
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "da2TransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "da2SqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("da2DataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(Da2DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}

package com.example.demoserver.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

//很low的多数据源配置方式
@Configuration
public class MultipleDBConfig {
    @Bean(name = "da2")
    @Primary//必须要有一个主库
    @ConfigurationProperties(prefix = "da2.datasource")
    public DataSource marketDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "da2JdbcTemplate")
    public JdbcTemplate marketJdbcTemplate(@Qualifier("da2") DataSource dsMarket) {
        return new JdbcTemplate(dsMarket);
    }

    @Bean(name = "da3")
    @ConfigurationProperties(prefix = "da3.datasource")
    public DataSource tradeDataSource() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "da3JdbcTemplate")
    public JdbcTemplate tradeJdbcTemplate(@Qualifier("da3") DataSource dsTrade) {
        return new JdbcTemplate(dsTrade);
    }
}

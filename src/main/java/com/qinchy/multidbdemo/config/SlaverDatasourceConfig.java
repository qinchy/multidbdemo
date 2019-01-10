package com.qinchy.multidbdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.qinchy.multidbdemo.mapper.slaver", sqlSessionTemplateRef = "slaverSqlSessionTemplate")
public class SlaverDatasourceConfig {

    @Bean(name = "slaverSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaverDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/qinchy/multidbdemo/mapper//slaver/**/*Mapper.xml"));
        return bean.getObject();
    }

//    @Bean(name = "slaverTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "slaverSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

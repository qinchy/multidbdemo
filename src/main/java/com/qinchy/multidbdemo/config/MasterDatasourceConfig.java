package com.qinchy.multidbdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.qinchy.multidbdemo.mapper.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDatasourceConfig {

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/qinchy/multidbdemo/mapper/master/**/*Mapper.xml"));
        return bean.getObject();
    }

//    @Bean(name = "masterTransactionManager")
//    @Primary
//    public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

package com.itheima.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

public class MyBatisConfig {

    // 配置分页插件
    @Bean
    public PageInterceptor getPageInterceptor() {
        PageInterceptor pageIntercptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("value", "true");
        pageIntercptor.setProperties(properties);
        return pageIntercptor;
    }

    /*
     * 定义 MyBatis 的核心连接工厂 bean，
     * 等同于<bean class="org.mybatis.spring.SqlSessionFactoryBean">
     */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(
            @Autowired DataSource dataSource,
            @Autowired PageInterceptor pageIntercptor) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        // 等同于<property name="dataSource" ref="dataSource"/>
        ssfb.setDataSource(dataSource);
        Interceptor[] plugins = {pageIntercptor};
        ssfb.setPlugins(plugins);
        return ssfb;
    }

    /*
     * 定义 MyBatis 的映射扫描，
     * 等同于<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 等同于<property name="basePackage" value="com.itheima.dao"/>
        msc.setBasePackage("com.itheima.mapper");
        return msc;
    }
}
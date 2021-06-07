package com.mybatisplus.first.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //表示是配置类
@EnableTransactionManagement // 事务
@MapperScan("com.mybatisplus.first.dao") //扫描mapper文件夹
public class MybatisConfig {

  //注册乐观锁插件
  @Bean
  public OptimisticLockerInterceptor optimisticLockerInterceptor(){
    return  new OptimisticLockerInterceptor();
  }


  //分页插件
  @Bean
  public PaginationInterceptor paginationInterceptor(){
    return new  PaginationInterceptor();
  }

  //逻辑删除
  @Bean
  public ISqlInjector sqlInjector(){
    return  new LogicSqlInjector();
  }


  //sql执行效率插件
  @Bean
  @Profile({"dev","test"})//设置dev test环境开启,保证效率
  public PerformanceInterceptor performanceInterceptor(){
    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    performanceInterceptor.setMaxTime(100000);//ms 设置sql执行最大数据,超过不执行
    performanceInterceptor.setFormat(true);
    return performanceInterceptor;
  }



}


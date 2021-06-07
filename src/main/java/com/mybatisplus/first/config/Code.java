package com.mybatisplus.first.config;

//代码自动生成器

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.Properties;
import java.util.ResourceBundle;

public class Code {

  public static void main(String[] args) {

    //配置文件属性绑定,用于读取数据库的账号密码等
    final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
    //构建一个代码生成器对象
    AutoGenerator mpg = new AutoGenerator();
    //配置策略

    //1.全局配置
    GlobalConfig gc = new GlobalConfig();
    String propertyPath = System.getProperty("user.dir");
    gc.setOutputDir(propertyPath + "/src/main/java");
    gc.setAuthor("wangwei");
    gc.setOpen(false);
    gc.setFileOverride(false);//是否覆盖
    gc.setServiceName("%sService");//去Service的I前缀
    gc.setDateType(DateType.ONLY_DATE);
    gc.setSwagger2(true);
    mpg.setGlobalConfig(gc);


    //2.设置数据源
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUrl(rb.getString("url"));
    dsc.setUsername(rb.getString("userName"));
    dsc.setPassword(rb.getString("password"));
    dsc.setDbType(DbType.MYSQL);
    mpg.setDataSource(dsc);


    //3.包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName("blog");
    pc.setParent(rb.getString("parent"));
    pc.setController("controller."+rb.getString("className"));
    pc.setService("service."+rb.getString("className"));
    pc.setServiceImpl("service.impl."+rb.getString("className"));
    pc.setEntity("entity."+rb.getString("className"));
    pc.setMapper("dao."+rb.getString("className"));
    mpg.setPackageInfo(pc);


    //4.策略配置
    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig.setInclude(rb.getString("tableName"));//设置要映射的表名
    strategyConfig.setNaming(NamingStrategy.underline_to_camel);
    strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
    strategyConfig.setEntityLombokModel(true);// 自动lombok
    //乐观锁
    strategyConfig.setVersionFieldName("version");
    strategyConfig.setRestControllerStyle(true);
    strategyConfig.setControllerMappingHyphenStyle(true);// localhost:8080/hello_id_2
    mpg.setStrategy(strategyConfig);

    mpg.execute();//执行


  }

}

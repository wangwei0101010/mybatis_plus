package com.mybatisplus.first.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Slf4j
@Component//吧处理器加到IOC中
public class MysMethObjectHandler implements MetaObjectHandler {

//插入时候的填充策略
  @Override
  public void insertFill(MetaObject metaObject) {

    log.debug("start insert fill....");
    this.setFieldValByName("createTime",new Date(),metaObject);
    this.setFieldValByName("updateTime",new Date(),metaObject);
  }

  //更新时候的填充策略
  @Override
  public void updateFill(MetaObject metaObject) {

    log.debug("start update fill....");

    this.setFieldValByName("updateTime",new Date(),metaObject);
  }
}

package com.mybatisplus.first.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatisplus.first.dao.UserMapper;
import com.mybatisplus.first.entity.User;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WrapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void contextloads(){
    //参数是wrapper,条件构造器 不用null
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.isNotNull("name")
        .isNotNull("email")
        .ge("age",12);
    List<User> users = userMapper.selectList(wrapper);
    List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
    users.forEach(System.err::println);
    System.err.println("---------");
    maps.forEach(System.err::println);
  }

  @Test //子查询
  public void test2(){
    //参数是wrapper,条件构造器 不用null
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.inSql("id","select id from user where id <3");
    List<User> users = userMapper.selectList(wrapper);
    users.forEach(System.err::println);
  }

}

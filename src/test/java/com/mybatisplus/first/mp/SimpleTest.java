package com.mybatisplus.first.mp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.first.dao.UserMapper;
import com.mybatisplus.first.entity.User;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SimpleTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testUserMapper() {
    List<User> users = userMapper.selectList(null);
    users.forEach(System.out::println);

  }

  //测试插入
  @Test
  public void testInsert() {
    User user = new User();
    user.setAge(18);
    user.setEmail("baomidou");
    user.setName("测试插入");
    int insert = userMapper.insert(user);//受影响的行数
    System.err.println(insert);
  }

  //测试变更
  //通过sql自动拼接动态sql,id为空不报错,返回影响行数为0
  @Test
  public void testUpdate() {
    User user = new User();
    user.setId(1L);
    user.setAge(18);
    user.setEmail("baomidou");
    user.setName("测试修改");
    userMapper.updateById(user);
  }

  //测试乐观锁
  @Test
  public void testOptimisticLocker() {
    //查询用户信息
    User user = userMapper.selectById(1L);
    // 修改用户信息
    user.setName("wvewvi");
    user.setEmail("21344");
    // 更新
    userMapper.updateById(user);
  }

  //测试乐观锁失败,多线程
  @Test
  public void testOptimisticLocker2() {
    //线程1
    //查询用户信息
    User user = userMapper.selectById(1L);
    // 修改用户信息
    user.setName("wvewvi1111");
    user.setEmail("21344");

    //线程2 执行插入操作
    User user2 = userMapper.selectById(1L);
    // 修改用户信息
    user2.setName("wvewvi2222");
    user2.setEmail("21344");
    userMapper.updateById(user2);

    // 更新失败,自旋尝试提交 juc   java.util.concurrent
    userMapper.updateById(user);
  }

  @Test //多个id
  public void testSelectByBatchId() {
    List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
    System.err.println(users);

  }

  //条件查询
  @Test
  public void testSelectByBatchIds() {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("name", "测试插入");
    hashMap.put("age", "3");
    List<User> users = userMapper.selectByMap(hashMap);
    users.forEach(System.out::print);
  }

  //测试分页
  @Test
  public void testPage() {
    //当前页参数1  页面大小 参数2
    Page<User> page = new Page<>(1, 5);
    userMapper.selectPage(page, null);
    page.getRecords().forEach(System.err::print);
    long total = page.getTotal();
    System.err.println(total + "-----");

  }

  //测试删除
  @Test
  public void testDeleteById() {
    //当前页参数1  页面大小 参数2
    userMapper.deleteById(1L);

  }

  //测试Optional
  @Test
  public void testOptional() throws Exception {
    User user = null;
    Optional.ofNullable(user).orElse(new User());
    Optional.ofNullable(user).orElseGet(() -> new User());
    Optional.ofNullable(user).orElseThrow(() -> new Exception("用户不存在"));

  }

  /**
   * https://blog.csdn.net/zjhred/article/details/84976734
   *
   * 以前的写法
   public String getCity(User user)  throws Exception{
   if(user!=null){
   if(user.getAddress()!=null){
   Address address = user.getAddress();
   if(address.getCity()!=null){
   return address.getCity();
   }
   }
   }
   throw new Excpetion("取值错误");
   }

   todo 现在的写法
   public String getCity(User user) throws Exception{
   return Optional.ofNullable(user)
   .map(u-> u.getAddress())
   .map(a->a.getCity())
   .orElseThrow(()->new Exception("取指错误"))
   }

   以前写法
   if(user!=null){
   dosomething(user);
   }
   现在写法

   Optional.ofNullable(user)
   .ifPresent(u->{
   dosomething(u);
   }

   以前写法
   public User getUser(User user) throws Exception{
   if(user!=null){
   String name = user.getName();
   if("zhangsan".equals(name)){
   return user;
   }
   }else{
   user = new User();
   user.setName("zhangsan");
   return user;
   }
   }

   现在写法
   public User getUser(User user) {
   return Optional.ofNullable(user)
   .filter(u->"zhangsan".equals(u.getName()))
   .orElseGet(()-> {
   User user1 = new User();
   user1.setName("zhangsan");
   return user1;
   });
   }

   * */


}

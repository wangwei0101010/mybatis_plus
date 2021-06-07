package com.mybatisplus.first.mp.Thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class TestThread extends Thread {

  //创建线程方式1:继承Thread类
  @Override
  public void run() {
    //run方法线程体
    for (int i = 0; i < 20; i++) {
      System.err.println("我在看代码---"+i);
    }

  }


  public static void main(String[] args) {
    TestThread testThread = new TestThread();
    //testThread.run(); //有先后顺序,先执行testThread,完了在执行for
    testThread.start();// 无先后顺序,交叉执行,要用start方法
    for (int i = 0; i < 20; i++) {
      System.err.println("我在学校多线程---"+i);
    }

  }





}

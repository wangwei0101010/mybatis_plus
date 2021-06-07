package com.mybatisplus.first.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.first.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper  extends BaseMapper<User> {

}

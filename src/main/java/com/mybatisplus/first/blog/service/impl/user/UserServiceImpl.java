package com.mybatisplus.first.blog.service.impl.user;

import com.mybatisplus.first.blog.entity.user.User;
import com.mybatisplus.first.blog.dao.user.UserMapper;
import com.mybatisplus.first.blog.service.user.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangwei
 * @since 2021-06-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

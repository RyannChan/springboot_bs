package com.crj.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crj.springboot.entity.User;
import com.crj.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
//    @Autowired
//    private UserMapper userMapper;
//    public int save(User user){
//        if(user.getId()==null){ //如果id为空 则表示新增
//            return userMapper.insert(user);
//        }else{
//            return userMapper.update(user);
//        }
//    }

    public boolean saveUser(User user){
        return saveOrUpdate(user);
    }
}

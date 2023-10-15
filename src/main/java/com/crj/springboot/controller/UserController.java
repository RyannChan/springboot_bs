package com.crj.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crj.springboot.entity.User;
import com.crj.springboot.mapper.UserMapper;
import com.crj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> findAll(){
//        return userMapper.findAll();
        return userService.list();
    }

    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

//    批量删除接口
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }
//
//    @GetMapping("/page")
//    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize, @RequestParam String username,@RequestParam String email,@RequestParam String address){
//        pageNum = (pageNum - 1 ) * pageSize;
//        username = "%"+username+"%";
//        email = "%"+email+"%";
//        address = "%"+address+"%";
//        List<User> data = userMapper.selectPage(pageNum, pageSize,username,email,address);
//        Integer total = userMapper.selectTotal(username,email,address);
//        Map<String,Object> res = new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }

//分页查询 mybatis-plus的方式
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String email,
                                @RequestParam(defaultValue = "") String address
                                )
    {
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if(!"".equals(email)){
            queryWrapper.like("email",email);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
        }



        return userService.page(page,queryWrapper);
    }




}

package com.crj.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crj.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from sys_user where username like #{username} and email like #{email} and address like #{address} limit #{pageNum},#{pageSize}")
//     List<User> selectPage(Integer pageNum, Integer pageSize,String username,String email,String address) ;
//
//
//    //    查询全部
//    @Select("select * from sys_user")
//    List<User> findAll();
//
////    新增
//    @Insert("insert into sys_user(username,password,nickname,email,phone,address) values (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
//    int insert(User user);
//
////    修改
//    int update(User user);
//
////    删除
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//     //@Select("select count(*) from sys_user where username like concat('%',#{username},'%') and email like concat('%',#{email},'%') and address like concat('%',#{address},'%')")
//     @Select("select count(*) from sys_user where username like #{username} and email like #{email} and address like #{address}")
//
//     Integer selectTotal(String username,String email,String address);
}

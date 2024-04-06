package com.example.login_register.mapper;



import com.example.login_register.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    // 登录方法，根据用户名查询密码
    @Select("select password from login_register.user where username = #{username}")
    String findUserPasswordByUserName(String username);

    @Select("select * from login_register.user where username = #{username}")
    String userNameIsExist(String username);

    @Insert("insert into login_register.user(username, password) values (#{username}, #{password})")
    void adduser(String username, String password);

    @Select("select * from login_register.user")
    List<User> getAll();

}

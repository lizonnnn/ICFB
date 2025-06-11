package com.cafuc.icfb.DAO;

import com.cafuc.icfb.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    List<User> getUserList();
    List<User> getUserByUaP(String username,String password);
    Integer addUser(String username,String  password,String email);
    Integer deleteUserById(Integer id);
}


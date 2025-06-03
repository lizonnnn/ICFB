package com.cafuc.dsdr.DAO;

import com.cafuc.dsdr.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    List<User> getUserList();
    List<User> getUserByUaP(String username,String password);
}


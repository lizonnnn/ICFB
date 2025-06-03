package com.cafuc.dsdr.service;

import com.cafuc.dsdr.DAO.UserDao;
import com.cafuc.dsdr.entity.User;
import com.cafuc.dsdr.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public String getUserByUaP(String username,String password){
        List<User> userlist=userDao.getUserByUaP(username,password);
        if(!userlist.isEmpty()) {
            return userlist.get(0).getUsername();
        }
        else
            return null;
    }

}

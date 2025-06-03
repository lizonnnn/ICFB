package com.cafuc.dsdr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class HelloController {
    @RequestMapping("/hello")//测试数据库连通性，初始模板
    public String Hello()throws SQLException, ClassNotFoundException {
//        1.加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
//        2.用户信息和url
                String url = "jdbc:mysql://localhost:3306/dsdr?useUnicode=true&characterEncoding=utf8&useSSL=true";
                String username="root";
                String password="123456";
//        3.连接成功，数据库对象 Connection
                Connection connection = DriverManager.getConnection(url,username,password);
//        4.执行SQL对象Statement，执行SQL的对象
                Statement statement = connection.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
                String sql = "SELECT *FROM dsdruser;";
                ResultSet resultSet = statement.executeQuery(sql);
//        6.释放连接
                resultSet.close();
                statement.close();
                connection.close();
                return resultSet.toString();
    }
}

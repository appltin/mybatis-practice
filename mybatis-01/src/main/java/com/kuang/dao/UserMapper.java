package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    //查詢全部用戶
    List<User> getUserList();
    //用id查
    User getUserById(int id);
    //增加用戶
    int addUser(User user);
    //修改用戶
    int updateUser(User user);
}

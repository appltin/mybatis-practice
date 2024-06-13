package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {
    //查詢全部用戶
    List<User> getUserList();
    //用id查
    User getUserById(int id);
    User getUserById2(int id);

    //增加用戶
    int addUser(User user);
    //萬能map,非正規用法,但很方便
    int addUser2(Map<String, Object> map);

    //修改用戶
    int updateUser(User user);

    int deleteUser(int id);

}

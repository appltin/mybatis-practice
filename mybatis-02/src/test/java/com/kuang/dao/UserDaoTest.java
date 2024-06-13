package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //獲取SqlSession對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for(User user:userList){
            System.out.println(user);
        }

        //關閉SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //獲取SqlSession對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);


        //關閉SqlSession
        sqlSession.close();
    }

    //增刪改需要提交事物
    @Test
    public void addUser(){
        //獲取SqlSession對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(6, "hi", "123"));

        //提交事物
        sqlSession.commit();
        //關閉SqlSession
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        //獲取SqlSession對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",7);
        map.put("username","he");
        map.put("pwd","22222");

        System.out.println(userMapper.addUser2(map));
        //提交事物
        sqlSession.commit();
        //關閉SqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        //獲取SqlSession對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(6, "hoooo", "123"));

        //提交事物
        sqlSession.commit();
        //關閉SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        //獲取SqlSession對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(7);

        //提交事物
        sqlSession.commit();
        //關閉SqlSession
        sqlSession.close();
    }
}

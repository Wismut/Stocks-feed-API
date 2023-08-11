package com.example.stocks_feed_api.repository;

import com.example.stocks_feed_api.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM USERS")
    List<User> findAll();

    @Insert("INSERT INTO USERS(username, password) VALUES(username=#{username}, password=#{password})")
    int save(User user);

    @Select("SELECT * FROM USERS WHERE username=#{username}")
    User findByUsername(@Param("username") String username);
}

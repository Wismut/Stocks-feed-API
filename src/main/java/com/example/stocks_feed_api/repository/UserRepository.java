package com.example.stocks_feed_api.repository;

import com.example.stocks_feed_api.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM USERS")
    List<User> findAll();

    @Insert("INSERT INTO users(username, password, role) VALUES(#{username}, #{password}, #{role})")
    int save(User user);

    @Select("SELECT * FROM USERS WHERE username=#{username}")
    User findByUsername(String username);
}

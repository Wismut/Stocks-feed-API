package com.example.stocks_feed_api.mapper;

import com.example.stocks_feed_api.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS")
    List<User> findAll();

    @Insert("INSERT INTO USERS(username, password) VALUES(username=#{username}, password=#{password})")
    int save(User user);
}

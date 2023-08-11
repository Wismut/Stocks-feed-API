package com.example.stocks_feed_api.mapper;

import com.example.stocks_feed_api.dto.UserDto;
import com.example.stocks_feed_api.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toModel(UserDto userDto);

    UserDto toDto(User user);
}

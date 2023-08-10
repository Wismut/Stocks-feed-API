package com.example.stocks_feed_api.mapper;

import com.example.stocks_feed_api.dto.UserDto;
import com.example.stocks_feed_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDto userDto);

    UserDto toDto(User user);
}

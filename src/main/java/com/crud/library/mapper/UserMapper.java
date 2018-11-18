package com.crud.library.mapper;

import com.crud.library.Dto.UserDto;
import com.crud.library.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getJoined(),
                new ArrayList<>()
        );
    }
}

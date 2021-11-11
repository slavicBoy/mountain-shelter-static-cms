package com.example.mountainsheltercms.user;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setId(user.getId());
        return userDto;
    }

}

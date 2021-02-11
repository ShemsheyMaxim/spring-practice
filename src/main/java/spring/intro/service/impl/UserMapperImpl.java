package spring.intro.service.impl;

import org.springframework.stereotype.Component;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto mapUserToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}

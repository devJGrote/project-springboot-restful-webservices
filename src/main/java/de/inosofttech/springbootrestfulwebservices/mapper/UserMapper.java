package de.inosofttech.springbootrestfulwebservices.mapper;

import de.inosofttech.springbootrestfulwebservices.dto.UserDto;
import de.inosofttech.springbootrestfulwebservices.entity.User;

public class UserMapper {
    /**
     * Convert user JPA Entity into UserDto
     * @param user the jpa User
     * @return the UserDto
     */
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    /**
     * Conver UserDto into user JPA Entity
     * @param userDto the transported dto
     * @return the User JPA
     */
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}

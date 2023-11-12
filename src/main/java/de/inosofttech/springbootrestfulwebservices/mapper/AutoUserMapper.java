package de.inosofttech.springbootrestfulwebservices.mapper;


import de.inosofttech.springbootrestfulwebservices.dto.UserDto;
import de.inosofttech.springbootrestfulwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapstruct will implement the function at compile time
 * the Objects need the same names
 * if it has different fields we can Map this to handle this
 */
@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    //@Mapping(source = "email", target = "emailAddress")
    UserDto mapToUserDto(User user);


    User mapToUser(UserDto userDto);
}

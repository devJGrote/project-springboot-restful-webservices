package de.inosofttech.springbootrestfulwebservices.service.impl;

import de.inosofttech.springbootrestfulwebservices.dto.UserDto;
import de.inosofttech.springbootrestfulwebservices.entity.User;
import de.inosofttech.springbootrestfulwebservices.mapper.AutoUserMapper;
import de.inosofttech.springbootrestfulwebservices.mapper.UserMapper;
import de.inosofttech.springbootrestfulwebservices.repository.UserRepository;
import de.inosofttech.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto to User JPA
        //User user = UserMapper.mapToUser(userDto);
        //User user = modelMapper.map(userDto,User.class);

        User user =AutoUserMapper.MAPPER.mapToUser(userDto);

        //Save
        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        //return UserMapper.mapToUserDto(savedUser);
        //return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);

    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        //return UserMapper.mapToUserDto(optionalUser.get());
        //return modelMapper.map(optionalUser.get(), UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(AutoUserMapper.MAPPER::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User savedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(savedUser);
        //return modelMapper.map(existingUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

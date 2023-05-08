package com.champets.fureverhome.user.impl;

import com.champets.fureverhome.user.User;
import com.champets.fureverhome.user.UserDto;
import com.champets.fureverhome.user.UserRepository;
import com.champets.fureverhome.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.champets.fureverhome.user.UserMapper.mapToUserDto;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        return mapToUserDto(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> searchUsers(String query) {
        return null;
    }
}


package com.champets.fureverhome.user;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();

    User saveUser(User user);

    User saveUser(UserDto userDto); // duplicate in case

    UserDto findUserById(Long userId);

    void updateUser(User user);

    void updateUser(UserDto userDto); // duplicate in case

    void delete(Long userId);

    List<UserDto> searchUsers(String query);
}

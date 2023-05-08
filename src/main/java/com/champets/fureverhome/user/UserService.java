package com.champets.fureverhome.user;

import com.champets.fureverhome.pet.PetDto;
import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
}

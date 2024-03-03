package registrationloginsystem.service;

import java.util.List;

import registrationloginsystem.dto.UserDto;
import registrationloginsystem.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}

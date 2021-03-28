package ru.itis.javalab.services;

import org.springframework.stereotype.Component;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.dto.UserDto1;
import ru.itis.javalab.models.User;

import java.util.List;

/**
 * 15.10.2020
 * 05. WebApp
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public interface UsersService {
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsers(int page, int size);
    void addUser(UserDto userDto);
    void addUser(UserDto1 userDto1);
    void addUser(User user);
    UserDto getUser(Long userId);
    UserDto1 findFirstByEmail(String email);
    User getFirstByEmail(String email);
}

package ru.itis.javalab.services;

import org.springframework.stereotype.Component;
import ru.itis.javalab.dto.UserReg;
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
    List<UserReg> getAllUsers();
    void addUser(UserReg userDto1);
    void addUser(User user);
    UserReg getUser(Long userId);
}

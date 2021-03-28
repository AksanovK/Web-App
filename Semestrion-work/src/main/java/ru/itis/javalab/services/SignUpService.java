package ru.itis.javalab.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.itis.javalab.dto.UserReg;
import ru.itis.javalab.models.User;

import java.util.Optional;

@Component
public interface SignUpService {
    void signUp(User user);
    void signUp(UserReg user);
    Optional<User> findFirstByConfirmCode(String code);
    void updateStatus(String code);
}

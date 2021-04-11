package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserReg;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import java.util.List;



@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserReg> getAllUsers() {
        return UserReg.from(usersRepository.findAll());
    }

    @Override
    public void addUser(UserReg userReg) {
        usersRepository.save(User.builder()
                .firstName(userReg.getFirstName())
                .lastName(userReg.getLastName())
                .email(userReg.getEmail())
                .password(userReg.getPassword())
                .build());
    }


    @Override
    public void addUser(User user) {
        usersRepository.save(User.builder()
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .password(user.getPassword())
        .build());
    }


    @Override
    public void banAll() {
        List<User> users = usersRepository.findAll();
        for (User user : users) {
            if (!user.isAdmin()) {
                user.setCondition(User.State.BANNED);
                usersRepository.save(user);
            }
        }
    }

    @Override
    public UserReg getUser(Long userId) {
        return UserReg.convert(usersRepository.findById(userId).orElse(null));
    }

}

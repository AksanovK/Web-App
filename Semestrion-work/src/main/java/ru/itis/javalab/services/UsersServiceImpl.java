package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserDto;
import ru.itis.javalab.dto.UserDto1;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;

import java.util.List;

import static ru.itis.javalab.dto.UserDto.from;



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
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public List<UserDto> getAllUsers(int page, int size) {
        return from(usersRepository.findAll(page, size));
    }

    @Override
    public void addUser(UserDto userDto) {
        usersRepository.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build());
    }

    @Override
    public void addUser(UserDto1 userDto1) {
        usersRepository.save(User.builder()
        .email(userDto1.getEmail())
        .password(userDto1.getPassword())
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
    public UserDto getUser(Long userId) {
        return UserDto.from(usersRepository.findById(userId).orElse(null));
    }

    @Override
    public UserDto1 findFirstByEmail(String email) {
        return UserDto1.convert(usersRepository.findFirstByEmail(email).orElse(null));
    }

    @Override
    public User getFirstByEmail(String email) {
        return usersRepository.findFirstByEmail(email).orElse(null);
    }
}

package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.UserReg;
import ru.itis.javalab.models.User;
import ru.itis.javalab.repositories.UsersRepository;
import ru.itis.javalab.util.EmailUtil;
import ru.itis.javalab.util.MailsGenerator;

import java.util.Optional;
import java.util.UUID;

@Profile("dev")
@Service
public class SignUpServiceFakeImpl implements SignUpService {

    @Autowired
    private MailsGenerator mailsGenerator;

    @Autowired
    private JavaMailSender mailSender;


    @Value("${server.url}")
    private String serverUrl;


    public SignUpServiceFakeImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void signUp(User user) {
        User newUser = User.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        //usersRepository.save(newUser);
        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());
        System.out.println(":::::::::Письмо:::::::::");
        System.out.println(confirmMail);
    }

    @Override
    public void signUp(UserReg user) {
        User newUser = User.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        //usersRepository.save(newUser);
        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, newUser.getConfirmCode());
        System.out.println(":::::::::Письмо:::::::::");
        System.out.println(confirmMail);
    }

    @Override
    public Optional<User> findFirstByConfirmCode(String code) {
        return Optional.empty();
    }

    @Override
    public void updateStatus(String code) {

    }

}

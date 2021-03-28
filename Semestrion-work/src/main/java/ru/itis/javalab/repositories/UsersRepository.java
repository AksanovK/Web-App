package ru.itis.javalab.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import java.util.List;
import java.util.Optional;


@Component
public interface UsersRepository extends CrudRepository<User> {
    List<User> findAllByAge(Integer age);
    Optional<User> findFirstByFirstnameAndLastname(String firstName, String lastName);
    Optional<User> findFirstByEmail(String email);
    Optional<User> findFirstByConfirmCode(String code);
    void unConfirming(String confirmcode);
}

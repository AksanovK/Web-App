package ru.itis.javalab.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Profile("dev")
@Repository
public class UsersRepositoryFakeImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsersRepositoryFakeImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_INSERT_USER = "insert into account(first_name, last_name, email, password, confirmcode, status) values (?, ?, ?, ?, ?, ?)";


    @Override
    public List<User> findAllByAge(Integer age) {
        return null;
    }

    @Override
    public Optional<User> findFirstByFirstnameAndLastname(String firstName, String lastName) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findFirstByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findFirstByConfirmCode(String code) {
        return Optional.empty();
    }

    @Override
    public void unConfirming(String email) {

    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SQL_INSERT_USER, entity.getFirstName(), entity.getLastName(), entity.getEmail(), passwordEncoder.encode(entity.getPassword()), entity.getConfirmCode(), entity.getState().toString());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }
}

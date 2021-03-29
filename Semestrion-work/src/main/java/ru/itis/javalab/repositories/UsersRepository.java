package ru.itis.javalab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.javalab.models.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByConfirmCode(String code);

    @Modifying
    @Query("UPDATE User user SET user.state = 'CONFIRMED' WHERE user.confirmCode like concat('%', :code, '%')")
    void updateStatus(@Param("code") String code);
}

package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.User;
import ru.itis.javalab.validation.ValidName;
import ru.itis.javalab.validation.ValidPassword;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReg {
    @ValidName(message = "{errors.incorrect.firstName}")
    private String firstName;
    @ValidName(message = "{errors.incorrect.lastName}")
    private String lastName;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.invalid.password}")
    private String password;


    public static UserReg convert(User user) {
        if (user == null) {
            return null;
        }
        return UserReg.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static List<UserReg> from(List<User> users) {
        return users.stream()
                .map(UserReg::convert)
                .collect(Collectors.toList());
    }

}

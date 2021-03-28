package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.User;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto1 {
    //@Email(message = "{errors.incorrect.email}")
    private String email;
    private String password;


    public static UserDto1 convert(User user) {
        if (user == null) {
            return null;
        }
        return UserDto1.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}

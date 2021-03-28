package ru.itis.javalab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.javalab.models.User;
import ru.itis.javalab.validation.ValidName;
import ru.itis.javalab.validation.ValidPassword;

import javax.validation.constraints.Email;

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

}

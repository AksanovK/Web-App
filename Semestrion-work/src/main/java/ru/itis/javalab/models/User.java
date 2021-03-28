package ru.itis.javalab.models;

import lombok.*;
import ru.itis.javalab.validation.ValidName;
import ru.itis.javalab.validation.ValidPassword;

import javax.validation.constraints.Email;

/**
 * 08.10.2020
 * 05. WebApp
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class User {
    private Long id;
    //@ValidName(message = "{errors.incorrect.firstName}")
    private String firstName;
    //@ValidName(message = "{errors.incorrect.lastName}")
    private String lastName;
    //@Email(message = "{errors.incorrect.email}")
    private String email;
    //@ValidPassword(message = "{errors.invalid.password}")
    private String password;
    private String confirmCode;
    private Status state;
    public enum Status {
        CONFIRMED, UNCONFIRMED;
    }

    public User() {

    }

    /*public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }*/
}

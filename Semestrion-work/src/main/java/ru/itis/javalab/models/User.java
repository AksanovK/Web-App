package ru.itis.javalab.models;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

/**
 * 08.10.2020
 * 05. WebApp
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmCode;

    @Enumerated(EnumType.STRING)
    private Status state;

    public enum Status {
        CONFIRMED, UNCONFIRMED;
    }

}

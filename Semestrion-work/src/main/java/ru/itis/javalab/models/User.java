package ru.itis.javalab.models;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;

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
public class User implements Serializable {

    private static final long serialVersionUID = -4425105781530370352L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private Status state;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State condition;
    public enum State {
        ACTIVE, BANNED
    }
    public enum Role {
        USER, ADMIN
    }
    public enum Status {
        CONFIRMED, UNCONFIRMED;
    }
    public boolean isActive() {
        return this.condition == State.ACTIVE;
    }
    public boolean isBanned() {
        return this.condition == State.BANNED;
    }
    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }
}

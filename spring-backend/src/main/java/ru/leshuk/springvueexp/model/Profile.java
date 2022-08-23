package ru.leshuk.springvueexp.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "P_NAME", nullable = false)
    private String name;

    @Column(name = "P_SURNAME", nullable = false)
    private String surname;

    @Column(name = "P_ALIAS", nullable = false)
    private String alias;

    @Column(name = "P_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "P_PASSWORD", nullable = false)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Profile profile = (Profile) o;
        return id != null && Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

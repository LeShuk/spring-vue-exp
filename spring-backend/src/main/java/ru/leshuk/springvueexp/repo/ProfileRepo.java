package ru.leshuk.springvueexp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leshuk.springvueexp.model.Profile;

import java.util.Optional;

//@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(String email);
}

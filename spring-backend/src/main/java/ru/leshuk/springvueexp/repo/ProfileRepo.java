package ru.leshuk.springvueexp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leshuk.springvueexp.model.Profile;

//@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
}

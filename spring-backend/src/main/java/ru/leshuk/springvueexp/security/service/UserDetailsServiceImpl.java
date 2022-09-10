package ru.leshuk.springvueexp.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.leshuk.springvueexp.model.Profile;
import ru.leshuk.springvueexp.repo.ProfileRepo;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    //todo: роли хранить в БД
    private static final Set<String> ROLES = Set.of("USER");
     private ProfileRepo profileRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Profile> profile = profileRepo.findByEmail(username);

        User.UserBuilder builder;
        if (profile.isPresent()) {
            Profile currentProfile = profile.get();
            builder = User.withUsername(username);
            builder.password(currentProfile.getPassword());
            ROLES.forEach(builder::roles);
        } else {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return builder.build();
    }
}

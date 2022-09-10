package ru.leshuk.springvueexp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.leshuk.springvueexp.exception.NotFoundException;
import ru.leshuk.springvueexp.model.Profile;
import ru.leshuk.springvueexp.repo.ProfileRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/profiles")
public class ProfileController {
    private ProfileRepo profileRepo;

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable Long id) {
        return profileRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Profile saveNewProfile(@RequestBody Profile newProfile) {
        return profileRepo.saveAndFlush(newProfile);
    }

    @PutMapping("/{id}")
    private Profile modifyProfile(@RequestParam Long id, @RequestBody Profile editedProfile) {
//todo: Мне кажется, рассчитывать на исключение в getProfile (ради которого метод тут и вызывается) - плохая идея...
        Profile profileDb = getProfile(id);
        profileDb = editedProfile;
        profileDb.setId(id);
        return profileRepo.saveAndFlush(profileDb);
    }

    @DeleteMapping("/{id}")
    private void deleteProfile(@PathVariable Long id) {
        profileRepo.delete(getProfile(id));
    }
}

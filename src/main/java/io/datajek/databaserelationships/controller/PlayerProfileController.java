package io.datajek.databaserelationships.controller;

import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService profileService;

    @GetMapping
    public List<PlayerProfile> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public PlayerProfile getPlayerProfileById(@PathVariable int id){
      return profileService.getProfileById(id);
    }

    @PostMapping
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile profile){
        return profileService.addPlayerProfile(profile);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable int id){
        profileService.deletePlayerProfile(id);
    }

}

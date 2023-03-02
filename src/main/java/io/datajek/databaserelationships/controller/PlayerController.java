package io.datajek.databaserelationships.controller;


import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetoone.Player;
import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.service.PlayerProfileService;
import io.datajek.databaserelationships.service.PlayerService;
import io.datajek.databaserelationships.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerProfileService profileService;

    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }
    @GetMapping("/{id}")
    public Player getPlayerProfileById(@PathVariable int id){
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player addPlayerProfile(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable int id){
        playerService.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public Player assignProfile(@PathVariable int id, @PathVariable int profile_id){
         PlayerProfile profile = profileService.getProfileById(profile_id);
         return playerService.assignProfile(id, profile);
    }

    @PutMapping("{id}/registrations/{registration_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return playerService.assignRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Player removeRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return playerService.removeRegistration(id, registration);
    }

}

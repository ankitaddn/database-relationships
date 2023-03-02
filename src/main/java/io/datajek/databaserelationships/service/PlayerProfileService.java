package io.datajek.databaserelationships.service;

import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerProfileRepository profileRepository;

    public List<PlayerProfile> getAllProfiles(){
        return profileRepository.findAll();
    }

    public PlayerProfile getProfileById(int id){
        return profileRepository.findById(id).get();
    }
    public PlayerProfile addPlayerProfile(PlayerProfile profile){
        profile.setId(0);
        return profileRepository.save(profile);
    }
    public void deletePlayerProfile(int id){
        PlayerProfile profile = profileRepository.findById(id).get();
        profile.getPlayer().setPlayerProfile(null);
        profile.setPlayer(null);
        profileRepository.save(profile);
        profileRepository.delete(profile);
    }

}

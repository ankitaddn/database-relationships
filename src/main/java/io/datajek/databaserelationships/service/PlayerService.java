package io.datajek.databaserelationships.service;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetoone.Player;
import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player){
        player.setId(0);
        return playerRepository.save(player);
    }

    public Player getPlayerById(int id){
        return playerRepository.findById(id).get();
    }

    public void deletePlayer(int id){
        playerRepository.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile){
        Player player =playerRepository.findById(id).get();
        player.setPlayerProfile(profile);
        return playerRepository.save(player);
    }

    public Player assignRegistration(int id, Registration reg){
        Player player = playerRepository.findById(id).get();
        player.registerPlayer(reg);
        return playerRepository.save(player);
    }

    public Player removeRegistration(int id, Registration reg){
        Player player = playerRepository.findById(id).get();
        player.removeRegistration(reg);
        return playerRepository.save(player);
    }
}

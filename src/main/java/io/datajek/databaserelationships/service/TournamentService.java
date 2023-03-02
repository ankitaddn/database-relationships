package io.datajek.databaserelationships.service;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetomany.Tournament;
import io.datajek.databaserelationships.onetoone.Category;
import io.datajek.databaserelationships.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepo;

    public List<Tournament> getAllTournaments(){
        return tournamentRepo.findAll();
    }

    public Tournament getTournamentById(int id){
        return tournamentRepo.findById(id).get();
    }

    public Tournament addTournament(Tournament tournament){
        tournament.setId(0);
        return tournamentRepo.save(tournament);
    }

    public void deleteTournament(int id){
        tournamentRepo.deleteById(id);
    }

    public Tournament addRegistration(int id, Registration reg){
        Tournament tournament = tournamentRepo.findById(id).get();
        tournament.addRegistration(reg);
        return tournamentRepo.save(tournament);
    }

    public Tournament removeRegistration(int id, Registration reg){
        Tournament tournament = tournamentRepo.findById(id).get();
        tournament.removeRegistration(reg);
        return tournamentRepo.save(tournament);
    }

    public Tournament addCategory(int id, Category category){
        Tournament tournament = getTournamentById(id);
        tournament.addCategory(category);
        return tournamentRepo.save(tournament);
    }
    public Tournament removeCategory(int id, Category category){
        Tournament tournament = getTournamentById(id);
        tournament.removeCategory(category);
        return tournamentRepo.save(tournament);
    }
}

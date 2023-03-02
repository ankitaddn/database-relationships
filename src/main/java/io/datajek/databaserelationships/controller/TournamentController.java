package io.datajek.databaserelationships.controller;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetomany.Tournament;
import io.datajek.databaserelationships.onetoone.Category;
import io.datajek.databaserelationships.service.CategoryService;
import io.datajek.databaserelationships.service.RegistrationService;
import io.datajek.databaserelationships.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable int id){
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament){
        return tournamentService.addTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id){
        tournamentService.deleteTournament(id);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return tournamentService.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegisteration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return tournamentService.removeRegistration(id, registration);
    }

    @PutMapping("/{id}/categories/{category_id}")
    public Tournament addCategory(@PathVariable int id, @PathVariable int category_id){
        Category category = categoryService.getCategoryById(category_id);
        System.out.println(category);
        return tournamentService.addCategory(id, category);
    }

    @PutMapping("/{id}/remove_categories/{category_id}")
    public Tournament removeCategory(@PathVariable int id, @PathVariable int category_id){
        Category category = categoryService.getCategoryById(category_id);
        System.out.println(category);
        return tournamentService.removeCategory(id,category);
    }
}

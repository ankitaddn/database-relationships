package io.datajek.databaserelationships.controller;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @GetMapping
    public List<Registration> getAllRegistrations(){
        return registrationService.getAllRegistrations();
    }

    @GetMapping("{id}")
    public Registration getRegistrationById(@PathVariable int id){
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration reg){
        return registrationService.addRegistration(reg);
    }

    @DeleteMapping("{id}")
    public void deleteRegistration(@PathVariable int id){
        registrationService.deleteRegistration(id);
    }
}

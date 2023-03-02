package io.datajek.databaserelationships.service;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository regRepo;

    public List<Registration> getAllRegistrations(){
        return regRepo.findAll();
    }

    public Registration getRegistrationById(int id){
        return regRepo.findById(id).get();
    }

    public void deleteRegistration(int id){
        regRepo.deleteById(id);
    }

    public Registration addRegistration(Registration reg){
        reg.setId(0);
        return regRepo.save(reg);
    }
}

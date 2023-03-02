package io.datajek.databaserelationships.repository;

import io.datajek.databaserelationships.onetomany.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
}

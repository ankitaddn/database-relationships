package io.datajek.databaserelationships.repository;

import io.datajek.databaserelationships.onetomany.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}

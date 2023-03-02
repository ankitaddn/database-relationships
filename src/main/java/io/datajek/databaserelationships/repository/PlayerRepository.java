package io.datajek.databaserelationships.repository;

import io.datajek.databaserelationships.onetoone.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
}

package io.datajek.databaserelationships.repository;

import io.datajek.databaserelationships.onetoone.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

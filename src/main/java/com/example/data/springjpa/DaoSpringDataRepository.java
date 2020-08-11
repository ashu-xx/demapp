package com.example.data.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoSpringDataRepository
        extends JpaRepository<DaoEntity, Integer> {
}

package com.postgresql.Daruma.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.Daruma.model.Daruma;

@Repository
public interface DarumaRepo extends JpaRepository<Daruma, Integer> {
}

package com.postgresql.Daruma.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.Daruma.model.Color;

@Repository
public interface ColorRepo extends JpaRepository<Color, Integer> {
}

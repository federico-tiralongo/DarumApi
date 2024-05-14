package com.postgresql.Daruma.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.Daruma.model.Skin;

@Repository
public interface SkinRepo extends JpaRepository<Skin, Integer> {
}

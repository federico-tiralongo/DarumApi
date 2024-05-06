package com.postgresql.Daruma.repo;

import com.postgresql.Daruma.model.Skin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinRepo extends JpaRepository<Skin, Long> {
}

package com.postgresql.Daruma.repo;

import com.postgresql.Daruma.model.Skins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinsRepo extends JpaRepository<Skins, Long> {
}

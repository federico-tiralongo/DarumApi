package com.postgresql.Daruma.repo;


import com.postgresql.Daruma.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ColorRepo extends JpaRepository<Color ,Long>{
}

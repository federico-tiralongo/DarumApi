package com.postgresql.Daruma.repo;


import com.postgresql.Daruma.model.Ojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OjoRepo extends JpaRepository<Ojo,Long>{
}

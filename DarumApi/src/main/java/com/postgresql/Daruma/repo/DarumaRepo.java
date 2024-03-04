package com.postgresql.Daruma.repo;


import com.postgresql.Daruma.model.Daruma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DarumaRepo extends JpaRepository<Daruma,Long>{
}

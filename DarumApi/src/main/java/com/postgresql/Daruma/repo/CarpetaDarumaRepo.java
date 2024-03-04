package com.postgresql.Daruma.repo;


import com.postgresql.Daruma.model.Carpetadaruma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarpetaDarumaRepo extends JpaRepository<Carpetadaruma, Long> {
}

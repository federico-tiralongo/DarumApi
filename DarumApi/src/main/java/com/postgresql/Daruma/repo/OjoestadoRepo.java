package com.postgresql.Daruma.repo;


import com.postgresql.Daruma.model.Ojoestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OjoestadoRepo extends JpaRepository<Ojoestado,Long>{
}

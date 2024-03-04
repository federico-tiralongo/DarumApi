package com.postgresql.Daruma.repo;

import com.postgresql.Daruma.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}

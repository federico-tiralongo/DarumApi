package com.postgresql.Daruma.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.Daruma.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByFirebaseUserId(String firebaseUserId);
}

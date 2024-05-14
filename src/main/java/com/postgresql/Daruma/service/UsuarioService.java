package com.postgresql.Daruma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;

import com.postgresql.Daruma.model.Usuario;

public interface UsuarioService {

    void save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    void deleteById(Integer id);

    List<GrantedAuthority> getAuthoritiesByFirebaseUserId(String firebaseUserId) throws Exception;

}

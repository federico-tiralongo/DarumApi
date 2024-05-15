package com.postgresql.Daruma.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.postgresql.Daruma.model.Usuario;
import com.postgresql.Daruma.repo.UsuarioRepo;
import com.postgresql.Daruma.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepo usuarioRepo;

    @Override
    public void save(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public List<GrantedAuthority> getAuthoritiesByFirebaseUserId(String firebaseUserId) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findByFirebaseUserId(firebaseUserId);
        if (usuario.isEmpty()) {
            throw new Exception("User not found");
        }

        List<GrantedAuthority> authorities = Arrays.stream(usuario.get().getAuthorities().split(","))
                // Need to cast each SimpleGrantedAuthority to its supertype
                .map(authorityString -> (GrantedAuthority) new SimpleGrantedAuthority(
                        authorityString))
                .toList();
        return authorities;
    }
}

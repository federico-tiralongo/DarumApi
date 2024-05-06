package com.postgresql.Daruma.Controller;

import com.postgresql.Daruma.model.Usuario;
import com.postgresql.Daruma.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioRepo repo;

    @PostMapping("/usuario")
    public void addUsuario(@RequestBody Usuario usuario) {
        repo.save(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return repo.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @PutMapping("/usuario/{id}")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        usuario.setId(id); // Ensure the ID matches the path variable
        repo.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }
}

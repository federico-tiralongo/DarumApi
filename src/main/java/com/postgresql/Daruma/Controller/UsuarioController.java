package com.postgresql.Daruma.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.Daruma.model.Usuario;
import com.postgresql.Daruma.service.UsuarioService;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public void addUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable("id") Integer id) {
        return usuarioService.findById(id);
    }

    @PutMapping("/usuario/{id}")
    public void updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id); // Ensure the ID matches the path variable
        usuarioService.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable("id") Integer id) {
        usuarioService.deleteById(id);
    }
}

package com.postgresql.Daruma.Controller;

import com.postgresql.Daruma.model.Ojoestado;
import com.postgresql.Daruma.repo.OjoestadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OjoestadoController {

    @Autowired
    OjoestadoRepo repo;

    @PostMapping("/ojoestado")
    public void addOjoestado(@RequestBody Ojoestado ojoestado){repo.save(ojoestado);}

    @GetMapping("/ojoestado")
    public List<Ojoestado> getAllojoestado(){return repo.findAll();}

    @GetMapping("/ojoestado/{id}")
    public Optional<Ojoestado> getojoestadoById(@PathVariable("id") Long id){return repo.findById(id);}

    @PutMapping("/ojoestado/{id}")
    public void updateojoestado(@PathVariable("id") Long id, @RequestBody Ojoestado ojoestado){
        ojoestado.setId(id);
        repo.save(ojoestado);
    }
    @DeleteMapping("/ojoestado/{id}")
    public void deleteojoestado(@PathVariable("id") Long id){repo.deleteById(id);}
}

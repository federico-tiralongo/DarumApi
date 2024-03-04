package com.postgresql.Daruma.Controller;

import com.postgresql.Daruma.model.Ojo;
import com.postgresql.Daruma.repo.OjoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OjoController {

    @Autowired
    OjoRepo repo;

    @PostMapping("/ojo")
    public void addOjo(@RequestBody Ojo ojo){repo.save(ojo);}

    @GetMapping("/ojo")
    public List<Ojo> getAllojo(){return repo.findAll();}

    @GetMapping("/ojo/{id}")
    public Optional<Ojo> getojoById(@PathVariable("id") Long id){return repo.findById(id);}

    @PutMapping("/ojo/{id}")
    public void updateojo(@PathVariable("id") Long id, @RequestBody Ojo ojo){
        ojo.setId(id);
        repo.save(ojo);
    }
    @DeleteMapping("/ojo/{id}")
    public void deleteojo(@PathVariable("id") Long id){repo.deleteById(id);}
}

package com.postgresql.Daruma.Controller;


import com.postgresql.Daruma.model.Carpetadaruma;
import com.postgresql.Daruma.repo.CarpetaDarumaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarpetaDarumaController {

    @Autowired
    CarpetaDarumaRepo repo;

    @PostMapping("/carpetadaruma")
    public void addCarpetaDaruma(@RequestBody Carpetadaruma carpetadaruma){repo.save(carpetadaruma);}

    @GetMapping("/carpetadaruma")
    public List<Carpetadaruma> getAllCarpetaDaruma(){return repo.findAll();}

    @GetMapping("/carpetadaruma/{id}")
    public Optional<Carpetadaruma> getCarpetadarumaById(@PathVariable("id") Long id){return repo.findById(id);}

    @PutMapping("/carpetadaruma/{id}")
    public void updateCarpetadaruma(@PathVariable("id") Long id, @RequestBody Carpetadaruma carpetadaruma){
        carpetadaruma.setId(id);
        repo.save(carpetadaruma);
    }
    @DeleteMapping("/carpetadaruma/{id}")
    public void deleteCarpetadaruma(@PathVariable("id") Long id){repo.deleteById(id);}
}

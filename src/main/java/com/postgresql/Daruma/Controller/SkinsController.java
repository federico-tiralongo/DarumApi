package com.postgresql.Daruma.Controller;

import com.postgresql.Daruma.model.Skins;
import com.postgresql.Daruma.repo.SkinsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SkinsController {

    @Autowired
    SkinsRepo repo;

    @PostMapping("/skin")
    public void addskins(@RequestBody Skins skins) {
        repo.save(skins);
    }

    @GetMapping("/skin")
    public List<Skins> getAllskins() {
        return repo.findAll();
    }

    @GetMapping("/skin/{id}")
    public Optional<Skins> getskinsById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @PutMapping("/skin/{id}")
    public void updateskins(@PathVariable("id") Long id, @RequestBody Skins skins) {
        skins.setId(id);
        repo.save(skins);
    }

    @DeleteMapping("/skin/{id}")
    public void deleteskins(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }
}

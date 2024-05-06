package com.postgresql.Daruma.Controller;

import com.postgresql.Daruma.model.Skin;
import com.postgresql.Daruma.repo.SkinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SkinController {

    @Autowired
    SkinRepo repo;

    @PostMapping("/skin")
    public void addskins(@RequestBody Skin skins) {
        repo.save(skins);
    }

    @GetMapping("/skin")
    public List<Skin> getAllskins() {
        return repo.findAll();
    }

    @GetMapping("/skin/{id}")
    public Optional<Skin> getskinsById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @PutMapping("/skin/{id}")
    public void updateskins(@PathVariable("id") Long id, @RequestBody Skin skins) {
        skins.setId(id);
        repo.save(skins);
    }

    @DeleteMapping("/skin/{id}")
    public void deleteskins(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }
}

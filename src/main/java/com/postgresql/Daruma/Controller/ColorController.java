package com.postgresql.Daruma.Controller;

import com.postgresql.Daruma.model.Color;
import com.postgresql.Daruma.repo.ColorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ColorController {

    @Autowired
    ColorRepo repo;

    @PostMapping("/color")
    public void addColor(@RequestBody Color color) {
        repo.save(color);
    }

    @GetMapping("/color")
    public List<Color> getAllcolor() {
        return repo.findAll();
    }

    @GetMapping("/color/{id}")
    public Optional<Color> getcolorById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @PutMapping("/color/{id}")
    public void updatecolor(@PathVariable("id") Long id, @RequestBody Color color) {
        color.setId(id);
        repo.save(color);
    }

    @DeleteMapping("/color/{id}")
    public void deletecolor(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }
}

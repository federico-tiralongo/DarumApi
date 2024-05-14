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

import com.postgresql.Daruma.model.Color;
import com.postgresql.Daruma.service.ColorService;

@RestController
@CrossOrigin
public class ColorController {

    @Autowired
    ColorService colorService;

    @PostMapping("/color")
    public void addColor(@RequestBody Color color) {
        colorService.save(color);
    }

    @GetMapping("/color")
    public List<Color> getAllcolor() {
        return colorService.findAll();
    }

    @GetMapping("/color/{id}")
    public Optional<Color> getcolorById(@PathVariable("id") Integer id) {
        return colorService.findById(id);
    }

    @PutMapping("/color/{id}")
    public void updatecolor(@PathVariable("id") Integer id, @RequestBody Color color) {
        color.setId(id);
        colorService.save(color);
    }

    @DeleteMapping("/color/{id}")
    public void deletecolor(@PathVariable("id") Integer id) {
        colorService.deleteById(id);
    }
}

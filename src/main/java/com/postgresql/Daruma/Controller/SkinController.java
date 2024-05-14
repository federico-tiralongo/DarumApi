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

import com.postgresql.Daruma.model.Skin;
import com.postgresql.Daruma.service.SkinService;

@RestController
@CrossOrigin
public class SkinController {

    @Autowired
    SkinService skinService;

    @PostMapping("/skin")
    public void addskins(@RequestBody Skin skin) {
        skinService.save(skin);
    }

    @GetMapping("/skin")
    public List<Skin> getAllskins() {
        return skinService.findAll();
    }

    @GetMapping("/skin/{id}")
    public Optional<Skin> getskinsById(@PathVariable("id") Integer id) {
        return skinService.findById(id);
    }

    @PutMapping("/skin/{id}")
    public void updateskins(@PathVariable("id") Integer id, @RequestBody Skin skin) {
        skin.setId(id);
        skinService.save(skin);
    }

    @DeleteMapping("/skin/{id}")
    public void deleteskins(@PathVariable("id") Integer id) {
        skinService.deleteById(id);
    }
}

package com.postgresql.Daruma.Controller;

import java.util.Timer;
import java.util.TimerTask;

import com.postgresql.Daruma.model.Daruma;
import com.postgresql.Daruma.repo.DarumaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DarumaController {

    @Autowired
    DarumaRepo repo;

    @PostMapping("/daruma")
    public void addDaruma(@RequestBody Daruma daruma){
        repo.save(daruma);
        //con esta funcion pasado un tiempo te borra de forma automatica el Daruma
        scheduleDeleteTask(daruma.getId());
    }

    @GetMapping("/daruma")
    public List<Daruma> getAlldaruma(){return repo.findAll();}

    @GetMapping("/daruma/{id}")
    public Optional<Daruma> getdarumaById(@PathVariable("id") Long id){return repo.findById(id);}

    @PutMapping("/daruma/{id}")
    public void updatedaruma(@PathVariable("id") Long id, @RequestBody Daruma daruma){
        daruma.setId(id);
        repo.save(daruma);
    }
    @DeleteMapping("/daruma/{id}")
    public void deletedaruma(@PathVariable("id") Long id){repo.deleteById(id);}

    @DeleteMapping
    private void scheduleDeleteTask(Long darumaId) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repo.deleteById(darumaId);
                timer.cancel(); // Cancelar el timer después de la ejecución
            }
        }, 365 * 24 * 60 * 60 * 1000); // 30 segundos en milisegundos
    }
}

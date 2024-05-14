package com.postgresql.Daruma.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.Daruma.model.Daruma;
import com.postgresql.Daruma.service.DarumaService;

@RestController
@CrossOrigin
public class DarumaController {

    @Autowired
    DarumaService darumaService;

    @PostMapping("/daruma")
    public void addDaruma(@RequestBody Daruma daruma) {
        darumaService.save(daruma);
        // con esta funcion pasado un tiempo te borra de forma automatica el Daruma
        scheduleDeleteTask(daruma.getId());
    }

    @GetMapping("/daruma")
    public List<Daruma> getAlldaruma() {
        return darumaService.findAll();
    }

    @GetMapping("/daruma/{id}")
    public Optional<Daruma> getdarumaById(@PathVariable("id") Integer id) {
        return darumaService.findById(id);
    }

    @PutMapping("/daruma/{id}")
    public void updatedaruma(@PathVariable("id") Integer id, @RequestBody Daruma daruma) {
        daruma.setId(id);
        darumaService.save(daruma);
    }

    @DeleteMapping("/daruma/{id}")
    public void deletedaruma(@PathVariable("id") Integer id) {
        darumaService.deleteById(id);
    }

    @DeleteMapping
    private void scheduleDeleteTask(Integer darumaId) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                darumaService.deleteById(darumaId);
                timer.cancel(); // Cancelar el timer después de la ejecución
            }
        }, 365 * 24 * 60 * 60 * 1000); // 30 segundos en milisegundos
    }
}

package com.postgresql.Daruma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postgresql.Daruma.model.Color;
import com.postgresql.Daruma.repo.ColorRepo;
import com.postgresql.Daruma.service.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final ColorRepo colorRepo;

    @Override
    public void save(Color color) {
        colorRepo.save(color);
    }

    @Override
    public List<Color> findAll() {
        return colorRepo.findAll();
    }

    @Override
    public Optional<Color> findById(Integer id) {
        return colorRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        colorRepo.deleteById(id);
    }

}

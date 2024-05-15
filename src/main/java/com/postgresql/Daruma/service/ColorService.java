package com.postgresql.Daruma.service;

import java.util.List;
import java.util.Optional;

import com.postgresql.Daruma.model.Color;

public interface ColorService {

    void save(Color color);

    List<Color> findAll();

    Optional<Color> findById(Integer id);

    void deleteById(Integer id);

}

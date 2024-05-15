package com.postgresql.Daruma.service;

import java.util.List;
import java.util.Optional;

import com.postgresql.Daruma.model.Daruma;

public interface DarumaService {

    void save(Daruma daruma);

    List<Daruma> findAll();

    Optional<Daruma> findById(Integer id);

    void deleteById(Integer id);

}

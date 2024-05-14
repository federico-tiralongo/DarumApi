package com.postgresql.Daruma.service;

import java.util.List;
import java.util.Optional;

import com.postgresql.Daruma.model.Skin;

public interface SkinService {

    void save(Skin skin);

    List<Skin> findAll();

    Optional<Skin> findById(Integer id);

    void deleteById(Integer id);

}

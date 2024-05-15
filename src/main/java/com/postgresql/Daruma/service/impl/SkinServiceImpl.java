package com.postgresql.Daruma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postgresql.Daruma.model.Skin;
import com.postgresql.Daruma.repo.SkinRepo;
import com.postgresql.Daruma.service.SkinService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkinServiceImpl implements SkinService {

    private final SkinRepo skinRepo;

    @Override
    public void save(Skin skin) {
        skinRepo.save(skin);
    }

    @Override
    public List<Skin> findAll() {
        return skinRepo.findAll();
    }

    @Override
    public Optional<Skin> findById(Integer id) {
        return skinRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        skinRepo.deleteById(id);
    }

}

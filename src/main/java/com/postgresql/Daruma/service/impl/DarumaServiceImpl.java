package com.postgresql.Daruma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postgresql.Daruma.model.Daruma;
import com.postgresql.Daruma.repo.DarumaRepo;
import com.postgresql.Daruma.service.DarumaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DarumaServiceImpl implements DarumaService {

    private final DarumaRepo darumaRepo;

    @Override
    public void save(Daruma daruma) {
        darumaRepo.save(daruma);
    }

    @Override
    public List<Daruma> findAll() {
        return darumaRepo.findAll();
    }

    @Override
    public Optional<Daruma> findById(Integer id) {
        return darumaRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        darumaRepo.deleteById(id);
    }

}

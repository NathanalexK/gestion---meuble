package com.source.meuble.talent.diplome;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    public List<Diplome> findAll(){
        return diplomeRepository.findAll();
    }

    public Optional<Diplome> findById(Integer id){ return diplomeRepository.findById(id); }
}

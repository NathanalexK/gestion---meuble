package com.source.meuble.talent.diplome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    List<Diplome> findAll(){
        return diplomeRepository.findAll();
    }

}

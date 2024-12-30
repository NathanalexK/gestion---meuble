package com.source.meuble.etatFinancier.Poste;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService {

    private final PosteRepository posteRepository;

    public PosteService(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    public List<Poste> findAllPoste() {
        return posteRepository.findAll();
    }
}

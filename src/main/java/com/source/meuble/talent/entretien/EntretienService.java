package com.source.meuble.talent.entretien;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntretienService {
    private final EntretienRepository entretienRepository;

    public EntretienService(EntretienRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

}

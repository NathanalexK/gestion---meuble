package com.source.meuble.etatFinancier.nomPoste;

import com.source.meuble.analytique.exercice.Exercice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomPosteService {

    private final NomPosteRepository nomPosteRepository;

    public NomPosteService(NomPosteRepository nomPosteRepository) {
        this.nomPosteRepository = nomPosteRepository;
    }

    public List<NomPoste> findAllNomPoste() {
        return nomPosteRepository.findAll();
    }

    public List<NomPoste> findByPosteMere(int idPosteMere, Exercice exercice) {
        return nomPosteRepository.findAllPerso(exercice.getId(),idPosteMere);
    }
}

package com.source.meuble.talent.recrutement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecrutementService {

    @Autowired
    private RecrutementRepository recrutementRepository;

    public Recrutement save(Recrutement r){
        return recrutementRepository.save(r);
    }

    public List<Recrutement> findAllEnCours(){
        return recrutementRepository.findAllEnCours();
    }

    public Optional<Recrutement> findById(Integer id){
        return recrutementRepository.findById(id);
    }

}

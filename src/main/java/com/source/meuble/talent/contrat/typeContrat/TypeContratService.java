package com.source.meuble.talent.contrat.typeContrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeContratService {
    @Autowired
    TypeContratRepository typeContratRepository;

    public Optional<TypeContrat> getById(int id)throws Exception
    {
        return typeContratRepository.findById(id);
    }
}

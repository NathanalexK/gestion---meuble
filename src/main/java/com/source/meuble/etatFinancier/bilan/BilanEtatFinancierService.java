package com.source.meuble.etatFinancier.bilan;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.PosteCplRepository;
import com.source.meuble.etatFinancier.posteFille.PosteFilleRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class BilanEtatFinancierService {

    private final PosteCplRepository posteCplRepository;
    private final PosteFilleRepository posteFilleRepository;

    public BilanEtatFinancierService(PosteCplRepository posteCplRepository, PosteFilleRepository posteFilleRepository) {
        this.posteCplRepository = posteCplRepository;
        this.posteFilleRepository = posteFilleRepository;
    }


//    public BilanEtatFinancier getBilanEtatFinancier(Exercice exercice){
//        posteFilleRepository.findAllByExercice(exercice);
//
//
//    }
}

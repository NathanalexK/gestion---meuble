package com.source.meuble.etatFinancier.bilan;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.PosteCplRepository;
import com.source.meuble.etatFinancier.posteFille.PosteFilleRepository;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BilanEtatFinancierService {

    private final PosteCplRepository posteCplRepository;
    private final PosteFilleRepository posteFilleRepository;
    private final JdbcTemplate jdbcTemplate;

    public BilanEtatFinancierService(PosteCplRepository posteCplRepository, PosteFilleRepository posteFilleRepository, JdbcTemplate jdbcTemplate) {
        this.posteCplRepository = posteCplRepository;
        this.posteFilleRepository = posteFilleRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public BilanEtatFinancier getBilanEtatFinancier(Exercice exercice){
        BilanEtatFinancier bilan = new BilanEtatFinancierImpl(jdbcTemplate, exercice.getId());
        return bilan;
//        posteFilleRepository.findAllByExercice(exercice);


    }
}

package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteFilleService {
    @Autowired
    private PosteFilleRepository posteFilleRepository;

    List<PosteFilleSelectDTO> findByIdMereAndExercice(Integer idMere, Exercice exercie){
        return posteFilleRepository.findByIdMereAndIdExercice(idMere, exercie);
    }

    List<PosteFilleSelectDTO> findByCompteAndExercice(Integer compte, Exercice exercie){
        return posteFilleRepository.findByCompteAndIdExercice(compte, exercie);
    }

    public PosteFille save(PosteFille posteFille){
        return posteFilleRepository.save(posteFille);
    }

    public Optional<PosteFille> findByCompte(String s){
        Integer compte = Integer.parseInt(s);
        return posteFilleRepository.findByCompte(compte);
    }
}

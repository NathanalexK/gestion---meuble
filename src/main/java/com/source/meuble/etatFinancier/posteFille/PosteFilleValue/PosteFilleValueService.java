package com.source.meuble.etatFinancier.posteFille.PosteFilleValue;

import com.source.meuble.etatFinancier.posteFille.PosteFilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PosteFilleValueService {

    @Autowired
    private PosteFilleValueRepository posteFilleValueRepository;

    public PosteFilleValue save(PosteFilleValue posteFilleValue){
        return posteFilleValueRepository.save(posteFilleValue);
    }

    public void deleteByCompte(Integer compte){
        posteFilleValueRepository.deleteByCompte(compte);
    }

    public Optional<PosteFilleValue> findById(Integer id){
        return posteFilleValueRepository.findById(id);
    }
}

package com.source.meuble.etatFinancier.posteFille.PosteFilleValue;

import com.source.meuble.etatFinancier.posteFille.PosteFilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosteFilleValueService {

    @Autowired
    private PosteFilleValueRepository posteFilleValueRepository;

    public PosteFilleValue save(PosteFilleValue posteFilleValue){
        return posteFilleValueRepository.save(posteFilleValue);
    }
}

package com.source.meuble.etatFinancier;

import com.source.meuble.etatFinancier.Poste.PosteCpl;
import com.source.meuble.etatFinancier.Poste.PosteCplRepository;
import com.source.meuble.etatFinancier.Poste.PosteRepository;
import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.posteFille.PosteFilleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatFinancierService {

    private final PosteRepository posteRepository;
    private final PosteFilleRepository posteFilleRepository;
    private final PosteCplRepository posteCplRepository;

    public EtatFinancierService(PosteRepository posteRepository,
                                PosteFilleRepository posteFilleRepository,
                                PosteCplRepository posteCplRepository) {
        this.posteRepository = posteRepository;
        this.posteFilleRepository = posteFilleRepository;
        this.posteCplRepository = posteCplRepository;
    }

    public EtatFinancierDTO build() {
        EtatFinancierDTO ef = new EtatFinancierDTO();
        List<PosteCpl> bilan = posteCplRepository.findByIdMere_CategorieLessThanEqual(1);
        List<PosteCpl> resultat = posteCplRepository.findByIdMere_Categorie(2);

        ef.setResultatNet(resultat.get(0).getTotal() - resultat.get(1).getTotal());
        ef.setBilan(bilan);
        ef.setResultat(resultat);
        return ef;
    }
}

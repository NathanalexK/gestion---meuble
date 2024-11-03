package com.source.meuble.vente.BonLivraison.BonLivraisonFille;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonLivraisonFilleService {

    private final BonLivraisonFilleRepository bonLivraisonFilleRepository;

    @Autowired
    public BonLivraisonFilleService(BonLivraisonFilleRepository bonLivraisonFilleRepository) {
        this.bonLivraisonFilleRepository = bonLivraisonFilleRepository;
    }

    public List<BonLivraisonFille> findAll() {
        return bonLivraisonFilleRepository.findAll();
    }

    public Optional<BonLivraisonFille> findById(Integer id) {
        return bonLivraisonFilleRepository.findById(id);
    }




    public BonLivraisonFille save(BonLivraisonFille bonLivraisonFille) {
        return bonLivraisonFilleRepository.save(bonLivraisonFille);
    }

    public void deleteById(Integer id) {
        bonLivraisonFilleRepository.deleteById(id);
    }

}

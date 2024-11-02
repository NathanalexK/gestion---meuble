package com.source.meuble.vente.BonLivraison;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison, Integer> {

}


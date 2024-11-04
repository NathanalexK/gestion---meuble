package com.source.meuble.vente.BonLivraison;

import com.source.meuble.achat.bonCommande.BonCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison, Integer> {

    @Query("select bl from BonLivraison bl where ((:role like 'DEPT_FINANCE' and bl.etat = 0) or (:role like 'DIRECTION' and bl.etat = 1))")
    List<BonLivraison> findAllByRole(String role);


}


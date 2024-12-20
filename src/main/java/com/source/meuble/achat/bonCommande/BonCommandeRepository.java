package com.source.meuble.achat.bonCommande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonCommandeRepository extends JpaRepository<BonCommande, Integer> {

    @Query("select bc from BonCommande bc where ((:role like 'DEPT_FINANCE' and bc.etat = 0) or (:role like 'DIRECTION' and bc.etat = 1)) and bc.idFournisseur is not null")
    List<BonCommande> findAllByRole(String role);

    @Query("select bc from BonCommande bc where ((:role like 'DEPT_FINANCE' and bc.etat = 0) or (:role like 'DIRECTION' and bc.etat = 1)) and bc.idClient is not null")
    List<BonCommande> findAllByRoleClient(String role);

    @Query("select b from BonCommande b where b.idClient is not null")
    List<BonCommande> findByIdClientNotNull();

    @Query("select b from BonCommande b where b.idFournisseur is not null")
    List<BonCommande> findByIdFournisseurNotNull();

    @Query("select bc from BonCommande bc order by bc.id desc")
    List<BonCommande> findAll();
}

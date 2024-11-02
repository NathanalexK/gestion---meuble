package com.source.meuble.vente.BonLivraison.BonLivraisonFille;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonFilleRepository extends JpaRepository<BonLivraisonFille, Integer> {

    List<BonLivraisonFille> findByIdBl_Id(Integer id);
}


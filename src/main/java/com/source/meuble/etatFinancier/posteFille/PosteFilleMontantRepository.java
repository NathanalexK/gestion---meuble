package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PosteFilleMontantRepository extends JpaRepository<PosteFilleMontant, Integer> {
    @Query(value = "SELECT sum(montant) " +
            "FROM v_poste_fille_montant " +
            "WHERE CAST(compte AS TEXT) LIKE '6%'", nativeQuery = true)
    Double sommeCharge();

    @Query(value = "SELECT sum(montant) " +
            "FROM v_poste_fille_montant " +
            "WHERE CAST(compte AS TEXT) LIKE '7%'", nativeQuery = true)
    Double sommeProduit();
}
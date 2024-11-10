package com.source.meuble.achat.proformat;

import com.source.meuble.analytique.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProformatRepository extends JpaRepository<Proformat, Integer> {
    @Query("select p from Proformat p where p.idClient is not null and p.idFournisseur is null")
    List<Proformat> findByIdClientNotNull();

    @Query("select p from Proformat p where p.idFournisseur is not null and p.idClient is null")
    List<Proformat> findByIdFournisseurNotNullAndIdClientNull();

    @Query("select p from Proformat p inner join p.filles filles where filles.idMarchandise.type = ?1")
    List<Proformat> findByFilles_IdMarchandise_Type(Integer type);
}
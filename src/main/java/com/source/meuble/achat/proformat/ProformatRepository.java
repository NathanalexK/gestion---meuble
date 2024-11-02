package com.source.meuble.achat.proformat;

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
}
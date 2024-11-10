package com.source.meuble.achat.Facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

    @Query("select f from Facture f order by f.id desc")
    List<Facture> findAll();
}


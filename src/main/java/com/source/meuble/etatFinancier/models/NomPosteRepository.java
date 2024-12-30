package com.source.meuble.etatFinancier.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomPosteRepository extends JpaRepository<NomPoste, Integer> {

    @Query("select n from NomPoste n where n.idPosteMere = ?1")
    List<NomPoste> findByIdPosteMere(Integer idPosteMere);
}

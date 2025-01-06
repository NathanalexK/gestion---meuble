package com.source.meuble.etatFinancier.nomPoste;

import com.source.meuble.analytique.centre.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomPosteRepository extends JpaRepository<NomPoste, Integer> {

    @Query("select n from NomPoste n where n.idPosteMere = ?1")
    List<NomPoste> findByIdPosteMere(Integer idPosteMere);

    @Query(value = "select * from nom_poste where libelle not in (select libelle from poste_fille where id_exercice=:idExercice) and id_poste_mere=:idPoste;", nativeQuery = true)
    List<NomPoste> findAllPerso(int idExercice, int idPoste);
}

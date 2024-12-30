package com.source.meuble.etatFinancier.Poste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> {

    @Query("select p from Poste p where p.categorie <= ?1")
    List<Poste> findByCategorieLessThanEqual(Integer categorie);

    @Query("select p from Poste p where p.categorie = ?1")
    List<Poste> findByCategorie(Integer categorie);
}

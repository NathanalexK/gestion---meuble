package com.source.meuble.etatFinancier.Poste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosteCplRepository extends JpaRepository<PosteCpl, Integer> {

    @Query("select p from PosteCpl p where p.idMere.categorie <= ?1")
    List<PosteCpl> findByIdMere_CategorieLessThanEqual(Integer categorie);

    @Query("select p from PosteCpl p where p.idMere.categorie = ?1")
    List<PosteCpl> findByIdMere_Categorie(Integer categorie);
}
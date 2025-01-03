package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosteFilleRepository extends JpaRepository<PosteFille, Integer> {
    @Query("select p from PosteFille p where p.idMere = ?1")
    List<PosteFille> findByIdMere(Poste idMere);

    @Query("select p from PosteFille p where p.libelle = ?1")
    List<PosteFille> findByLibelle(String libelle);

    @Query("select p from PosteFille p where p.id <> ?1")
    List<PosteFille> findByIdNot(Integer id);

    @Query("SELECT pf FROM PosteFille pf WHERE pf.idExercice = ?1 ")
    List<PosteFille> findAllByExercice(Exercice e);

}
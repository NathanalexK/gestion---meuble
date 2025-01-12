package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.analytique.centre.Centre;
import com.source.meuble.analytique.exercice.Exercice;
import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PosteFilleRepository extends JpaRepository<PosteFille, Integer> {
    @Query("select p from PosteFille p where p.idMere = ?1")
    List<PosteFille> findByIdMere(Poste idMere);

    @Query("select p from PosteFille p where p.libelle = ?1")
    List<PosteFille> findByLibelle(String libelle);

    @Query("select p from PosteFille p where p.id <> ?1")
    List<PosteFille> findByIdNot(Integer id);


    @Query("SELECT new com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO(p.compte, p.libelle) " +
            "FROM PosteFille p " +
            "WHERE p.idMere.id = :idMere " +
            "AND p.id NOT IN (SELECT pv2.compte FROM PosteFilleValue pv2 where pv2.idExercice = :idExercice) ")
    List<PosteFilleSelectDTO> findByIdMereAndIdExercice(@Param("idMere") Integer idMere, @Param("idExercice") Exercice idExercice);


    @Query("SELECT new com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO(p.compte, p.libelle) " +
            "FROM PosteFille p " +
            "WHERE p.compteMere.compte = :compte " +
            "AND p.id NOT IN (SELECT pv2.compte FROM PosteFilleValue pv2 WHERE pv2.idExercice = :idExercice) ")
    List<PosteFilleSelectDTO> findByCompteAndIdExercice(@Param("compte") Integer idCompte, @Param("idExercice") Exercice idExercice);

    @Query("SELECT p from PosteFille p WHERE p.compte = :compte")
    Optional<PosteFille> findByCompte(@Param("compte") Integer compte);

}
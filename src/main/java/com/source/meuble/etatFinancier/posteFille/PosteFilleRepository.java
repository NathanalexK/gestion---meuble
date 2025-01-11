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

    @Query("SELECT pf FROM PosteFille pf WHERE pf.idExercice = ?1 ")
    List<PosteFille> findAllByExercice(Exercice e);

    @Query(value = "select nom_poste.libelle,poste_fille.id_poste_fille, nom_poste.id_poste_mere as id_mere, poste_fille.id_exercice,coalesce(poste_fille.montant, 0) as montant from nom_poste left join poste_fille" +
            "on nom_poste.libelle = poste_fille.libelle;", nativeQuery = true)
    List<Centre> findAllFor(int categ);

    @Query("SELECT new com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO(p.compte, p.libelle) FROM PosteFille p WHERE p.idMere.id = :idMere AND p.idExercice = :idExercice AND p.montant = 0")
    List<PosteFilleSelectDTO> findByIdMereAndIdExercice(@Param("idMere") Integer idMere, @Param("idExercice") Exercice idExercice);

    @Query("SELECT new com.source.meuble.etatFinancier.posteFille.utils.PosteFilleSelectDTO(p.compte, p.libelle) FROM PosteFille p WHERE p.compteMere.compte = :compte AND p.idExercice = :idExercice AND p.montant = 0")
    List<PosteFilleSelectDTO> findByCompteAndIdExercice(@Param("compte") Integer idCompte, @Param("idExercice") Exercice idExercice);

    @Query("SELECT p from PosteFille p WHERE p.compte = :compte")
    Optional<PosteFille> findByCompte(@Param("compte") Integer compte);
}
package com.source.meuble.etatFinancier.Poste;

import com.source.meuble.analytique.exercice.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosteCplRepository extends JpaRepository<PosteCpl, Integer> {

    @Query("select p from PosteCpl p where p.idMere.categorie <= ?1")
    List<PosteCpl> findByIdMere_CategorieLessThanEqual(Integer categorie);

    @Query("select p from PosteCpl p where p.idMere.categorie = ?1")
    List<PosteCpl> findByIdMere_Categorie(Integer categorie);

    /*@Query("""
            select p from PosteCpl p inner join p.idMere.posteFilles posteFilles
            where p.idMere.categorie <= ?1 and posteFilles.idExercice = ?2""")
    List<PosteCpl> findByIdMere_CategorieLessThanEqualAndIdMere_PosteFilles_IdExercice(Integer categorie, Exercice idExercice);*/

    @Query("""
            select p from PosteCpl p inner join p.idMere.posteFilles posteFilles join PosteFilleValue pv on posteFilles.id = pv.compte
            where p.idMere.categorie = ?1 and pv.idExercice = ?2""")
    List<PosteCpl> findByIdMere_CategorieAndIdMere_PosteFilles_IdExercice(Integer categorie, Exercice idExercice);

    @Query("""
            select p from PosteCpl p inner join p.idMere.posteFilles posteFilles join PosteFilleValue pv on posteFilles.id = pv.compte
            where p.idMere.id = ?1 and pv.idExercice = ?2""")
    List<PosteCpl> findByIdMere_idAndIdMere_PosteFilles_IdExercice(Integer id, Exercice idExercice);

    @Query("select sum(p.total) from PosteCpl p where p.idMere.categorie = ?1")
    Double sumTotalByCategorie(Integer categorie);

    @Query("select p from PosteCpl p where p.idMere.id = ?1")
    List<PosteCpl> findByIdMere_Id(Integer id);
}
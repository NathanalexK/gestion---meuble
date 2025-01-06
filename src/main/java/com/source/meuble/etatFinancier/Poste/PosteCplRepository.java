package com.source.meuble.etatFinancier.Poste;

import com.source.meuble.analytique.exercice.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PosteCplRepository extends JpaRepository<PosteCpl, Integer> {

    @Query("select p from PosteCpl p where p.idMere.categorie <= ?1")
    List<PosteCpl> findByIdMere_CategorieLessThanEqual(Integer categorie);

//    @Query("select p from PosteCpl p where p.idMere.categorie = ?1")
//    List<PosteCpl> findByIdMere_Categorie(Integer categorie);

    @Query(value = """
        select row_number() over () as id, poste.id_poste as id_mere , coalesce(default_cpl.total, 0) as total from poste left join
        (SELECT row_number() OVER ()     AS id,
              poste_fille.id_mere,
              sum(poste_fille.montant) AS total
        FROM poste_fille
        WHERE id_exercice=:idExercice
        GROUP BY poste_fille.id_mere) as default_cpl
        on poste.id_poste = default_cpl.id_mere
        where categorie=:categorie
    """, nativeQuery = true)
    List<PosteCpl> findByIdMere_Categorie(@Param("idExercice") int idExercice, @Param("categorie") int categorie );

    @Query("""
            select p from PosteCpl p inner join p.idMere.posteFilles posteFilles
            where p.idMere.categorie <= ?1 and posteFilles.idExercice = ?2""")
    List<PosteCpl> findByIdMere_CategorieLessThanEqualAndIdMere_PosteFilles_IdExercice(Integer categorie, Exercice idExercice);

    @Query("""
            select p from PosteCpl p inner join p.idMere.posteFilles posteFilles
            where p.idMere.categorie = ?1 and posteFilles.idExercice = ?2""")
    List<PosteCpl> findByIdMere_CategorieAndIdMere_PosteFilles_IdExercice(Integer categorie, Exercice idExercice);
}
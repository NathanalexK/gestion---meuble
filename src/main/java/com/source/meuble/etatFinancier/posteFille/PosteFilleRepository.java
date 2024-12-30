package com.source.meuble.etatFinancier.posteFille;

import com.source.meuble.etatFinancier.Poste.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosteFilleRepository extends JpaRepository<PosteFille, Integer> {
    @Query("select p from PosteFille p where p.idMere = ?1")
    List<PosteFille> findByIdMere(Poste idMere);
}
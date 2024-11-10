package com.source.meuble.talent.recrutement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecrutementRepository extends JpaRepository<Recrutement, Integer> {

    @Query(value = "SELECT * FROM besoin_recrutement WHERE etat = 0", nativeQuery = true)
    List<Recrutement> findAllEnCours();

}

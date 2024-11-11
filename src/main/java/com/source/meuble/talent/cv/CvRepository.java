package com.source.meuble.talent.cv;

import com.source.meuble.talent.offreEmploi.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {
    @Query("select c from Cv c where c.idOffreEmploi = ?1")
    List<Cv> findByIdOffreEmploi(OffreEmploi idOffreEmploi);



}

package com.source.meuble.talent.offreEmploi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OffreEmploiRepository extends JpaRepository<OffreEmploi, Integer> {


}

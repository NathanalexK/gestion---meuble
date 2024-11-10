package com.source.meuble.talent.Publicite;

import com.source.meuble.talent.offreEmploi.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurPubRepository extends JpaRepository<FournisseurPub, Integer> {

}

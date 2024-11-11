package com.source.meuble.talent.contrat.typeContrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeContratRepository extends JpaRepository<TypeContrat, Integer> {
}

package com.source.meuble.talent.contrat.ContratEmploye;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<ContratEmploye, Integer> {
}

package com.source.meuble.talent.entretien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntretienRepository extends JpaRepository<Entretien, Integer> {
    List<Entretien> findByEtat(Integer etat);
}
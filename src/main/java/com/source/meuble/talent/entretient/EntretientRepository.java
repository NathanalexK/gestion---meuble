package com.source.meuble.talent.entretient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretientRepository extends JpaRepository<Entretient, Integer> {

}

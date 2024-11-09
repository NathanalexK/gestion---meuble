package com.source.meuble.talent.diplome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {

    @Query("SELECT d from Diplome d")
    List<Diplome> findAll();
}

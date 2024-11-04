package com.source.meuble.achat.BonReception;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonReceptionRepository extends JpaRepository<BonReception, Integer> {

    @Query("select br from BonReception br order by br.id desc")
    List<BonReception> findAll();
}


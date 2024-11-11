package com.source.meuble.talent.test.resultatTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatTestRepository extends JpaRepository<ResultatTest, Integer> {
}
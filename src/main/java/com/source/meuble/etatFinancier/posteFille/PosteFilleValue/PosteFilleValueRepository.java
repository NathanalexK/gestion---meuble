package com.source.meuble.etatFinancier.posteFille.PosteFilleValue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PosteFilleValueRepository extends JpaRepository<PosteFilleValue, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM PosteFilleValue p WHERE p.compte = :compte")
    void deleteByCompte(@Param("compte") Integer compte);

    @Query("select p from PosteFilleValue p where p.compte = ?1")
    Optional<PosteFilleValue> findByCompte(Integer compte);
}


package com.source.meuble.talent.personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository  extends JpaRepository<Personnel, Integer> {
}

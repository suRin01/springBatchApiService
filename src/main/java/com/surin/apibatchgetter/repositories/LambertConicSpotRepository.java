package com.surin.apibatchgetter.repositories;

import com.surin.apibatchgetter.entities.LambertConicSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LambertConicSpotRepository extends JpaRepository<LambertConicSpot, Integer> {
    List<LambertConicSpot> findDistinctByXIsNotNullAndYIsNotNull();

    @Query("select distinct l from LambertConicSpot l")
    List<LambertConicSpot> findDistinctBy();

}



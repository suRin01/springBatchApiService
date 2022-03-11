package com.surin.apibatchgetter.repositories;

import com.surin.apibatchgetter.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer> {
    List<Spot> findByAddr1Is( String addr1 );
}
package com.surin.apibatchgetter.repositories;

import com.surin.apibatchgetter.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> findByBaseDateIs(String baseDate);
}
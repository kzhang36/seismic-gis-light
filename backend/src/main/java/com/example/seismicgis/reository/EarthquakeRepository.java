// === EarthquakeRepository.java ===
package com.example.seismicgis.repository;

import com.example.seismicgis.entity.Earthquake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarthquakeRepository extends JpaRepository<Earthquake, Long> {
}

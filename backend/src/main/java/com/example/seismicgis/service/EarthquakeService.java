// === EarthquakeService.java ===
package com.example.seismicgis.service;

import com.example.seismicgis.entity.Earthquake;
import com.example.seismicgis.repository.EarthquakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarthquakeService {
    private final EarthquakeRepository repository;

    public EarthquakeService(EarthquakeRepository repository) {
        this.repository = repository;
    }

    public List<Earthquake> getAll() {
        return repository.findAll();
    }

    public void save(Earthquake eq) {
        repository.save(eq);
    }
}

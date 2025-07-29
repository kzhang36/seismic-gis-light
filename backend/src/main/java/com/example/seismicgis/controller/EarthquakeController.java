// === EarthquakeController.java ===
package com.example.seismicgis.controller;

import com.example.seismicgis.entity.Earthquake;
import com.example.seismicgis.service.EarthquakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/earthquakes")
@CrossOrigin(origins = "*")
public class EarthquakeController {

    private final EarthquakeService service;

    public EarthquakeController(EarthquakeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Earthquake> getAll() {
        return service.getAll();
    }
}

// === EarthquakeFetchTask.java ===
package com.example.seismicgis.task;

import com.example.seismicgis.entity.Earthquake;
import com.example.seismicgis.service.EarthquakeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class EarthquakeFetchTask {

    private final EarthquakeService service;
    private final Random random = new Random();

    public EarthquakeFetchTask(EarthquakeService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 300000) // 每5分钟模拟一次
    public void fetchMockData() {
        Earthquake eq = new Earthquake();
        eq.setLatitude(34 + random.nextDouble());
        eq.setLongitude(110 + random.nextDouble());
        eq.setMagnitude(3 + random.nextDouble() * 4);
        eq.setDepth(5 + random.nextDouble() * 20);
        eq.setLocation("Simulated Earthquake");
        eq.setTimestamp(LocalDateTime.now());
        service.save(eq);
    }
}

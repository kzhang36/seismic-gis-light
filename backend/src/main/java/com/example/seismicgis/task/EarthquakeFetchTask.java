package com.seismic.webgis.task;

import com.alibaba.fastjson.JSONObject;
import com.seismic.webgis.entity.EarthquakeEvent;
import com.seismic.webgis.service.EarthquakeEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ScheduledDataFetcher {

    @Autowired
    private EarthquakeEventService service;

    @Scheduled(fixedRate = 60000) // 每60秒运行一次
    public void fetchEarthquakeData() {
        try {
            URL url = new URL("https://api.wolfx.jp/cenc_eqlist.json");
            Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8);
            String json = scanner.useDelimiter("\\A").next();
            JSONObject obj = JSONObject.parseObject(json);

            List<EarthquakeEvent> list = new ArrayList<>();
            for (int i = 50; i >= 1; i--) {
                JSONObject item = obj.getJSONObject("No" + i);
                EarthquakeEvent e = new EarthquakeEvent();
                e.setEventId(item.getString("EventID").replace(".", ""));
                e.setLocation(item.getString("location"));
                e.setLatitude(item.getDouble("latitude"));
                e.setLongitude(item.getDouble("longitude"));
                e.setDepth(item.getDouble("depth"));
                e.setMagnitude(item.getDouble("magnitude"));
                e.setEventTime(LocalDateTime.parse(item.getString("time")));
                e.setGeom(String.format("POINT(%s %s)", e.getLongitude(), e.getLatitude()));
                list.add(e);
            }

            service.saveOrUpdateEvents(list);
            System.out.println("[Scheduled Fetch] Done - " + LocalDateTime.now());

        } catch (Exception e) {
            System.err.println("Error fetching earthquake data: " + e.getMessage());
        }
    }
}

// === EarthquakeMap.vue ===
<template>
  <div id="map" style="height: 500px;"></div>
</template>

<script setup>
import { onMounted } from 'vue';
import L from 'leaflet';

onMounted(async () => {
  const map = L.map('map').setView([35.0, 110.0], 5);
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; OpenStreetMap contributors'
  }).addTo(map);

  L.geoJSON(null, {
  style: { color: '#3366ff', weight: 2 }
})
  .addTo(map)
  .loadURL('/output/flood_path.geojson')  // 你需配置静态路径(!you need to set up your own static path!)

  const res = await fetch('http://localhost:8080/api/earthquakes');
  const earthquakes = await res.json();

  earthquakes.forEach(eq => {
    const marker = L.marker([eq.latitude, eq.longitude]).addTo(map);
    marker.bindPopup(
      `<b>${eq.location}</b><br>Magnitude: ${eq.magnitude}<br>Depth: ${eq.depth} km<br>${new Date(eq.timestamp).toLocaleString()}`
    );
  });
});
</script>

<template>
  <div id="map" style="height: 100vh;"></div>
</template>

<script setup>
import { onMounted } from 'vue';
import L from 'leaflet';
import axios from 'axios';

onMounted(async () => {
  const map = L.map('map').setView([34.2, 108.9], 5);
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; OpenStreetMap contributors'
  }).addTo(map);

  const res = await axios.get('http://localhost:8089/api/earthquakes');
  res.data.forEach(eq => {
    const marker = L.marker([eq.latitude, eq.longitude]).addTo(map);
    marker.bindPopup(`<b>${eq.location}</b><br>Magnitude: ${eq.magnitude}<br>${eq.time}`);
  });
});
</script>

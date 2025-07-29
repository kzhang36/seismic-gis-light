// === App.vue ===
<template>
  <div id="app">
    <h1>Real-time Earthquake Map</h1>
    <EarthquakeMap />
    <EarthquakeSidebar />
  </div>
</template>

<script setup>
import EarthquakeMap from './components/EarthquakeMap.vue';
import EarthquakeSidebar from './components/EarthquakeSidebar.vue';
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  margin: 0 auto;
  max-width: 1200px;
}
</style>

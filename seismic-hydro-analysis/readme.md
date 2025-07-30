# Seismic Hydrological Analysis Module

This is an experimental extension of the **Seismic GIS Light** project. It integrates basic hydrological modeling using Digital Elevation Models (DEMs) and recent earthquake epicenters to identify potential surface flow paths or flood-prone zones.

## 📌 Purpose

- Simulate surface runoff or flow direction near epicenters
- Prepare GeoJSON layers for visualization in Leaflet
- Designed for LINZ hydrology workflows or research integration

---

## 🛠️ Dependencies

pip install -r requirements.txt


##📁 Structure
seismic-hydro-analysis/
├── dem/
│   └── sample_dem.tif             # Input DEM raster
├── earthquakes/
│   └── latest_quake.geojson       # Input quake epicenter
├── output/
│   └── flood_path.geojson         # Output: derived hydrological flowpaths
├── run_hydro_analysis.py          # Main script
└── requirements.txt

##🚀 How to Run
```bash
python run_hydro_analysis.py

Make sure the following inputs are available:
```bash
dem/sample_dem.tif: Small-scale DEM raster

earthquakes/latest_quake.geojson:
At least one recent quake point

Result will be exported to:
```bash
output/flood_path.geojson — compatible with Leaflet display

##🌍 Integration Options
You can now load output/flood_path.geojson into the Leaflet frontend of seismic-gis-light, or publish the output via a REST API.

##🧠 Future Directions
Epicenter-based flood area prediction (low elevation + slope + magnitude)

Integration with GNS or LINZ live hydrological layers

Real-time rendering using Leaflet + D3.js overlays

##📝 License
This module inherits the MIT license of the parent repository. Use freely for academic, demo, and public mapping purposes.

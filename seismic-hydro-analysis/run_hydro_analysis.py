import richdem as rd
import geopandas as gpd
import rasterio
from shapely.geometry import Point, mapping
from rasterio.features import shapes
import numpy as np
import json
import os

# === Step 1: Load DEM ===
dem_path = "dem/sample_dem.tif"
dem = rd.LoadGDAL(dem_path)
rd.FillDepressions(dem, in_place=True)

# === Step 2: Load earthquake point ===
eq_path = "earthquakes/latest_quake.geojson"
eq_gdf = gpd.read_file(eq_path)
eq_point = eq_gdf.geometry[0]
eq_coords = (eq_point.y, eq_point.x)  # lat, lon

# === Step 3: Compute flow direction and accumulation ===
flow_dir = rd.FlowDirectionD8(dem)
accum = rd.FlowAccumulation(flow_dir)

# === Step 4: Generate binary mask from high flow accumulation
mask = (accum > 100).astype(np.uint8)  # adjust threshold

# === Step 5: Convert mask to GeoJSON
with rasterio.open(dem_path) as src:
    transform = src.transform
    shapes_gen = shapes(mask, transform=transform)

    features = []
    for shape, value in shapes_gen:
        if value == 1:
            features.append({
                'type': 'Feature',
                'geometry': shape,
                'properties': {}
            })

# === Step 6: Save to GeoJSON
output_geojson = {
    'type': 'FeatureCollection',
    'features': features
}

os.makedirs("output", exist_ok=True)
with open("output/flood_path.geojson", "w") as f:
    json.dump(output_geojson, f)

print("Flow path exported to output/flood_path.geojson")

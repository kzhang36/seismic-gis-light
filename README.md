README.md

   # Seismic GIS Light

   A lightweight, full-stack geospatial application for visualizing recent earthquake data in real time. Built with a Vue.js + Leaflet frontend and a Spring Boot + PostgreSQL/PostGIS backend. Designed as a portfolio-ready demo and LINZ-compatible mapping utility.

   ## 🔍 Features
   - Periodically fetches earthquake data from public APIs
   - Stores data in a spatially enabled PostgreSQL (PostGIS) database
   - RESTful APIs for querying seismic records
   - Frontend Leaflet map with dynamic markers (supports future UI upgrades)
   - Configurable fetch intervals and logging

   ## 🌐 Technologies
   - Frontend: Vue 3, Leaflet
   - Backend: Spring Boot, Spring Data JPA
   - Database: PostgreSQL + PostGIS
   - Build Tools: Maven, npm

   ## 🚀 Quick Start

   ### Backend Setup
   ```bash
   cd seismic-gis-light-backend
   mvn clean install
   mvn spring-boot:run
   ```
   Requires a running PostgreSQL server with the `gisdb` database and PostGIS extension enabled.

   ### Frontend Setup
   ```bash
   cd seismic-gis-light-frontend
   npm install
   npm run dev
   ```

   ## 📡 API Endpoints
   - `POST /gp` : Submit earthquake record (auto-run task)
   - `GET /earthquakes` : Retrieve all records
   - `GET /earthquakes/latest` : Latest earthquake data
   - Future: `/search?bbox=` for spatial queries

   ## 📁 Project Structure
   See `backend/` and `frontend/` folders respectively.

   ## 🌏 Data Source
   - API: [https://api.wolfx.jp/cenc_eqlist.json](https://api.wolfx.jp/cenc_eqlist.json)
   - Format: JSON, updated hourly with CENC-sourced earthquake info

   ## 🗺️ LINZ Compatibility Goals
   - EPSG:2193 or NZGD2000-aware CRS transformation support (WIP)
   - Clean, modular service-layer design for integration with Koordinates data structures

   ## 📄 License
   MIT License — Free to use for portfolio, demo, and non-commercial mapping applications.

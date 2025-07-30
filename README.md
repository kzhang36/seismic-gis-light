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

### Roadmap
- [x] Backend: Spring Boot with RESTful API
- [x] Frontend: Vue + Leaflet Interactive Mapping
- [ ] Phase 2 (Planned): Integrate AI/ML modules for:
  - Seismic anomaly detection (GeoAI)
  - Hydrologic hazard prediction (Rainfall + terrain models)

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
   - see project folder respectively

   ## 🌏 Data Source
   - API: [https://api.wolfx.jp/cenc_eqlist.json](https://api.wolfx.jp/cenc_eqlist.json)
   - Format: JSON, updated hourly with CENC-sourced earthquake info

   ## 🗺️ LINZ Compatibility Goals
   - EPSG:2193 or NZGD2000-aware CRS transformation support (WIP)
   - Clean, modular service-layer design for integration with Koordinates data structures

   ## 📄 License
   MIT License — Free to use for portfolio, demo, and non-commercial mapping applications.

## 📦 Frontend Deployment Instructions

### 📁 Project Structure
```
seismic-gis-light-frontend/
├── index.html
├── package.json
├── vite.config.js
├── public/
│   └── earthquake-icon.png
└── src/
    ├── App.vue
    ├── main.js
    └── components/
        ├── EarthquakeMap.vue
        └── EarthquakeSidebar.vue
```

---

### 🚀 Local Development Setup

1. Install dependencies:
```bash
npm install
```

2. Start development server:
```bash
npm run dev
```

Visit: [http://localhost:5173](http://localhost:5173)
Note: The `/api` routes are proxied to `localhost:8080` backend using `vite.config.js`

---

### 🌐 GitHub Pages Deployment (Static Hosting)

1. Edit `vite.config.js` to include:
```js
base: './'
```

2. Build project:
```bash
npm run build
```

3. Upload contents of `dist/` to GitHub Pages (via `gh-pages` branch or `/docs` folder).

---

### 🌍 Deploy via Netlify or Vercel

1. Connect your GitHub repo to [Netlify](https://www.netlify.com/) or [Vercel](https://vercel.com/)
2. Set build settings:
   - Build command: `npm run build`
   - Publish directory: `dist`

3. Done — you get a shareable link to your map app.

---

### ⚙️ Backend API Notes
Ensure Spring Boot backend is running at `http://localhost:8080`. If not:
- Deploy backend separately (e.g., via Docker, local JVM)
- Update proxy in `vite.config.js`:
```js
proxy: {
  '/api': {
    target: 'http://<your-domain-or-ip>:8080'
  }
}
```

If you need help deploying the backend, see `/seismic-gis-light-backend` folder or contact the project maintainer.

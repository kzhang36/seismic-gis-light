CREATE TABLE IF NOT EXISTS earthquake (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    latitude DOUBLE,
    longitude DOUBLE,
    magnitude DOUBLE,
    depth DOUBLE,
    location VARCHAR(255),
    timestamp TIMESTAMP
);

package com.mjl.geo;

/**
 * @author mjl
 * @date 2025/2/11.
 */
public class GeoDTO {
    private GeoProperty properties;
    private Geometry geometry;
    private String name;
    private String startCode;
    private String endCode;
    private Double distance;
    private Double startDistance;
    private Double endDistance;

    public Double getStartDistance() {
        return startDistance;
    }

    public void setStartDistance(Double startDistance) {
        this.startDistance = startDistance;
    }

    public Double getEndDistance() {
        return endDistance;
    }

    public void setEndDistance(Double endDistance) {
        this.endDistance = endDistance;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartCode() {
        return startCode;
    }

    public void setStartCode(String startCode) {
        this.startCode = startCode;
    }

    public String getEndCode() {
        return endCode;
    }

    public void setEndCode(String endCode) {
        this.endCode = endCode;
    }

    public GeoProperty getProperties() {
        return properties;
    }

    public void setProperties(GeoProperty properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}

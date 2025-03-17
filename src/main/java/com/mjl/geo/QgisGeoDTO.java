package com.mjl.geo;

/**
 * @author mjl
 * @date 2025/2/11.
 */
public class QgisGeoDTO {
    private GgisGeoProperty properties;
    private QgisGeometry geometry;
    private String name;
    private String startCode;
    private String endCode;
    private String text;
    private Double distance;
    private Double startDistance;
    private Double endDistance;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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

    public GgisGeoProperty getProperties() {
        return properties;
    }

    public void setProperties(GgisGeoProperty properties) {
        this.properties = properties;
    }

    public QgisGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(QgisGeometry geometry) {
        this.geometry = geometry;
    }
}

package com.mjl.geo;

import java.util.List;

/**
 * @author mjl
 * @date 2025/2/11.
 */
public class Geometry {
    private String type;
    private String coordinates;
    private List<Double> pointCoordinates;
    private List<List<Double>> lineCoordinates;

    public List<Double> getPointCoordinates() {
        return pointCoordinates;
    }

    public void setPointCoordinates(List<Double> pointCoordinates) {
        this.pointCoordinates = pointCoordinates;
    }

    public List<List<Double>> getLineCoordinates() {
        return lineCoordinates;
    }

    public void setLineCoordinates(List<List<Double>> lineCoordinates) {
        this.lineCoordinates = lineCoordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}

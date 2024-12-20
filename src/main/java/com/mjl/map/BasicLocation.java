package com.mjl.map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author luoye
 * @date 2021/12/29
 */
public class BasicLocation implements Cloneable, Serializable {
    private static final long serialVersionUID = 1013906685679092140L;
    private String id;
    private String fromCoordtype;
    private double latitude;
    private double longitude;
    private boolean done = false;
    private String toCoordtype;
    private double latitudeDone = 0.0D;
    private double longitudeDone = 0.0D;
    private String address = null;
    private String addressComponent = null;

    public BasicLocation() {
    }

    public BasicLocation(String fromCoordtype, double latitude, double longitude, String toCoordtype) {
        this.fromCoordtype = fromCoordtype;
        this.latitude = latitude;
        this.longitude = longitude;
        this.toCoordtype = toCoordtype;
    }

    public BasicLocation(String id, String fromCoordtype, double latitude, double longitude, String toCoordtype) {
        this.id = id;
        this.fromCoordtype = fromCoordtype;
        this.latitude = latitude;
        this.longitude = longitude;
        this.toCoordtype = toCoordtype;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public double getLatitudeDone() {
        return this.latitudeDone;
    }

    public void setLatitudeDone(double latitudeDone) {
        this.latitudeDone = latitudeDone;
    }

    public double getLongitudeDone() {
        return this.longitudeDone;
    }

    public void setLongitudeDone(double longitudeDone) {
        this.longitudeDone = longitudeDone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFromCoordtype() {
        return this.fromCoordtype;
    }

    public void setFromCoordtype(String fromCoordtype) {
        this.fromCoordtype = fromCoordtype;
    }

    public String getToCoordtype() {
        return this.toCoordtype;
    }

    public void setToCoordtype(String toCoordtype) {
        this.toCoordtype = toCoordtype;
    }

    public void setCoordconvert(boolean done, String toCoordtype, double longitudeDone, double latitudeDone) {
        this.setToCoordtype(toCoordtype);
        this.setDone(done);
        this.setLatitudeDone(latitudeDone);
        this.setLongitudeDone(longitudeDone);
    }

    public void setGeoconvert() {
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getAddressComponent() {
        return this.addressComponent;
    }

    public void setAddressComponent(String addressComponent) {
        this.addressComponent = addressComponent;
    }
}

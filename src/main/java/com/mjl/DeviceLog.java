package com.mjl;

import java.util.Map;

/**
 * @author MJL
 * @date 2021/11/16.
 */
public class DeviceLog {
    String imei;
    String supportCompanyId;
    String deviceType;
    Map<String, String> map;

    public DeviceLog() {
    }

    public DeviceLog(String imei, String supportCompanyId, String deviceType, Map<String, String> map) {
        this.imei = imei;
        this.supportCompanyId = supportCompanyId;
        this.deviceType = deviceType;
        this.map = map;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSupportCompanyId() {
        return supportCompanyId;
    }

    public void setSupportCompanyId(String supportCompanyId) {
        this.supportCompanyId = supportCompanyId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

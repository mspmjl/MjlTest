package com.mjl.easyexcel;

/**
 * @author mjl
 * @date 2025/9/19.
 */
public class ExcelReadDTO {
    private String deviceId;
    private String deviceCode;
    private String deviceName;
    private String monitorItemName;
    private String monitorItemCode;
    private String factorCode;
    private String factorName;
    private String collectTypeName;
    private String collectFrequencyName;
    private String unit;
    private String formatValue;
    private String timeDesc;

    public String getMonitorItemName() {
        return monitorItemName;
    }

    public void setMonitorItemName(String monitorItemName) {
        this.monitorItemName = monitorItemName;
    }

    public String getMonitorItemCode() {
        return monitorItemCode;
    }

    public void setMonitorItemCode(String monitorItemCode) {
        this.monitorItemCode = monitorItemCode;
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public String getCollectTypeName() {
        return collectTypeName;
    }

    public void setCollectTypeName(String collectTypeName) {
        this.collectTypeName = collectTypeName;
    }

    public String getCollectFrequencyName() {
        return collectFrequencyName;
    }

    public void setCollectFrequencyName(String collectFrequencyName) {
        this.collectFrequencyName = collectFrequencyName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFormatValue() {
        return formatValue;
    }

    public void setFormatValue(String formatValue) {
        this.formatValue = formatValue;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getTimeDesc() {
        return timeDesc;
    }

    public void setTimeDesc(String timeDesc) {
        this.timeDesc = timeDesc;
    }
}

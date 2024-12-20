package com.mjl;

import java.math.BigDecimal;

/**
 * @author MJL
 * @date 2024/4/17.
 */
public class GpsUtil {

    public static void main(String[] args) {
        findCoordinate(112D, 34.3244, 112D, 114D, 33D, 35D, 0.01, 0.01);

    }


    public static void findCoordinate(Double lng, Double lat, Double lngMin, Double lngMax, Double latMin, Double latMax, Double lngDiff, Double latDiff) {
        if (lng == null || lat == null || lngMin == null || lngMax == null || latMin == null || latMax == null || lngDiff == null || lngDiff == null || latDiff == null) {
            return;
        }
        if (lng < lngMin || lng > lngMax) {
            return;
        }
        if (lat < latMin || lat > latMax) {
            return;
        }
        double lngDiv = CalUtil.div((lng - lngMin), lngDiff, 0, BigDecimal.ROUND_DOWN);
        System.out.println("lngDiv:" + Double.valueOf(lngDiv).intValue());
        double latDiv = CalUtil.div((lat - latMin), latDiff, 0, BigDecimal.ROUND_DOWN);
        System.out.println("latDiv:" + Double.valueOf(latDiv).intValue());

    }

}

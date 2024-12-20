package com.mjl.map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author luoye
 * @date 2021/12/29
 */
public class MapCoordinateConvertUtils {
    static final double pi = 3.141592653589793D;
    static final double a = 6378245.0D;
    static final double ee = 0.006693421622965943D;
    static final double x_pi = 52.35987755982988D;

    public MapCoordinateConvertUtils() {
    }

    private static boolean outOfChina(double lat, double lon) {
        if (!(lon < 72.004D) && !(lon > 137.8347D)) {
            return lat < 0.8293D || lat > 55.8271D;
        } else {
            return true;
        }
    }

    private static double transformLat(double x, double y) {
        double ret = -100.0D + 2.0D * x + 3.0D * y + 0.2D * y * y + 0.1D * x * y + 0.2D * Math.sqrt(Math.abs(x));
        ret += (20.0D * Math.sin(6.0D * x * 3.141592653589793D) + 20.0D * Math.sin(2.0D * x * 3.141592653589793D)) * 2.0D / 3.0D;
        ret += (20.0D * Math.sin(y * 3.141592653589793D) + 40.0D * Math.sin(y / 3.0D * 3.141592653589793D)) * 2.0D / 3.0D;
        ret += (160.0D * Math.sin(y / 12.0D * 3.141592653589793D) + 320.0D * Math.sin(y * 3.141592653589793D / 30.0D)) * 2.0D / 3.0D;
        return ret;
    }

    private static double transformLon(double x, double y) {
        double ret = 300.0D + x + 2.0D * y + 0.1D * x * x + 0.1D * x * y + 0.1D * Math.sqrt(Math.abs(x));
        ret += (20.0D * Math.sin(6.0D * x * 3.141592653589793D) + 20.0D * Math.sin(2.0D * x * 3.141592653589793D)) * 2.0D / 3.0D;
        ret += (20.0D * Math.sin(x * 3.141592653589793D) + 40.0D * Math.sin(x / 3.0D * 3.141592653589793D)) * 2.0D / 3.0D;
        ret += (150.0D * Math.sin(x / 12.0D * 3.141592653589793D) + 300.0D * Math.sin(x / 30.0D * 3.141592653589793D)) * 2.0D / 3.0D;
        return ret;
    }

    public static double[] wgs84Togcj02(double wgLon, double wgLat) {
        double[] result = new double[2];
        if (outOfChina(wgLat, wgLon)) {
            result[0] = wgLon;
            result[1] = wgLat;
        } else {
            double dLat = transformLat(wgLon - 105.0D, wgLat - 35.0D);
            double dLon = transformLon(wgLon - 105.0D, wgLat - 35.0D);
            double radLat = wgLat / 180.0D * 3.141592653589793D;
            double magic = Math.sin(radLat);
            magic = 1.0D - 0.006693421622965943D * magic * magic;
            double sqrtMagic = Math.sqrt(magic);
            dLat = dLat * 180.0D / (6335552.717000426D / (magic * sqrtMagic) * 3.141592653589793D);
            dLon = dLon * 180.0D / (6378245.0D / sqrtMagic * Math.cos(radLat) * 3.141592653589793D);
            result[0] = wgLon + dLon;
            result[1] = wgLat + dLat;
        }

        return result;
    }

    public static double[] gcj02Towgs84(double wgLon, double wgLat) {
        double[] result = new double[2];
        double[] pl = wgs84Togcj02(wgLon, wgLat);
        double offsetLat = pl[1] - wgLat;
        double offsetLng = pl[0] - wgLon;
        result[0] = wgLon - offsetLng;
        result[1] = wgLat - offsetLat;
        return result;
    }

    public static double[] gcj02Towgs84Exact(double gcjLon, double gcjLat) {
        double[] result = new double[2];
        double initDelta = 0.01D;
        double threshold = 1.0E-9D;
        double mLat = gcjLat - initDelta;
        double mLon = gcjLon - initDelta;
        double pLat = gcjLat + initDelta;
        double pLon = gcjLon + initDelta;
        double i = 0.0D;

        double wgsLat;
        double wgsLon;
        do {
            wgsLat = (mLat + pLat) / 2.0D;
            wgsLon = (mLon + pLon) / 2.0D;
            double[] tmp = wgs84Togcj02(wgsLon, wgsLat);
            double dLat = tmp[1] - gcjLat;
            double dLon = tmp[0] - gcjLon;
            if (Math.abs(dLat) < threshold && Math.abs(dLon) < threshold) {
                break;
            }

            if (dLat > 0.0D) {
                pLat = wgsLat;
            } else {
                mLat = wgsLat;
            }

            if (dLon > 0.0D) {
                pLon = wgsLon;
            } else {
                mLon = wgsLon;
            }
        } while(!(++i > 10000.0D));

        result[0] = wgsLon;
        result[1] = wgsLat;
        return result;
    }

    public static double[] wgs84Tobd09(double wgLon, double wgLat) {
        double[] gcj = wgs84Togcj02(wgLon, wgLat);
        double[] result = gcj02Tobd09(gcj[0], gcj[1]);
        return result;
    }

    public static double[] gcj02Tobd09(double lon, double lat) {
        double[] result = new double[2];
        double z = Math.sqrt(lon * lon + lat * lat) + 2.0E-5D * Math.sin(lat * 52.35987755982988D);
        double theta = Math.atan2(lat, lon) + 3.0E-6D * Math.cos(lon * 52.35987755982988D);
        double bd_lon = z * Math.cos(theta) + 0.0065D;
        double bd_lat = z * Math.sin(theta) + 0.006D;
        result[0] = bd_lon;
        result[1] = bd_lat;
        return result;
    }

    public static double[] bd09Togcj02(double lon, double lat) {
        double[] result = new double[2];
        double x = lon - 0.0065D;
        double y = lat - 0.006D;
        double z = Math.sqrt(x * x + y * y) - 2.0E-5D * Math.sin(y * 52.35987755982988D);
        double theta = Math.atan2(y, x) - 3.0E-6D * Math.cos(x * 52.35987755982988D);
        double gg_lon = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        result[0] = gg_lon;
        result[1] = gg_lat;
        return result;
    }

    public static double[] bd09Towgs84(double lon, double lat) {
        double[] gcj02 = bd09Togcj02(lon, lat);
        double[] map84 = gcj02Towgs84(gcj02[0], gcj02[1]);
        return map84;
    }

    public static double[] mapbarTowgs84(double lon, double lat) {
        double[] result = new double[2];
        lon = lon * 100000.0D % 3.6E7D;
        lat = lat * 100000.0D % 3.6E7D;
        double x1 = -(Math.cos(lat / 100000.0D) * (lon / 18000.0D) + Math.sin(lon / 100000.0D) * (lat / 9000.0D)) + lon;
        double y1 = -(Math.sin(lat / 100000.0D) * (lon / 18000.0D) + Math.cos(lon / 100000.0D) * (lat / 9000.0D)) + lat;
        double x2 = -(Math.cos(y1 / 100000.0D) * (x1 / 18000.0D) + Math.sin(x1 / 100000.0D) * (y1 / 9000.0D)) + lon + (double)(lon > 0.0D ? 1 : -1);
        double y2 = -(Math.sin(y1 / 100000.0D) * (x1 / 18000.0D) + Math.cos(x1 / 100000.0D) * (y1 / 9000.0D)) + lat + (double)(lat > 0.0D ? 1 : -1);
        result[0] = x2 / 100000.0D;
        result[1] = y2 / 100000.0D;
        return result;
    }

    public static double[] wgs84ToWebMercator(double wgsLon, double wgsLat) {
        double[] result = new double[2];
        double x = wgsLon * 2.003750834E7D / 180.0D;
        double y = Math.log(Math.tan((90.0D + wgsLat) * 3.141592653589793D / 360.0D)) / 0.017453292519943295D;
        y = y * 2.003750834E7D / 180.0D;
        result[0] = x;
        result[1] = y;
        return result;
    }

    public static double[] webMercatorToWgs84(double mercatorLon, double mercatorLat) {
        double[] result = new double[2];
        double x = mercatorLon / 2.003750834E7D * 180.0D;
        double y = mercatorLat / 2.003750834E7D * 180.0D;
        y = 57.29577951308232D * (2.0D * Math.atan(Math.exp(y * 3.141592653589793D / 180.0D)) - 1.5707963267948966D);
        result[0] = x;
        result[1] = y;
        return result;
    }

    public static BasicLocation fix(BasicLocation position, String mapType) {
        if (!StringUtils.isEmpty(mapType)) {
            double[] baidumap;
            if (mapType.equals(MapTypeEnum.AMAP.getKey())) {
                baidumap = wgs84Togcj02(position.getLongitude(), position.getLatitude());
                position.setLongitudeDone(baidumap[0]);
                position.setLatitudeDone(baidumap[1]);
            } else if (mapType.equals(MapTypeEnum.BMAP.getKey())) {
                baidumap = wgs84Tobd09(position.getLongitude(), position.getLatitude());
                position.setLongitudeDone(baidumap[0]);
                position.setLatitudeDone(baidumap[1]);
            }
        }

        return position;
    }

    public static BasicLocation reverse(BasicLocation position, String mapType) {
        if (!StringUtils.isEmpty(mapType)) {
            double[] baidumap;
            if (mapType.equals(MapTypeEnum.AMAP.getKey())) {
                baidumap = gcj02Towgs84(position.getLongitudeDone(), position.getLatitudeDone());
                position.setLongitude(baidumap[0]);
                position.setLatitude(baidumap[1]);
            } else if (mapType.equals(MapTypeEnum.BMAP.getKey())) {
                baidumap = bd09Towgs84(position.getLongitudeDone(), position.getLatitudeDone());
                position.setLongitude(baidumap[0]);
                position.setLatitude(baidumap[1]);
            }
        }

        return position;
    }

    public static String getDeclaredMethod(String from, String to) {
        return from + "To" + to;
    }

    public int getAreaPostion(int gpsCoordinate) {
        int nDegree = gpsCoordinate / 1000000 * 1000000;
        int nSecond = (int)(1.0E-6D * (double)(gpsCoordinate - nDegree) * 3600.0D);
        return nDegree + nSecond;
    }
}

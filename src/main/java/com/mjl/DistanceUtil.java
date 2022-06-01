package com.mjl;

public class DistanceUtil {

	/***************************************************************************
	 * 根据两个点经纬度求距离
	 **************************************************************************/
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}
	
	/**
	 * 
	 * 得到经纬度距离 (单位：米)
	 * 
	 * @param lng1
	 *            经度 x
	 * @param lat1
	 *            纬度 y
	 * @param lng2
	 *            经度 x
	 * @param lat2
	 *            经度 x
	 * @return
	 */
	public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137.0;
		s = Math.round(s * 10000) / 10000;
		return s;
	}
}

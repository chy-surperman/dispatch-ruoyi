package com.ruoyi.common.core.utils;

import java.util.ArrayList;
import java.util.List;



public class GPSUtil {
	public static double pi = 3.1415926535897932384626;
	public static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
	public static double a = 6378245.0;
	public static double ee = 0.00669342162296594323;
	private static double EARTH_RADIUS = 6378.137;

	public static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	public static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}

	public static double[] transform(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return new double[] { lat, lon };
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new double[] { mgLat, mgLon };
	}

	public static boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	/**
	 * 84 to 火星坐标系 (GCJ-02) World Geodetic System ==> Mars Geodetic System
	 *
	 * @param lat
	 * @param lon
	 * @return
	 */
	public static double[] gps84_To_Gcj02(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return new double[] { lat, lon };
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new double[] { mgLat, mgLon };
	}

	/**
	 * * 火星坐标系 (GCJ-02) to 84 * * @param lon * @param lat * @return
	 */
	public static double[] gcj02_To_Gps84(double lat, double lon) {
		double[] gps = transform(lat, lon);
		double lontitude = lon * 2 - gps[1];
		double latitude = lat * 2 - gps[0];
		return new double[] { latitude, lontitude };
	}

	/**
	 * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
	 *
	 * @param lat
	 * @param lon
	 */
	public static double[] gcj02_To_Bd09(double lat, double lon) {
		double x = lon, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		double tempLon = z * Math.cos(theta) + 0.0065;
		double tempLat = z * Math.sin(theta) + 0.006;
		double[] gps = { tempLat, tempLon };
		return gps;
	}

	/**
	 * * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标 * * @param
	 * bd_lat * @param bd_lon * @return
	 */
	public static double[] bd09_To_Gcj02(double lat, double lon) {
		double x = lon - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		double tempLon = z * Math.cos(theta);
		double tempLat = z * Math.sin(theta);
		double[] gps = { tempLat, tempLon };
		return gps;
	}

	/**
	 * 将gps84转为bd09
	 *
	 * @param lat
	 * @param lon
	 * @return
	 */
	public static double[] gps84_To_bd09(double lat, double lon) {
		double[] gcj02 = gps84_To_Gcj02(lat, lon);
		double[] bd09 = gcj02_To_Bd09(gcj02[0], gcj02[1]);
		return bd09;
	}

	public static double[] bd09_To_gps84(double lat, double lon) {
		double[] gcj02 = bd09_To_Gcj02(lat, lon);
		double[] gps84 = gcj02_To_Gps84(gcj02[0], gcj02[1]);
		// 保留小数点后六位
		gps84[0] = retain6(gps84[0]);
		gps84[1] = retain6(gps84[1]);
		return gps84;
	}

	/**
	 * 保留小数点后六位
	 *
	 * @param num
	 * @return
	 */
	private static double retain6(double num) {
		String result = String.format("%.6f", num);
		return Double.valueOf(result);
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 通过经纬度获取距离(单位：米)
	 *
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000d) / 10000d;
		s = s * 1000;
		return s;
	}






	private static List<Double> revers(double[] values){
		List<Double> doubles = new ArrayList<>();
		doubles.add(values[1]);
		doubles.add(values[0]);
		return doubles;
	}

	public static void main(String[] args) {
//		System.out.println("长桥路社塘路口 下行：" + getDirection(28.232718, 113.121101, 28.230274, 113.11586));
//		System.out.println("长桥路社塘路口 上行：" + getDirection(28.232851, 113.121284, 28.233385, 113.128975));
//
//		int dirAbs = Math.abs(getDirection(28.232851, 113.121284, 28.233385, 113.128975) - getDirection(28.232718, 113.121101, 28.230274, 113.11586));
//		System.out.println("长桥路社塘路口 角度差：" + dirAbs);
//
//		System.out.println("----------------------------------------------------------------------------------");
//
//		System.out.println("长桥路社塘路口 下行：" + getDirection(28.233559, 113.128571, 28.232718, 113.121101));
//		System.out.println("长桥路社塘路口 上行：" + getDirection(28.23012, 113.119812, 28.232851, 113.121284));
//
//		dirAbs = Math.abs(getDirection(28.233559, 113.128571, 28.232718, 113.121101) - getDirection(28.23012, 113.119812, 28.232851, 113.121284));
//		System.out.println("长桥路社塘路口 角度差：" + dirAbs);
//		List<Object> objs = ;
//		System.out.println(revers(gps84_To_Gcj02(28.17856, 113.129828)).toString());
//		System.out.println(GPSUtil.getDirection(28.17856, 113.129828, 28.145622, 113.130928));
//		System.out.println(Arrays.toString(gps84_To_Gcj02(28.139375, 113.072358)));
//
//		System.out.println(Arrays.toString(GPSUtil.bd09_To_Gcj02(28.139975, 113.072958)));

		//113.007834,28.213286
		System.out.println(revers(gps84_To_Gcj02(28.227329, 113.128296)).toString());
		System.out.println(revers(gcj02_To_Gps84(28.213286, 113.007834)).toString());
	}

}
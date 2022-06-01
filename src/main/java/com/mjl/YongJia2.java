package com.mjl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author MJL
 * @date 2022/3/8.
 */
public class YongJia2 {
    public static void main(String[] args) throws Exception {

        BufferedReader reader3 = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\yongjia\\ss.txt"));
        BufferedReader reader4 = new BufferedReader(new FileReader("C:\\Users\\DELL\\Desktop\\yongjia\\gps.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\yongjia\\result.txt"));

        String s3, s4;
        double latitudeDone = 0, longitudeDone = 0;
        Long timestamp = null;
        List<Facility> list = new ArrayList<>();
        while ((s3 = reader3.readLine()) != null) {
            s3 = s3.trim();
            if (s3.startsWith("\"latitudeDone\"")) {
                latitudeDone = Double.valueOf(s3.substring(s3.indexOf(": ") + 2, s3.length() - 1));
            }
            if (s3.startsWith("\"longitudeDone\"")) {
                longitudeDone = Double.valueOf(s3.substring(s3.indexOf(": ") + 2, s3.length() - 1));
                Facility facility = new Facility(latitudeDone, longitudeDone);
                list.add(facility);
            }
        }
        double lat = 0, lon = 0;
        while ((s4 = reader4.readLine()) != null) {
            s4 = s4.trim();
            if (s4.startsWith("\"b\": ")) {
                timestamp = Long.valueOf(s4.substring(5, s4.length() - 1));
            }
            if (s4.startsWith("\"c\": ")) {
                lat = Double.parseDouble(s4.substring(5, s4.length() - 1));

            }
            if (s4.startsWith("\"d\": ")) {
                lon = Double.parseDouble(s4.substring(5, s4.length() - 1));
                for (Facility facility : list) {
                    double distance = DistanceUtil.getDistance(facility.getLongitudeDone(), facility.getLatitudeDone(), lon, lat);
                    if (distance <= 50) {
                        System.out.println(distance + "  " + facility.getLongitudeDone() + "," + facility.getLatitudeDone() + " " + lon + "," + lat + " " + DateUtil.format(new Date(timestamp), DateUtil.DATETIME_FORMAT) + " " + timestamp);
                        writer.write("=========================================================================================");
                        writer.newLine();
                    }
                    writer.write(distance + "  " + facility.getLongitudeDone() + "," + facility.getLatitudeDone() + " " + lon + "," + lat + " " + DateUtil.format(new Date(timestamp), DateUtil.DATETIME_FORMAT)+ " " + timestamp);
                    writer.newLine();

                }
            }
        }
    }
}

class Facility {
    private double latitudeDone;
    private double longitudeDone;

    public Facility(double latitudeDone, double longitudeDone) {
        this.latitudeDone = latitudeDone;
        this.longitudeDone = longitudeDone;
    }

    public double getLatitudeDone() {
        return latitudeDone;
    }

    public void setLatitudeDone(double latitudeDone) {
        this.latitudeDone = latitudeDone;
    }

    public double getLongitudeDone() {
        return longitudeDone;
    }

    public void setLongitudeDone(double longitudeDone) {
        this.longitudeDone = longitudeDone;
    }
}

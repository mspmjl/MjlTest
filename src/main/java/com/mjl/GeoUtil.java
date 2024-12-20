package com.mjl;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mjl
 * @date 2024/11/29.
 */
public class GeoUtil {



    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> param = new HashMap<>();
        String url = "http://61.182.0.134:8001/geoserver/zhsw/ows?service={service}&version={version}&request={request}&typeName={typeName}&maxFeatures={maxFeatures}&outputFormat={outputFormat}";
        param.put("service", "WFS");
        param.put("version", "1.0.0");
        param.put("request", "GetFeature");
        param.put("typeName", "zhsw:huzhou_district");
        param.put("maxFeatures", "50000");
        param.put("outputFormat", "application/json");
        String result = restTemplate.getForObject(url, String.class, param);
        System.out.println(result);

    }
}

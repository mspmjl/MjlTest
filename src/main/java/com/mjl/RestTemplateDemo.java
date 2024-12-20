package com.mjl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MJL
 * @date 2021/11/16.
 */
public class RestTemplateDemo {
    public static void main(String[] args) {
        RestTemplateDemo demo = new RestTemplateDemo();
//        demo.SzAddDevice("RL-IN-M", "ALXTT49")
//        demo.SzAddDeviceLog("ALXTT48RL-IN-M");
        demo.SzAddDeviceAlarm("ALXTT48LHQND-M");
//        demo.getToken();
    }

    public void getToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://220.191.224.151/gateway-api/gateway/getAccessToken?appId={appId}&secret={secret}";
        Map<String, String> map = new HashMap<>(2);
        map.put("appId", "d5c5529006ec11ec1fd1453ce862e471");
        map.put("secret", "de23810006ec11ec1fd1453ce862e471");
        String forObject = restTemplate.getForObject(url, String.class, map);
        System.out.println(forObject);
        JSONObject jsonObject = JSON.parseObject(forObject);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("result"));
    }

    public void SzAddDevice(String device, String parent) {
        RestTemplate restTemplate = new RestTemplate();

        Map body = new HashMap(4);
        body.put("imei", device);
        body.put("parentImei", parent);
        body.put("deviceType", "24");
        body.put("supportCompanyId", "62ebeac0467c11ecb97149c32cd92d88");

        String jsonData = JSON.toJSONString(body);
        MultiValueMap map = new LinkedMultiValueMap<>();
        map.add("accessToken", "a0b15bf3eb392a0fe4996571e0f37e420eb09c3ed4a8c94b7110c0f9680e4a7e4c6ed01d00ec096b251613499477db87");
        map.add("interfacecode", "addDeviceInfo");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity<>(jsonData, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://220.191.224.151/gateway-api/api").queryParams(map);
        ResponseEntity responseEntity = restTemplate.postForEntity(builder.toUriString(), request, JSONObject.class);
        System.out.println(builder.toUriString());
        System.out.println(responseEntity);
    }

    public void SzAddDeviceLog(String device) {
        RestTemplate restTemplate = new RestTemplate();

        Map body = new HashMap(4);
        body.put("imei", device);
        body.put("supportCompanyId", "62ebeac0467c11ecb97149c32cd92d88");
        body.put("deviceType", "24");
        Map data = new HashMap();
        data.put("visitorsFlowrate", "343");
        body.put("data", data);
        String jsonData = JSON.toJSONString(body);
        MultiValueMap map = new LinkedMultiValueMap<>();
        map.add("accessToken", "a0b15bf3eb392a0fe4996571e0f37e420eb09c3ed4a8c94b7110c0f9680e4a7ed462d28b85f9371cd9c84e645ccee791");
        map.add("interfacecode", "addDeviceLog");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity<>(jsonData, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://220.191.224.151/gateway-api/api").queryParams(map);
        ResponseEntity responseEntity = restTemplate.postForEntity(builder.toUriString(), request, JSONObject.class);
        System.out.println(builder.toUriString());
        System.out.println(responseEntity);
    }

    public void SzAddDeviceAlarm(String device) {
        RestTemplate restTemplate = new RestTemplate();

        Map body = new HashMap(4);
        body.put("imei", device);
        body.put("supportCompanyId", "62ebeac0467c11ecb97149c32cd92d88");
        body.put("deviceType", "24");
        body.put("type", "2");
        body.put("alarmTime", "2021-11-14 14:37:00");

        String jsonData = JSON.toJSONString(body);
        MultiValueMap map = new LinkedMultiValueMap<>();
        map.add("accessToken", "a0b15bf3eb392a0fe4996571e0f37e420eb09c3ed4a8c94b7110c0f9680e4a7ed462d28b85f9371cd9c84e645ccee791");
        map.add("interfacecode", "addDeviceAlarm");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity<>(jsonData, headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://220.191.224.151/gateway-api/api").queryParams(map);
        ResponseEntity responseEntity = restTemplate.postForEntity(builder.toUriString(), request, JSONObject.class);
        System.out.println(builder.toUriString());
        System.out.println(responseEntity);
    }
}

package com.mjl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MJL
 * @date 2021/8/13.
 */
public class Bind {
    public static void main(String[] args) {
        String codes = "BB808039055215606\n" +
                "BB808039055219590\n" +
                "BB808039055189959\n" +
                "BB808039055209484\n" +
                "BB808039055018190\n" +
                "BB808039055213882\n" +
                "BB808039055027878\n" +
                "BB808039055220804\n" +
                "BB808039055030781\n" +
                "BB808039055211068\n" +
                "BB808039055032803\n" +
                "BB808039055201267\n" +
                "BB808039054997782\n" +
                "BB808039055197317\n" +
                "BB808039055007284\n" +
                "BB808039054966209\n" +
                "BB808039055031920\n" +
                "BB808039055203529\n" +
                "BB808039055042364\n" +
                "BB808039055196376\n" +
                "BB808039055215622\n" +
                "BB808039055014439\n" +
                "BB808039054999762\n" +
                "BB808039055185890\n" +
                "BB808039055196319\n" +
                "BB808039055043859\n" +
                "BB808039055219632\n" +
                "BB808039055017937\n" +
                "BB808039055216323\n" +
                "BB808039055221877\n";
        String[] split = codes.split("\n");
        int i = 1;
        for (String s : split) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ownerId", "a12606699b9941fdbad5bbad30045fb7");
            jsonObject.put("deviceIdList", new String[]{s});
            HttpEntity objectHttpEntity = new HttpEntity<>(jsonObject, headers);
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.postForObject("http://api.envcloud.com.cn:9012/dms/bindDeviceList", objectHttpEntity, String.class);
            System.out.println(i + ": " + s + " " + result);
            i++;
        }
    }
}

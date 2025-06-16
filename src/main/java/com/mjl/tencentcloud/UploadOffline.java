package com.mjl.tencentcloud;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.lke.v20231130.LkeClient;
import com.tencentcloudapi.lke.v20231130.models.CreateReleaseRequest;
import com.tencentcloudapi.lke.v20231130.models.CreateReleaseResponse;
import com.tencentcloudapi.lke.v20231130.models.DeleteDocRequest;
import com.tencentcloudapi.lke.v20231130.models.DeleteDocResponse;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class UploadOffline {
    private static final String EndPoint = "lke.tencentcloudapi.com";
    private static final String SecretID = "AKIDoUI2e6KLAmASdcR3oRs55rVxBDKI2Zs0";
    private static final String SecretKey = "yCB0c0GKQRHuJajjcREtPksnV1LTUUSL";
    private static final String BotBizID = "1846139144400535552";
    private static final String TypeKeyOffline = "offline"; // 离线文档上传类型
    private static final String Region = "ap-guangzhou";

    public static void main(String[] args) throws TencentCloudSDKException {
//        release();
        // 1904008028758656384 1904010445176418112 1904010522074293568
        delete(Arrays.asList("1904008028758656384", "1904010445176418112", "1904010522074293568"));
    }

    public static void release() throws TencentCloudSDKException {
        Credential cred = new Credential(SecretID, SecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(EndPoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        LkeClient client = new LkeClient(cred, Region, clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        CreateReleaseRequest req = new CreateReleaseRequest();
        req.setBotBizId(BotBizID);
        // 返回的resp是一个CreateReleaseResponse的实例，与请求对象对应
        CreateReleaseResponse resp = client.CreateRelease(req);
        // 输出json格式的字符串回包
        System.out.println(JSON.toJSONString(resp));
    }

    public static void delete(List<String> ids) throws TencentCloudSDKException {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        Credential cred = new Credential(SecretID, SecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(EndPoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        LkeClient client = new LkeClient(cred, Region, clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        DeleteDocRequest req = new DeleteDocRequest();
        req.setBotBizId(BotBizID);
        req.setDocBizIds(ids.toArray(new String[ids.size()]));
        // 返回的resp是一个DeleteDocResponse的实例，与请求对象对应
        DeleteDocResponse resp = client.DeleteDoc(req);
        // 输出json格式的字符串回包
        System.out.println(JSON.toJSONString(resp));
    }
}
package com.mjl.tencentcloud;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicSessionCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.tencentcloudapi.common.CommonClient;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadOffline {
    private static final String EndPoint = "lke.tencentcloudapi.com";
    private static final String SecretID = "xxx";
    private static final String SecretKey = "xxx";
    private static final String BotBizID = "1846139144400535552";
    private static final String TypeKeyOffline = "offline"; // 离线文档上传类型
    private static final String Region = "ap-guangzhou";

    public static void main(String[] args) throws TencentCloudSDKException {

        // 定义文件路径
        String filePath = "H:\\20241212测试.xlsx";

        // 使用Paths类来获取Path对象
        Path path = Paths.get(filePath);

        // 获取文件名
        Path fileName = path.getFileName();

        // 获取文件扩展名
        String fileExt = "";
        if (fileName != null) {
            String fullName = fileName.toString();
            int dotIndex = fullName.lastIndexOf('.');
            if (dotIndex != -1 && dotIndex < fullName.length() - 1) {
                fileExt = fullName.substring(dotIndex + 1);
            }
        }

        // 打印文件路径、文件名和文件扩展名
        System.out.println("filePath: " + filePath);
        System.out.println("fileName: " + fileName);
        System.out.println("fileExt: " + fileExt);

        //   1. 获取临时密钥
        Credential cred = new Credential(SecretID, SecretKey);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(EndPoint);

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        CommonClient client = new CommonClient("lke", "2023-11-30", cred, Region, clientProfile);

        // 请注意，此处为离线文档上传，TypeKey取值为offline; 如果需要复用此处代码上传实时文档，需要修改TypeKey取值为 realtime
        String params = String.format("{\"BotBizId\":\"%s\",\"FileType\":\"%s\",\"TypeKey\":\"%s\"}", BotBizID, fileExt, TypeKeyOffline);

        String resp = client.call("DescribeStorageCredential", params);

        System.out.println("resp:"+resp);
        // 使用Gson库解析JSON响应
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(resp).getAsJsonObject();

        // 获取Response中的Credentials
        String tmpSecretId = jsonObject.get("Response").getAsJsonObject().get("Credentials").getAsJsonObject().get("TmpSecretId").getAsString();
        String tmpSecretKey = jsonObject.get("Response").getAsJsonObject().get("Credentials").getAsJsonObject().get("TmpSecretKey").getAsString();
        String tmpToken = jsonObject.get("Response").getAsJsonObject().get("Credentials").getAsJsonObject().get("Token").getAsString();
        String uploadPath = jsonObject.get("Response").getAsJsonObject().get("UploadPath").getAsString();
        String bucket = jsonObject.get("Response").getAsJsonObject().get("Bucket").getAsString();
        String regionInfo = jsonObject.get("Response").getAsJsonObject().get("Region").getAsString();

        System.out.printf("tmpSecretId:%s\n", tmpSecretId);
        System.out.printf("tmpSecretKey:%s\n", tmpSecretKey);
        System.out.printf("tmpToken:%s\n", tmpToken);
        System.out.printf("uploadPath:%s\n", uploadPath);
        System.out.printf("bucket:%s\n", bucket);
        System.out.printf("region:%s\n", regionInfo);


        // 2.将文件上传到cos
        BasicSessionCredentials cosCred = new BasicSessionCredentials(tmpSecretId, tmpSecretKey, tmpToken);
        // region
        Region region = new Region(regionInfo);
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cosCred, clientConfig);


        // 指定要上传的文件
        File localFile = new File(filePath);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, uploadPath, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(putObjectResult);
        String eTag = putObjectResult.getETag();
        String cosHash = putObjectResult.getCrc64Ecma();
        Long fileSize = localFile.length();



        // 3.调用SaveDoc,将相关元数据存储到知识引擎
        String saveDocReq = String.format(
                "{" +
                        "\"BotBizId\": \"%s\"," +
                        "\"FileName\": \"%s\"," +
                        "\"FileType\": \"%s\"," +
                        "\"CosUrl\": \"%s\"," +
                        "\"ETag\": \"%s\"," +
                        "\"CosHash\": \"%s\"," +
                        "\"Size\": \"%d\"," +
                        "\"AttrRange\": 1," +
                        "\"Source\": 0," +
                        "\"WebUrl\": \"\"," +
                        "\"AttrLabels\": []," +
                        "\"IsRefer\": true," +
                        "\"ReferUrlType\": 0," +
                        "\"ExpireStart\": \"%d\"," +
                        "\"Opt\": 2" +
                        "}",
                BotBizID, fileName, fileExt, uploadPath, eTag, cosHash, fileSize, System.currentTimeMillis() / 1000
        );

        System.out.println("saveDocReq:" + saveDocReq);
        System.out.println("eTag:" + eTag);
        System.out.println("cosHash:" + cosHash);
        System.out.println("fileSize:" + fileSize);

        String saveDocRsp = client.call("SaveDoc", saveDocReq);

        // {"Response":{"RequestId":"d7255961-bf8d-4f54-823e-4516a95ccb17","DocBizId":"1866792510909170688","ErrorLink":"","ErrorLinkText":"","ErrorMsg":""}}
        System.out.println(saveDocRsp);
    }
}
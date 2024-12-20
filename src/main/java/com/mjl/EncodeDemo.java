package com.mjl;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

/**
 * @author mjl
 * @date 2024/11/27.
 */
public class EncodeDemo {

    /**
     * 加解密统一编码方式
     */
    private final static String ENCODING = "utf-8";

    /**
     * 加解密方式
     */
    private final static String ALGORITHM = "AES";

    /**
     * 加密模式及填充方式
     */
    private final static String PATTERN = "AES/ECB/pkcs5padding";

    /**
     * 秘钥生成来源
     */
    public static final String ALLCHAR = "H28fO3yv";

    /**
     * 生成AES密钥对象
     *
     */
    public static String generateAESKey() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }


    /**
     * AES加密
     *
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText, String key) throws Exception {
        if (key == null) {
            System.out.print("Key为空null");
            return null;
        }
        if (key.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        SecretKey secretKey = new SecretKeySpec(key.getBytes(ENCODING), ALGORITHM);
        Cipher cipher = Cipher.getInstance(PATTERN);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(ENCODING));
        return Base64.getEncoder().encodeToString(encryptData);
    }


    /**
     * AES解密
     *
     * @param plainText
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String plainText, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(ENCODING), ALGORITHM);
        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(PATTERN);
        // 初始化密码器（解密模型）
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // 解密数据, 返回明文
        byte[] encryptData = cipher.doFinal(Base64.getDecoder().decode(plainText));
        return new String(encryptData, ENCODING);
    }

    public static void main(String[] args) throws Exception {
        String key = generateAESKey();
        System.out.println(encrypt("123456",key));
        System.out.println(decrypt(encrypt("123456",key),key));
    }


    public static String md5(String plainString) {
        String cipherString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] cipherBytes = messageDigest.digest(plainString.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : cipherBytes) {
                sb.append(String.format("%02x", b));
            }
            cipherString = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipherString;
    }


}

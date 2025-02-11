package com.mjl.util;


/**
 * @author mjl
 * @date 2024/12/25.
 */
public class SnowFlakeUtil {
    public static long getId() {
        SnowflakeIdWorker idWorkerPro = new SnowflakeIdWorker(0,0);
        return idWorkerPro.nextId();
    }
}


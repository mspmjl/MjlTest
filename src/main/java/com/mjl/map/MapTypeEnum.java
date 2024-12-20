package com.mjl.map;

import org.springframework.util.StringUtils;

/**
 * @author luoye
 * @date 2021/12/29
 */
public enum MapTypeEnum {
    /**
     * 高德
     */
    AMAP("amap", "高德"),
    /**
     * 百度
     */
    BMAP("bmap", "百度"),
    /**
     * arcgis
     */
    ARCGIS("gmap", "arcgis"),
    /**
     * 天地图
     */
    TMAP("tmap", "天地图"),
    /**
     * 图吧
     */
    MAPBAR("MapBar", "图吧"),
    /**
     * 谷歌
     */
    GOOGLE("Google", "谷歌"),
    /**
     * 盐都天地图
     */
    GCJWEB("Gcjweb", "盐都天地图"),
    /**
     * 南宁地图
     */
    NNWEB("Nnweb", "南宁地图"),
    /**
     * 湖州地图
     */
    HZWEB("Hzweb", "湖州地图"),
    /**
     * 天津地图
     */
    TJWEB("Tjweb", "天津地图"),
    /**
     * 高德
     */
    MAPABC("MapABC", "高德");


    /**
     * 键
     */
    private final String key;

    /**
     * 值
     */
    private final String value;


    MapTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static MapTypeEnum findByKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        for (MapTypeEnum e : MapTypeEnum.values()) {
            if (key.equals(e.getKey())) {
                return e;
            }
        }
        return null;
    }


    public static String findValueByKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        for (MapTypeEnum e : MapTypeEnum.values()) {
            if (key.equals(e.getKey())) {
                return e.value;
            }
        }
        return null;
    }
}

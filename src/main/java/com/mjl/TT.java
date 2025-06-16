package com.mjl;

import org.locationtech.proj4j.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MJL
 * @date 2021/12/8.
 */
@Transactional(rollbackFor = Exception.class)
public class TT {
    public static void main(String[] args) throws Exception {
        System.out.println(CalUtil.round(1 + Math.random() * 10, 2));

    }

//2|397941.76596182695|3931137.8856470115
//3|395394.95124628046|3933570.0351037313
//4|395670.9045302642|3931228.656110131
//5|397843.36991795414|3929093.228570462
//6|402366.0423875414|3936157.853063973
//7|390912.1793956914|3932216.392647517
//9|390891.79760301474|3932235.310034141
//10|390882.1621445118|3932249.5009717485
//11|390890.6504318865|3932201.093712849
//12|392469.64755108044|3930422.938087983
//13|392401.1964698629|3930375.851813662
//14|393040.06519336463|3927841.239563757
//15|392778.64553434146|3927807.455681659
//16|394572.3395067438|3928219.9156630845
//17|396336.28514942725|3928156.468431358
//18|393537.7826519737|3928061.115179662
//19|397526.6673055751|3928988.502825705
//20|395831.50561993395|3933629.1782485233
//21|395042.5099335846|3928201.2986903074
//22|394789.6127138608|3933402.9715217343
//24|390788.64170165703|3932261.821144633
//8|390788.683188775|3932245.3008842594
//25|390788.89559768984|3932232.796696725
//1|390787.4755219243|3932195.5748100886

    public static ProjCoordinate WGS84TOCGS2000(double x, double y) {
        // 定义坐标转换器
        CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
        // 定义源和目标投影
        CRSFactory crsFactory = new CRSFactory();
        CoordinateReferenceSystem sourceCRS = crsFactory.createFromName("EPSG:4326"); // 原始坐标系
        CoordinateReferenceSystem targetCRS = crsFactory.createFromName("EPSG:4547"); // 目标坐标系
        // 创建转换器
        CoordinateTransform transform = ctFactory.createTransform(sourceCRS, targetCRS);
        // 执行坐标转换
        ProjCoordinate srcCoord = new ProjCoordinate(x, y);
        ProjCoordinate targetCoord = new ProjCoordinate();
        transform.transform(srcCoord, targetCoord);
        // 4. 输出转换后的正常经纬度坐标
        return targetCoord;
    }


    public static ProjCoordinate CGS2000TOWGS84(double x, double y) {
        // 定义坐标转换器
        CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
        // 定义源和目标投影
        CRSFactory crsFactory = new CRSFactory();
        CoordinateReferenceSystem sourceCRS = crsFactory.createFromName("EPSG:4547"); // 原始坐标系
        CoordinateReferenceSystem targetCRS = crsFactory.createFromName("EPSG:4326"); // 目标坐标系
        // 创建转换器
        CoordinateTransform transform = ctFactory.createTransform(sourceCRS, targetCRS);
        // 执行坐标转换
        ProjCoordinate srcCoord = new ProjCoordinate(x, y);
        ProjCoordinate targetCoord = new ProjCoordinate();
        transform.transform(srcCoord, targetCoord);
        // 4. 输出转换后的正常经纬度坐标
        return targetCoord;
    }

}

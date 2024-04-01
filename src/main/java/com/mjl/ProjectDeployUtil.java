package com.mjl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MJL
 * @date 2024/2/19.
 */
public class ProjectDeployUtil {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();


        FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\项目部署文档\\昌润达部署清单-副本.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int index = 1;
        Row row = null;
        Cell cell = null;
        String name = null;
        do {
            row = sheet.getRow(index);
            if (row != null) {
                cell = row.getCell(2);
                name = cell.getStringCellValue();
                System.out.println(name);
                Cell gitCell = row.getCell(6);
                if (gitCell == null) {
                    gitCell = row.createCell(6);
                }
                String gitPath = getGitPath(name);
                gitCell.setCellValue(getGitPath(name));
            }
            index++;
        } while (row != null);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DELL\\Desktop\\项目部署文档\\昌润达部署清单.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        fis.close();
    }

    private static String getGitPath(String name) {
        if (name.contains("缓存") || name.contains("cache")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/cache/backend.git";
        }
        if (name.contains("车辆管理") || name.contains("clgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/cloud-clglv2/backend.git";
        }
        if (name.contains("作业人员") || name.contains("zyry")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/cloud-zyryv2/backend.git";
        }
        if (name.contains("车辆运行") || name.contains("clyx")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/clyx/backend.git";
        }
        if (name.contains("gateway") || name.contains("网关")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/gateway/backend.git";
        }
        if (name.contains("ljsy") || name.contains("收运") || name.contains("清运")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/hw-cloud-ljsy/backend.git";
        }
        if (name.contains("jxbj") || name.contains("机械保洁")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/jxbj-new/backend.git";
        }
        if (name.contains("库存管理") || name.contains("kcgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/kcgl_new/backend.git";
        }
        if (name.contains("设备报警") || name.contains("sbbj")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/sbbj/backend.git";
        }
        if (name.contains("视频") || name.contains("spjg")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/spjg/backend.git";
        }
        if (name.contains("文件") || name.contains("file")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/vortex-file/backend.git";
        }
        if (name.contains("垃圾分类")||name.contains("预约回收")) {
            return "https://git.cloudhw.cn:3443/envcloud/project/hw/changrunda/ljfl-yuyuehuishou/backend.git";
        }
        if (name.contains("数据同步")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/syncdata/backend.git";
        }
        if (name.contains("设施") || name.contains("ssgl") || name.contains("sszhgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/ssgl-v2/backend.git";
        }
        if (name.contains("eureka")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/vortex-ops/backend.git";
        }
        if (name.contains("app") || name.contains("APP") || name.contains("App")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/app/backend.git";
        }
        if (name.contains("问题上报") || name.contains("wtsb")||name.contains("品质督察")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/wtsb/backend.git";
        }
        if (name.contains("项目管控") || name.contains("xmgk")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/xmgk-new/backend.git";
        }
        if (name.contains("垃圾处置") || name.contains("ljcz")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/ljcz/backend.git";
        }
        if (name.contains("项目合同") || name.contains("xmht")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/xmht/backend.git";
        }
        if (name.contains("车辆维修") || name.contains("clwx")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/clwxfw/frontend/clwxfw.git";
        }
        if (name.contains("油耗") || name.contains("oil")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/oil-new/backend.git";
        }
        if (name.contains("指挥调度") || name.contains("zhdd")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v2/zhdd/backend.git";
        }
        if (name.contains("公厕管理") || name.contains("gcgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/gcgl/backend.git";
        }
        if (name.contains("考核管理") || name.contains("khgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/khgl/backend.git";
        }
        if (name.contains("垃圾收转运") || name.contains("ljszy")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/ljszy/backend.git";
        }
        if (name.contains("排班管理") || name.contains("pbgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/pbgl/backend.git";
        }
        if (name.contains("融云") || name.contains("rongcloud")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/rongcloud/backend.git";
        }
        if (name.contains("设备综合管理") || name.contains("sbzhgl") || name.contains("设备管理") || name.contains("sbgl")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/sbzhgl/backend.git";
        }
        if (name.contains("ums") || name.contains("UMS")) {
            return "https://git.cloudhw.cn:3443/product/ums/backend.git";
        }
        if (name.contains("analysis") || name.contains("日志")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/analysis-v1/backend.git";
        }
        if (name.contains("cas") || name.contains("CAS")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/vortex-cas/backend.git";
        }
        if (name.contains("wechat") || name.contains("微信")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/vortex-wechat/backend.git";
        }
        if (name.contains("人员台账") || name.contains("rytz")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/rytz/backend.git";
        }
        if (name.contains("xxl-job") || name.contains("xxl-admin") || name.contains("定时器管理端")) {
            return "https://git.cloudhw.cn:3443/envcloud/product/hw-v1/xxl-job/backend.git";
        }
        return "";
    }
}

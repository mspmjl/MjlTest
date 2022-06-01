package com.mjl;

import com.mjl.util.ExcelUtil;
import com.mjl.util.YhtDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author MJL
 * @date 2021/12/8.
 */
public class TT {
    public static void main(String[] args) throws IOException {
        ExcelUtil util = new ExcelUtil(YhtDTO.class);
        List<YhtDTO> list = util.importExcel(new File("C:\\Users\\DELL\\Desktop\\副本玉禾田需要删除的角色清单.xlsx"), YhtDTO.class, "", 2);
        for (YhtDTO yhtDTO : list) {

        }
    }
}

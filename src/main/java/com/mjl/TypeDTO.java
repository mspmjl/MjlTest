package com.mjl;

import com.alibaba.fastjson.JSON;

/**
 * @author MJL
 * @date 2021/9/24.
 */
public class TypeDTO {
    private String parmCode;
    private String parmName;

    public String getParmCode() {
        return parmCode;
    }

    public void setParmCode(String parmCode) {
        this.parmCode = parmCode;
    }

    public String getParmName() {
        return parmName;
    }

    public void setParmName(String parmName) {
        this.parmName = parmName;
    }
}

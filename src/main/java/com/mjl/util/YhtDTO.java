package com.mjl.util;

/**
 * @author MJL
 * @date 2022/5/31.
 */
public class YhtDTO {
    @ExcelAttribute(column = "A", name = "")
    private String system;
    @ExcelAttribute(column = "B", name = "")
    private String groupRole;
    @ExcelAttribute(column = "C", name = "")
    private String role;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(String groupRole) {
        this.groupRole = groupRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

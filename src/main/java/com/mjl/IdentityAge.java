package com.mjl;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author MJL
 * @date 2021/8/31.
 */
public class IdentityAge {
    final static String pattern = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

    public static void main(String[] args) {
        String num = "320222195406133441";
        System.out.println(Pattern.matches(pattern, num));
        System.out.println(num.substring(6, 14));
        LocalDate now = LocalDate.now();
        LocalDate parse = LocalDate.parse(num.substring(6, 14), DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(now.getYear() - parse.getYear());
    }
}


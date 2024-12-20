package com.mjl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author MJL
 * @date 2022/4/18.
 */
public class CalUtil {

    /**
     * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
     */

    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;


    /**
     * @param dividend     被除数
     * @param divisor      除数
     * @param scale        精确位数(默认2位)
     * @param roundingMode 舍入模式(默认四舍五入)
     * @return 商
     */
    public static Double divide(Object dividend, Object divisor, Integer scale, RoundingMode roundingMode) {
        Double d = 0D;
        try {
            if (dividend == null || divisor == null) {
                return d;
            }
            BigDecimal d1 = null;
            BigDecimal d2 = null;
            if (divisor instanceof Integer) {
                d2 = new BigDecimal((Integer) divisor);
            } else if (divisor instanceof Double) {
                d2 = new BigDecimal((Double) divisor);
            } else if (divisor instanceof Long) {
                d2 = new BigDecimal((Long) divisor);
            }  else if (divisor instanceof String) {
                d2 = new BigDecimal((String) divisor);
            } else if (divisor instanceof BigDecimal) {
                d2 = (BigDecimal) divisor;
            }
            if (d2 == null || d2.compareTo(BigDecimal.ZERO) == 0) {
                return d;
            }
            if (dividend instanceof Integer) {
                d1 = new BigDecimal((Integer) dividend);
            } else if (dividend instanceof Double) {
                d1 = new BigDecimal((Double) dividend);
            } else if (dividend instanceof Long) {
                d1 = new BigDecimal((Long) dividend);
            } else if (dividend instanceof BigDecimal) {
                d1 = (BigDecimal) dividend;
            }
            if (d1 == null) {
                return d;
            }
            if (scale == null) {
                scale = 2;
            }
            if (roundingMode == null) {
                roundingMode = RoundingMode.HALF_UP;
            }
            d = d1.divide(d2, scale, roundingMode).doubleValue();
            d = round(d, scale);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return 商
     */
    public static Double divide(Object dividend, Object divisor) {
        return divide(dividend, divisor, 2, RoundingMode.HALF_UP);
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return CalUtil.round(b1.add(b2).doubleValue(), scale);
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */

    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    @SuppressWarnings("deprecation")
    public static double div(double v1, double v2, int scale,int roundingMode) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        if (BigDecimal.ZERO.compareTo(b2) == 0) {
            return 0;
        }
        return b1.divide(b2, scale, roundingMode).doubleValue();
    }
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        if (BigDecimal.ZERO.compareTo(b2) == 0) {
            return 0;
        }
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */

    @SuppressWarnings("deprecation")
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static BigDecimal round(BigDecimal bigDecimal, int scale) {
        return bigDecimal == null ? null : bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }


    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        v1 = v1 == null ? BigDecimal.ZERO : v1;
        v2 = v2 == null ? BigDecimal.ZERO : v2;
        return v1.add(v2);
    }

    public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        if (BigDecimal.ZERO.compareTo(v2) == 0) {
            return BigDecimal.ZERO;
        }
        return v1.divide(v2, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static boolean isZero(BigDecimal v) {
        return v.compareTo(BigDecimal.ZERO) == 0;
    }

    public static boolean lessThanZero(BigDecimal v) {
        return v.compareTo(BigDecimal.ZERO) < 0;
    }
}

package com.mjl;

/**
 * @author MJL
 * @date 2021/11/8.
 */
public class CharDemo {
    public static void main(String[] args) {
        String str = "20ml";

        String regex1 = "[a-zA-Z]";

        String shuzi = str.replaceAll(regex1, "");

        System.out.println(shuzi);

        String regex2 = "\\d";

        String zimu = str.replaceAll(regex2, "");

        System.out.println(zimu);
    }
}

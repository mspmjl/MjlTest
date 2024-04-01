package com.mjl.util;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author MJL
 * @date 2023/12/18.
 */
public class FirstLetterFromPinyin {

    public static void main(String[] args) {
        System.out.println(getFirstLetter("iii我是谁"));
    }

    public static String getFirstLetter(String chinese) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chinese.length(); i++) {
            char c = chinese.charAt(i);
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                // 如果是中文，则取拼音的首字母
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
                if (pinyinArray != null && pinyinArray.length > 0) {
                    String pinyin = pinyinArray[0];
                    sb.append(Character.toUpperCase(pinyin.charAt(0)));
                }
            }
        }
        return sb.toString();
    }
}

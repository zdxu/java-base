package com.zdxu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaodexu on 2020/2/18.
 */
public class AboutRegex {

    /**
     * 常用元字符
     * . 匹配除换行符以外的任意字符
     * \w 匹配字母、数字、下划线或汉字
     * \s 匹配任意的空白符
     * \d 匹配数字
     * \b 匹配单词的开始与结束
     * ^ 匹配字符串的开始
     * $ 匹配字符串的结束
     *
     * 常用限定符
     * * 重复 0 次或更多次
     * + 重复 1 次或更多次
     * ？重复 0 次或 1 次
     * {n} 重复 n 次
     * {n,} 重复 n 次或更多次
     * {n, m} 重复 n 到 m 次
     *
     * [regex] 匹配 regex 的一个字符
     *
     * | 分支条件，和并
     *
     * () 分组
     *
     * 常用的反义代码
     * \W 匹配任意非字母、数字、下划线、汉字的字符
     * \S 匹配任意非空白符的字符
     * \D 匹配任意非数字的字符
     * \B 匹配任意非单词开头或结束的字符
     * [^xy] 匹配任意除 xy 以外的任意字符
     *
     * 贪婪与懒惰
     * 普通限定符是贪婪匹配
     * 普通限定符 + ？是懒惰匹配
     */

    public static void main(String[] args) {
        String str1 = "zdxu010203ddd0000aaaa";
        String str2 = "0101zdxu00203dddd0000";
        String str3 = "zdxu00100110";

        /**
         *
         * 对整个字符串进行匹配
         *
         * 等价于
         * Pattern pattern = Pattern.compile("\\b+[0-1]+");
         * Matcher matcher = pattern.matcher(str);
         * System.out.println(matcher.matches());
         *
         */
        System.out.println("pattern matches: ");
        System.out.println(Pattern.matches("[a-z]+[0-1]+", str1));
        System.out.println(Pattern.matches("[a-z]+[0-1]+", str2));
        System.out.println(Pattern.matches("[a-z]+[0-1]+", str3));
        System.out.println();


        /**
         * 构建 pattern
         */
        Pattern pattern = Pattern.compile("[a-z]+[0-1]*");

        /**
         * 根据匹配规则分割目标字符串
         */
        System.out.println("pattern split:");
        String[] ret1 = pattern.split(str1);
        System.out.println(toString(ret1));
        String[] ret2 = pattern.split(str2);
        System.out.println(toString(ret2));
        System.out.println();

        Matcher matcher1 = pattern.matcher(str1);
        Matcher matcher2 = pattern.matcher(str2);
        Matcher matcher3 = pattern.matcher(str3);

        /**
         * 对整个字符串进行匹配，整个匹配字符串与匹配规则一致
         */
        System.out.println("matcher matches:");
        System.out.println(matcher1.matches());
        System.out.println(matcher2.matches());
        System.out.println();
        /**
         * 对字符串进行匹配，匹配到的字符串可以在任意位置
         * 有点类似迭代器的 next，每次 find 会变更匹配开始位置
         */
        System.out.println("matcher find:");
        System.out.println(matcher1.find());
        System.out.println(matcher1.find());
        System.out.println(matcher1.find());
        System.out.println(matcher2.find());
        System.out.println();
        /**
         * 对前面的字符串进行匹配，只有匹配到的字符串在最前面才返回 true
         * 如：匹配数据 aa222、222aaa 匹配规则 \d+ 222aaa会被匹配到
         */
        System.out.println("matcher lookingAt:");
        System.out.println(matcher1.lookingAt());
        System.out.println(matcher2.lookingAt());
        System.out.println();

        if(matcher3.find()) {
            /**
             * 当前匹配的开始位置
             */
            System.out.println("matcher start:");
            System.out.println(matcher3.start());
            System.out.println();

            /**
             * 当前匹配的结束位置
             */
            System.out.println("matcher end:");
            System.out.println(matcher3.end());
            System.out.println();

            /**
             * 当前匹配上的字符串
             * group(int) 在匹配上多条数据时，可通过 int 参数指明具体某一条匹配的数据
             */
            System.out.println("matcher group:");
            System.out.println(matcher3.group());
        }
    }

    public static String toString(String[] strArr) {
        String ret = "";
        if(strArr != null && strArr.length > 0) {
            if (strArr.length == 1) {
                return strArr[0];
            }
            for (String str : strArr) {
                if(str == null || str == "") {
                    continue;
                }
                ret = String.format("%s%s,", ret, str);
            }
            return ret.substring(0, ret.length() - 1);
        }
        return ret;
    }
}

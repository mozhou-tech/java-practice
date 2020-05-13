package com.java.practice.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @author jerrylau
 */
public class IfStringShuffledEqual {

    static class Solution {

        static boolean CheckPermutation(String s1, String s2) {
            // 解法一：将字符串char[]排序观察是否得到一样的结果
            char[] s1Chars = s1.toCharArray();
            char[] s2Chars = s2.toCharArray();
            Arrays.sort(s1Chars);
            Arrays.sort(s2Chars);
            return Arrays.equals(s1Chars,s2Chars);

        }
    }


    public static void main(String[] args) {
        // true
        System.out.println(Solution.CheckPermutation("abc", "cab"));
        // false
        System.out.println(Solution.CheckPermutation("abc", "abe"));
    }
}

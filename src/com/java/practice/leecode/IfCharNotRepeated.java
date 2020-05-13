package com.java.practice.leecode;

/**
 * 字符串中的字符是否全部不同
 *
 * @author jerrylau
 */
public class IfCharNotRepeated {
    static class Solution {
        static boolean isUnique(String astr) {
            // 解法一：双层遍历
//            for (int i = 0; i < astr.length(); i++) {
//                char charJudge = astr.charAt(i);
//                for (char c : astr.toCharArray()) {
//                    if (charJudge == c && astr.indexOf(c) != i) {
//                        return true;
//                    }
//                }
//            }
//            return false;
            // 解法二：字符在字符串中的第一个位置和最后一个位置是否相等
            for (int i = 0; i < astr.length(); i++) {
                if (astr.lastIndexOf(astr.charAt(i)) != astr.indexOf(astr.charAt(i))) {
                    return false;
                }
            }
            // 解法三：字符串替换，观察长度减少是否大于1
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isUnique("abc"));
        System.out.println(Solution.isUnique("leecode"));
    }
}

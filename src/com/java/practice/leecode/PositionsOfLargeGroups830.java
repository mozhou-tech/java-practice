package com.java.practice.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最大分组的位置：在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * @author jerrylau
 */
public class PositionsOfLargeGroups830 {


    static class Solution {
        static List<List<Integer>> largeGroupPositions(String s) {
            // 解法一：
//            List<List<Integer>> resultList = new ArrayList<>();
//            for (int i = 0; i < s.length() - 2; i++) {
//                int step = 0;
//                while (true) {
//                    step++;
//                    if ((i + step) >= s.length()) {
//                        break;
//                    }
//                    if (s.charAt(i + step) != s.charAt(i)) {
//                        break;
//                    }
//                }
//                if (step >= 3) {
//                    resultList.add(Arrays.asList(i, i + step -1));
//                }
//                i = i + step - 1;
//            }
//            return resultList;
            // 解法二：
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.largeGroupPositions("aaaa"));
        System.out.println(Solution.largeGroupPositions("aaa"));
        System.out.println(Solution.largeGroupPositions("abcdddeeeeaabbbcd"));
    }

}

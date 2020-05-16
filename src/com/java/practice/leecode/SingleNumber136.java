package com.java.practice.leecode;

import org.apache.ibatis.reflection.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @author jerrylau
 */
public class SingleNumber136 {
    static class Solution {
        static int singleNumber(int[] nums) {
            // 解法一：异或运算
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                num^=nums[i];
            }
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(Solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(2^2);
        System.out.println(2^2^3);
    }
}

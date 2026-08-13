package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leetcode152 {
    static void main() {
        Leetcode152 leetcode33 = new Leetcode152();
        assertEquals(6, leetcode33.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, leetcode33.maxProduct(new int[]{-2, 0, -1}));
    }

    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int newMax = Math.max(current, Math.max(current * min, current * max));
            int newMin = Math.min(current, Math.min(current * min, current * max));
            max = newMax;
            min = newMin;
            result = Math.max(result, max);
        }
        return result;
    }
}



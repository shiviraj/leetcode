package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Leetcode238 {
    static void main() {
        Leetcode238 leetcode = new Leetcode238();
        assertArrayEquals(new int[]{24, 12, 8, 6}, leetcode.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, leetcode.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}



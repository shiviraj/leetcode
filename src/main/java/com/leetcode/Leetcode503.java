package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode503 {
    static void main() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1}))); //[2,-1,2]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3}))); //[2,3,4,-1,4]
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int len = nums.length;
        for (int i = 2 * len - 1; i >= 0; i--) {
            int index = i % len;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            }
            if (i < len && !stack.isEmpty()) {
                result[index] = nums[stack.peek()];
            }
            stack.push(index);
        }
        return result;
    }
}



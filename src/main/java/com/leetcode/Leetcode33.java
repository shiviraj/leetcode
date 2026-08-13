package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leetcode33 {
    static void main() {
        Leetcode33 leetcode33 = new Leetcode33();
        assertEquals(4, leetcode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, leetcode33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, leetcode33.search(new int[]{1,}, 0));
        assertEquals(2, leetcode33.search(new int[]{5,1,3}, 3));

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            } else{
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}



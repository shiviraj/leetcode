package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Leetcode56 {
    static void main() {
        Leetcode56 leetcode = new Leetcode56();
        int[][] result1 = {{1, 6}, {8, 10}, {15, 18}};
        int[][] result2 = {{1, 5}};
        int[][] result3 = {{1, 7}};
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] intervals3 = {{4, 7}, {1, 4}};
        assertArrayEquals(result1, leetcode.merge(intervals1));
        assertArrayEquals(result2, leetcode.merge(intervals2));
        assertArrayEquals(result3, leetcode.merge(intervals3));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                list.add(current);
                current = intervals[i];
            }
        }
        list.add(current);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}



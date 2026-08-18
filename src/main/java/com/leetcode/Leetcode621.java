package com.leetcode;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leetcode621 {
    static void main() {
        Leetcode621 leetcode = new Leetcode621();
        assertEquals(8, leetcode.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        assertEquals(6, leetcode.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));
        assertEquals(10, leetcode.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        int maxFreqTasks = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqTasks++;
            }
        }

        int frameLength = (maxFreq - 1) * (n + 1) + maxFreqTasks;

        return Math.max(frameLength, tasks.length);
    }
}



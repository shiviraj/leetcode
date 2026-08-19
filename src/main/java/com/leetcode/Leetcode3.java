package com.leetcode;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leetcode3 {
    static void main() {
        Leetcode3 leetcode = new Leetcode3();
        assertEquals(3, leetcode.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, leetcode.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, leetcode.lengthOfLongestSubstring("pwwkew"));

    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}



package com.leetcode;

import java.util.*;

public class Leetcode49 {
    static void main() {
        Leetcode49 leetcode = new Leetcode49();
        System.out.println((leetcode.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] text = str.toCharArray();
            Arrays.sort(text);
            String key = new String(text);
            map.computeIfAbsent(key, (r) -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}



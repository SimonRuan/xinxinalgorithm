package com.ruanxinxin.mvc01.algorithm;

import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        int[] array = new int[26];
        for (String str : strs) {
            Arrays.fill(array, 0);
            for (int i = 0; i < str.length(); i++) {
                array[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int anArray : array) {
                sb.append("#");
                sb.append(anArray);
            }
            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());


    }


}

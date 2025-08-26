class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int p_len = p.length();
        int s_len = s.length();
        if (p_len > s_len) {
            return res;
        }
        Map<Character, Integer> p_map = new HashMap<>();
        Map<Character, Integer> window_map = new HashMap<>();
        int i = 0;
        p_map = countCharacters(p);
        window_map = countCharacters(s.substring(i, i + p_len));

        while (i < s.length()) {
            boolean isEqual = areCharCountMapsEqual(p_map, window_map);
            if (isEqual) {
                res.add(i);
            }
            // 移除第一个元素
            char c = s.charAt(i);
            window_map.put(c, window_map.get(c) - 1);
            if (window_map.get(c) == 0) {
                window_map.remove(c);
            }
            // 窗口右移，更新窗口
            i++;
            if (i + p_len > s.length()) {
                break;
            }
            c = s.charAt(i + p_len - 1);
            if (window_map.containsKey(c)) {
                window_map.put(c, window_map.get(c) + 1);
            } else {
                window_map.put(c, 1);
            }

        }
        return res;
    }

    public static Map<Character, Integer> countCharacters(String str) {
        // 创建一个HashMap存储字符和其出现次数
        Map<Character, Integer> charCountMap = new HashMap<>();

        // 遍历字符串中的每个字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 如果字符已经在Map中，将计数加1
            // 否则，将字符添加到Map中，计数设为1
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        return charCountMap;
    }

    public static boolean areCharCountMapsEqual(Map<Character, Integer> map1,
            Map<Character, Integer> map2) {
        if (map1 == null && map2 == null) {
            return true;
        }
        if (map1 == null || map2 == null) {
            return false;
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!map2.containsKey(key)) {
                return false;
            }
            Integer otherValue = map2.get(key);
            if (!value.equals(otherValue)) {
                return false;
            }
        }
        return true;
    }
}
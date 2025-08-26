class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();

        // 初始化第一个窗口
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        // 检查第一个窗口
        if (pMap.equals(windowMap)) {
            result.add(0);
        }

        // 开始滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 1. 添加新字符到窗口右边
            char charToAdd = s.charAt(i);
            windowMap.put(charToAdd, windowMap.getOrDefault(charToAdd, 0) + 1);

            // 2. 移除旧字符从窗口左边
            char charToRemove = s.charAt(i - p.length());
            int count = windowMap.get(charToRemove);
            if (count == 1) {
                windowMap.remove(charToRemove);
            } else {
                windowMap.put(charToRemove, count - 1);
            }

            // 3. 比较map
            if (pMap.equals(windowMap)) {
                // 当前窗口的起始索引是 i - p.length() + 1
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        int winLen = 0;
        List<Integer> result = new ArrayList();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1.入：添加字符串到窗口右侧
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            winLen++;

            if (winLen < len) {
                continue;
            }
            // 2.更新
            if (pMap.equals(windowMap)) {
                result.add(i - p.length() + 1);
            }
            // 3.出：移除旧字符串
            char charToRemove = s.charAt(i - p.length() + 1);
            int count = windowMap.get(charToRemove);
            if (count == 1) {
                windowMap.remove(charToRemove);
            } else {
                windowMap.put(charToRemove, count - 1);
            }
            winLen--;

        }

        return result;
    }
}
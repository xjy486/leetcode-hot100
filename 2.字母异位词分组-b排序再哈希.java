class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. 对strs数组进行排序
        String[] sortedStrs = sortStrings(strs);
        // 2. hashmap构建键值对
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String sortedS = sortedStrs[i];
            // 如果已经存在key
            if (map.containsKey(sortedS)) {
                map.get(sortedS).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedS, list);
            }
        }
        List<List<String>> ans = map.values()
                .stream()
                .collect(Collectors.toList());
        return ans;
    }

    // 排序
    public static String[] sortStrings(String[] strs) {
        String[] sorted = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            sorted[i] = new String(arr);
        }
        return sorted;
    }
}
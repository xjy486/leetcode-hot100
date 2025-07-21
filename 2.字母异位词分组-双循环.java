class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            boolean matched = false;
            for (String key : map.keySet()) {
                if (isArrange(key, str)) {
                    matched = true;
                    map.get(key).add(str);
                }
            }
            if (matched == false) {
                List<String> list = new ArrayList();
                list.add(str);
                map.put(str, list);
            }
        }
        List<List<String>> ans = map.values()
                .stream()
                .collect(Collectors.toList());
        return ans;
    }

    public static boolean isArrange(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int count[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;
    }
}
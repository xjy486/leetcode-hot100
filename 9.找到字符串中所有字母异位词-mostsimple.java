class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] cntP = new int[26];
        int[] cntS = new int[26];
        for (char c : p.toCharArray()) {
            cntP[c - 'a'] += 1;
        }

        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++;
            int left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(cntP, cntS)) {
                result.add(left);
            }
            cntS[s.charAt(left) - 'a']--;

        }
        return result;
    }
}
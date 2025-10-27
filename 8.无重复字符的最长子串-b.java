class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cnt = new HashMap();
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0) + 1);

            while (cnt.getOrDefault(s.charAt(right), 0) > 1) {
                cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
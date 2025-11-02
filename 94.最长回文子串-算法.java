class Solution {
    // 原串长度 = 新串回文半径
    public String longestPalindrome(String s) {
        StringBuilder tBuilder = new StringBuilder("^#");
        for(char c : s.toCharArray()) {
            tBuilder.append(c).append('#');
        }
        tBuilder.append('$');
        String t = tBuilder.toString();

        int n = t.length();
        int[] p = new int[n];

        int center = 0, maxRight = 0;
        for(int i = 1; i < n-1; i++) {
            int i_mirror = 2 * center - i;
            if(i < maxRight) {
                p[i] = Math.min(p[i_mirror], maxRight-i);
            } else {
                p[i] = 0;
            }

            while(t.charAt(i + 1 + p[i]) == t.charAt(i -1 - p[i])) {
                p[i]++; // 半径加加
            }

            if(i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for(int i = 1; i < n - 1; i++) {
            if(p[i] > maxLen) {
                maxLen  = p[i];
                centerIndex = i;
            }
        }
       int start = (centerIndex - maxLen) / 2;
       return s.substring(start,start+maxLen);

    }
}
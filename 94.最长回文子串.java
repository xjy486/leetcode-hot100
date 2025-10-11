class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // 如果字符串长度小于2，它本身就是最长回文子串
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int begin = 0;

        // base case: 所有长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // L 代表子串的长度，从 2 开始遍历
        for (int L = 2; L <= n; L++) {
            // i 代表子串的起始下标
            for (int i = 0; i <= n - L; i++) {
                // j 代表子串的结束下标
                int j = i + L - 1;

                // 状态转移只看两端字符是否相等
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 如果两端字符相等，再分情况
                    // 1. 如果子串长度小于等于3 (比如 "aa", "aba")，那它一定是回文串
                    // 2. 如果子串长度大于3，则需要看内部子串 dp[i+1][j-1] 是不是回文
                    if (L <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 上面的 if-else 也可以合并成一行：
                // dp[i][j] = (s.charAt(i) == s.charAt(j)) && (L <= 3 || dp[i+1][j-1]);

                // 如果找到了一个新的回文串，并且它更长，就更新记录
                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
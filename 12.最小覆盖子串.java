class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 1. Setup our 'need' map and counter
        Map<Character, Integer> needMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int have = 0;
        int need = needMap.size();

        // Variables to store our best result
        int resultLength = Integer.MAX_VALUE;
        int resultStart = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        // 2. Expand the window with the 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if 'c' is a needed character and if we've met the count
            if (needMap.containsKey(c) && windowMap.get(c).equals(needMap.get(c))) {
                have++;
            }

            // 3. Shrink the window when it's valid
            while (have == need) {
                // a. Is this current window the best one yet?
                if ((right - left + 1) < resultLength) {
                    resultLength = right - left + 1;
                    resultStart = left;
                }

                // b. Shrink from the left
                char charToRemove = s.charAt(left);
                windowMap.put(charToRemove, windowMap.get(charToRemove) - 1);

                // c. Did we just lose a required character count?
                if (needMap.containsKey(charToRemove) && windowMap.get(charToRemove) < needMap.get(charToRemove)) {
                    have--;
                }

                // d. Actually move the pointer
                left++;
            }
        }

        // 4. Return the result
        if (resultLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(resultStart, resultStart + resultLength);
        }
    }
}
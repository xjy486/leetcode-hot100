class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backTrack(s, 0, new ArrayList<String>());
        return result;

    }

    public void backTrack(String s, int startIndex, List<String> path) {
        if (startIndex == s.length()) {
            result.add(new ArrayList(path));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isTrue(sub)) {
                path.add(new String(sub));
                backTrack(s, i + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }

    public boolean isTrue(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;

        }
        return true;
    }
}
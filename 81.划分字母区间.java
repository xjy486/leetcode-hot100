class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> maxPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            maxPos.put(s.charAt(i), i);
        }
        int end = 0;
        int lastEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, maxPos.get(s.charAt(i)));
            if (i == end) {
                result.add(end - lastEnd + 1);
                // end = i + 1;
                lastEnd = i + 1;
            }
        }
        return result;
    }
}
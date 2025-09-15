class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(n, new StringBuilder(), 0, 0);
        return result;
    }

    public void backTrack(int n, StringBuilder sb, int leftCount, int rightCount) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (leftCount < n) {
            sb.append('(');
            leftCount++;
            backTrack(n, sb, leftCount, rightCount);
            sb.deleteCharAt(sb.length() - 1);
            leftCount--;
        }
        if (rightCount < leftCount) {
            sb.append(')');
            rightCount++;
            backTrack(n, sb, leftCount, rightCount);
            sb.deleteCharAt(sb.length() - 1);
            rightCount--;
        }

    }

    public boolean isLegal(StringBuilder sb) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.add(sb.charAt(i));
            } else {
                if (stack.size() != 0) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0)
            return true;
        return false;
    }
}
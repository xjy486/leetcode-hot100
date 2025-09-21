class Solution {
    public String decodeString(String s) {
        Deque<String> stringStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        StringBuilder currString = new StringBuilder("");
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int code = (int) ch;
            // ch : a~z
            if (Character.isLetter(ch)) {
                currString.append(ch);
                continue;
            }
            if (Character.isDigit(ch)) {
                currNum = (code - 48) + currNum * 10;
                continue;
            }
            if (ch == '[') {
                numStack.push(currNum);
                stringStack.push(currString.toString());
                currNum = 0;
                currString.delete(0, currString.length());
                continue;
            }
            if (ch == ']') {
                int repeatCount = numStack.pop();
                String prevString = stringStack.pop();
                currString = new StringBuilder(prevString + currString.toString().repeat(repeatCount));
            }
        }
        return currString.toString();
    }
}
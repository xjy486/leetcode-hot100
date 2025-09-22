class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        // 维护一个不严格单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int j = stack.pop();
                if (stack.isEmpty()) {
                    int area = i * heights[j];
                    ans = Math.max(area, ans);
                } else {
                    int area = (i - stack.peek() - 1) * heights[j];
                    ans = Math.max(area, ans);
                }

            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            if (stack.isEmpty()) {
                int area = n * heights[j];
                ans = Math.max(area, ans);
            } else {
                int area = (n - stack.peek() - 1) * heights[j];
                ans = Math.max(area, ans);
            }

        }
        return ans;
    }
}
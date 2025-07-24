class Solution {
    public int maxArea(int[] height) {
        // 最大容器面积
        int maxArea = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;

        while (left < right) {
            // 当前容器的面积
            int currentArea = getArea(left, right, height);
            // 更新最大面积
            maxArea = Math.max(maxArea, currentArea);

            // 移动较短的板子对应的指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // 获取两个板子之间的最小高度
    public int getMin(int a, int b) {
        return a > b ? b : a;
    }

    // 计算当前容器的面积
    public int getArea(int left, int right, int[] height) {
        return (right - left) * getMin(height[left], height[right]);
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 步骤 1: 确保 nums1 是较短的数组，以优化二分查找
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1); // 交换数组，递归调用
        }

        int left = 0;
        int right = m; // 在 [0, m] 范围内查找分割点 i

        while (left <= right) {
            // 步骤 2: 在 nums1 中找到分割点 i，并计算出 nums2 的分割点 j
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // 步骤 3: 获取四个边界值，并处理 i=0, i=m, j=0, j=n 的边缘情况
            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 步骤 4: 检查是否找到了完美的分割点
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // 找到了，根据总长度的奇偶性计算中位数
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    double maxLeft = Math.max(maxLeft1, maxLeft2);
                    double minRight = Math.min(minRight1, minRight2);
                    return (maxLeft + minRight) / 2.0;
                }
            }
            // 步骤 5: 如果没找到，根据边界值的大小调整二分查找的范围
            else if (maxLeft1 > minRight2) {
                // i 太大了，需要向左移动
                right = i - 1;
            } else {
                // i 太小了，需要向右移动
                left = i + 1;
            }
        }

        // 如果输入数组无效，则会到达这里
        throw new IllegalArgumentException("输入数组不是有效的有序数组。");
    }
}
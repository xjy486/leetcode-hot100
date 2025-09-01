class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. 转置矩阵：沿主对角线翻转 (i, j) <-> (j, i)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // 注意：j < i，只处理下三角
                // 直接内联交换，无需单独函数
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 每一行左右翻转（列对称翻转）
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                // 交换 matrix[i][left] 和 matrix[i][right]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
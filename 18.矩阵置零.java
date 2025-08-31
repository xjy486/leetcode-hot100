class Solution {
    public void setZeroes(int[][] matrix) {
        // 用于记录第一行和第一列是否原本就包含0
        // 因为我们将利用第一行和第一列作为标记数组来节省空间
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        int m = matrix.length; // 矩阵的行数
        int n = matrix[0].length; // 矩阵的列数

        // 检查第一列是否有0（即 matrix[i][0] 是否为0）
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true; // 标记第一列原本有0
                break;
            }
        }

        // 检查第一行是否有0（即 matrix[0][j] 是否为0）
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true; // 标记第一行原本有0
                break;
            }
        }

        // 遍历矩阵的其余部分（从第2行第2列开始，即 i=1, j=1）
        // 如果 matrix[i][j] 为0，则将对应的第一行和第一列位置标记为0
        // 即：matrix[i][0] = 0 和 matrix[0][j] = 0
        // 这样我们就可以用第一行和第一列表示哪一行/列需要被置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // 标记第i行需要被置为0
                    matrix[0][j] = 0; // 标记第j列需要被置为0
                }
            }
        }

        // 再次遍历矩阵的非第一行/列部分
        // 如果当前行或列的“标记位”为0（即 matrix[i][0] 或 matrix[0][j] 为0）
        // 就将 matrix[i][j] 置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后处理第一列：如果原本第一列有0，就将整列置为0
        if (isFirstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        // 最后处理第一行：如果原本第一行有0，就将整行置为0
        if (isFirstRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
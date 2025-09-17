class Solution {
    public List<List<String>> result;
    public int[] currentBoard;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        currentBoard = new int[n];
        for (int i = 0; i < n; i++) {
            currentBoard[i] = -1;
        }
        backTrack(n, 0, new ArrayList<String>());
        return result;
    }

    public void backTrack(int n, int curr_row, List<String> curr) {
        if (curr.size() == n) {
            result.add(new ArrayList(curr));
        }
        // 遍历列，找到合适的列
        for (int i = 0; i < n; i++) {
            if (isValid(curr_row, i, currentBoard)) {
                currentBoard[curr_row] = i;
                addString(n, i, curr);
                backTrack(n, curr_row + 1, curr);
                curr.remove(curr.size() - 1);
                currentBoard[curr_row] = -1;
            }
        }

    }

    public void addString(int n, int col, List<String> curr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (col == i) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        curr.add(sb.toString());
    }

    public boolean isValid(int row, int col, int[] board) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            // 检查是否在同一列 或 同一对角线
            if (board[prevRow] == col || Math.abs(board[prevRow] - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }
        return true;
    }

}
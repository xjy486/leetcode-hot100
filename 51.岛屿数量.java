class Solution {
    public int m;
    public int n;
    public int count;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    count += 1;
                }

            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
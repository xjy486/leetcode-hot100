class Solution {
    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Queue<Coordinate> queue = new LinkedList<>();
    private int freshOrangesCount = 0;
    private int minutes = 0;
    private int m;
    private int n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    freshOrangesCount++;
                else if (grid[i][j] == 2) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        bfs(grid);
        if (freshOrangesCount > 0) {
            return -1;
        }
        return minutes;
    }

    public void bfs(int[][] grid) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Coordinate c = queue.poll();
                int row = c.x;
                int col = c.y;
                // 检查4个方向
                if (row + 1 < m && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.offer(new Coordinate(row + 1, col));
                    freshOrangesCount--;
                    flag = true;
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.offer(new Coordinate(row - 1, col));
                    freshOrangesCount--;
                    flag = true;
                }
                if (col + 1 < n && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.offer(new Coordinate(row, col + 1));
                    freshOrangesCount--;
                    flag = true;
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.offer(new Coordinate(row, col - 1));
                    freshOrangesCount--;
                    flag = true;
                }
            }
            if (flag) {
                minutes++;
            }
        }
    }

}
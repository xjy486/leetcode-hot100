class Solution {
    public int m;
    public int n;
    public int count;

    class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    bfs(grid, row, col);
                    count += 1;
                }

            }
        }
        return count;
    }

    public void bfs(char[][] grid, int row, int col) {
        Deque<Coordinate> q = new LinkedList<>();
        int x, y;
        Coordinate coordinate;
        grid[row][col] = '0';
        q.offer(new Coordinate(row, col));
        while (!q.isEmpty()) {
            coordinate = q.poll();
            x = coordinate.x;
            y = coordinate.y;
            if (x + 1 < m && grid[x + 1][y] == '1') {
                grid[x + 1][y] = '0';
                q.offer(new Coordinate(x + 1, y));
            }
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = '0';
                q.offer(new Coordinate(x - 1, y));
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = '0';
                q.offer(new Coordinate(x, y - 1));
            }
            if (y + 1 < n && grid[x][y + 1] == '1') {
                grid[x][y + 1] = '0';
                q.offer(new Coordinate(x, y + 1));
            }

        }

    }

}
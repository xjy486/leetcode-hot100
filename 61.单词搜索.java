class Solution {
    boolean ans;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Start a search from (i, j) for the first letter (index 0)
                if (backTrack(board, word, i, j, 0)) {
                    return true; // Found it! No need to search further.
                }
            }
        }
        // If we've tried all starting points and found nothing
        return false;
    }

    public boolean backTrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == word.charAt(index)) {
            board[i][j] = '#';
            boolean down = backTrack(board, word, i + 1, j, index + 1);
            boolean right = backTrack(board, word, i, j + 1, index + 1);
            boolean up = backTrack(board, word, i - 1, j, index + 1);
            boolean left = backTrack(board, word, i, j - 1, index + 1);
            if (down || left || up || right)
                return true;
            // if(!down && !right && !up && !left)
            board[i][j] = word.charAt(index);

        }
        return false;
    }
}
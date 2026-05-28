class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        // Traverse entire grid
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                // If land found
                if (grid[r][c] == '1') {

                    count++;          // New island found

                    dfs(grid, r, c);  // Visit entire island
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check + water check
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark current cell as visited
        grid[r][c] = '0';

        // Visit all 4 directions
        dfs(grid, r + 1, c); // down
        dfs(grid, r - 1, c); // up
        dfs(grid, r, c + 1); // right
        dfs(grid, r, c - 1); // left
    }
}
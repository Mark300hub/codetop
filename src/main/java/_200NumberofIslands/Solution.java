package _200NumberofIslands;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-12 20:42
 **/
// 岛屿数量
public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, i, j, isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        if (i < 0 || j < 0 ||
                i >= grid.length || j >= grid[0].length
                || isVisited[i][j] || grid[i][j] == '0') {
            return;
        }
        isVisited[i][j] = true;
        dfs(grid, i - 1, j, isVisited);
        dfs(grid, i + 1, j, isVisited);
        dfs(grid, i, j - 1, isVisited);
        dfs(grid, i, j + 1, isVisited);
    }
}
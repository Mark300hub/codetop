package _200NumberofIslands;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-12 21:04
 **/
public class Solution2 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {i, j});
        while (!deque.isEmpty()) {
            int[] location = deque.pollFirst();
            int x = location[0];
            int y = location[1];
            if (x < 0 || y < 0 ||
                    x >= grid.length || y >= grid[0].length ||
                    grid[x][y] == '0') {
                continue;
            } else {
                grid[x][y] = '0';
                deque.addLast(new int[]{x - 1, y});
                deque.addLast(new int[]{x + 1, y});
                deque.addLast(new int[]{x, y - 1});
                deque.addLast(new int[]{x, y + 1});
            }
        }
    }
}
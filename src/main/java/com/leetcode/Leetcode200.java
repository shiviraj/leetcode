package com.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode200 {
    static void main() {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid1)); // 1
        System.out.println(numIslands(grid2)); // 3
    }

    public static int numIslands(char[][] grid) {
        Queue<int[]> lands = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    lands.offer(new int[]{i, j});

                    while (!lands.isEmpty()) {
                        int[] cell = lands.poll();

                        for (int[] d : directions) {
                            int row = cell[0] + d[0];
                            int col = cell[1] + d[1];
                            if ((0 <= row && row < grid.length) && (0 <= col && col < grid[0].length)) {
                                if (grid[row][col] == '1') {
                                    lands.offer(new int[]{row, col});
                                    grid[row][col] = '0';
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}



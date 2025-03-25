package algorithms.array;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 第2711题: 对角线上不同值的数值差
 * <p>
 * 给你一个大小为 n x n 的整数矩阵 grid。
 * 计算 grid 主对角线上的元素值之和与副对角线上的元素值之和的绝对差。
 * <p>
 * 主对角线是指从 (0, 0) 开始到 (n-1, n-1) 的对角线。
 * 副对角线是指从 (0, n-1) 开始到 (n-1, 0) 的对角线。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：2
 * 解释：
 * 主对角线元素和为: 1 + 5 + 9 = 15
 * 副对角线元素和为: 3 + 5 + 7 = 15
 * 差值的绝对值为: |15 - 15| = 0
 * <p>
 * 示例 2：
 * 输入：grid = [[7,3,1],[9,8,6],[3,2,4]]
 * 输出：15
 * 解释：
 * 主对角线元素和为: 7 + 8 + 4 = 19
 * 副对角线元素和为: 1 + 8 + 3 = 12
 * 差值的绝对值为: |19 - 12| = 7
 * <p>
 * 提示：
 * - n == grid.length == grid[i].length
 * - 1 <= n <= 50
 * - 1 <= grid[i][j] <= 100
 */
public class P2711_DiagonalValuesDifference {

    /**
     * 我的解决方案
     *
     * @param grid nxn 的整数矩阵
     * @return 主对角线元素和与副对角线元素和的绝对差值
     */
    public int[][] myMethod(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Set<Integer> s1 = new HashSet<>();
                int x = i + 1, y = j + 1;
                while (x < m && y < n) {
                    s1.add(grid[x][y]);
                    x += 1;
                    y += 1;
                }
                Set<Integer> s2 = new HashSet<>();
                x = i - 1;
                y = j - 1;
                while (x >= 0 && y >= 0) {
                    s2.add(grid[x][y]);
                    x -= 1;
                    y -= 1;
                }
                res[i][j] = Math.abs(s1.size() - s2.size());
            }
        }
        return res;
    }

    /**
     * 学习后的优化解决方案
     *
     * @param grid nxn 的整数矩阵
     * @return 主对角线元素和与副对角线元素和的绝对差值
     */
    public int[][] learnedMethod(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; ++i) {
            int x = i, y = 0;
            Set<Integer> s = new HashSet<>();
            while (x < m && y < n) {
                res[x][y] += s.size();
                s.add(grid[x][y]);
                x += 1;
                y += 1;
            }
        }

        for (int j = 1; j < n; ++j) {
            int x = 0, y = j;
            Set<Integer> s = new HashSet<>();
            while (x < m && y < n) {
                res[x][y] += s.size();
                s.add(grid[x][y]);
                x += 1;
                y += 1;
            }
        }

        for (int i = 0; i < m; ++i) {
            int x = i, y = n - 1;
            Set<Integer> s = new HashSet<>();
            while (x >= 0 && y >= 0) {
                res[x][y] -= s.size();
                res[x][y] = Math.abs(res[x][y]);
                s.add(grid[x][y]);
                x -= 1;
                y -= 1;
            }
        }

        for (int j = n - 2; j >= 0; --j) {
            int x = m - 1, y = j;
            Set<Integer> s = new HashSet<>();
            while (x >= 0 && y >= 0) {
                res[x][y] -= s.size();
                res[x][y] = Math.abs(res[x][y]);
                s.add(grid[x][y]);
                x -= 1;
                y -= 1;
            }
        }

        return res;
    }


    // 测试
    public static void main(String[] args) {
        P2711_DiagonalValuesDifference solution = new P2711_DiagonalValuesDifference();

        // 测试用例1
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("测试用例1 (我的方法): " + solution.myMethod(grid1));
        System.out.println("测试用例1 (学习方法): " + solution.learnedMethod(grid1));

        // 测试用例2
        int[][] grid2 = {{7, 3, 1}, {9, 8, 6}, {3, 2, 4}};
        System.out.println("测试用例2 (我的方法): " + solution.myMethod(grid2));
        System.out.println("测试用例2 (学习方法): " + solution.learnedMethod(grid2));
    }
}

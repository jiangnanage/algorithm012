/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * dp方程式：dp[i][j] = Min(dp[i-1][j],dp[i][j-1])+grid[i][j]
 *
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid){
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int a = 1; a < m; a++){
            dp[0][a] = dp[0][a - 1] + grid[0][a];
        }
        for (int b = 1; b < n; b++){
            dp[b][0] = dp[b-1][0] + grid[b][0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}

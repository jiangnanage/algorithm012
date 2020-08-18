/**
 * 221. 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * dp方程式 dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
 */
public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix){
        int maxSide = 0;
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]) + 1;
                    maxSide = maxSide < dp[i][j] ? dp[i][j] : maxSide;
                }
            }
        }
        return maxSide * maxSide;
    }
}

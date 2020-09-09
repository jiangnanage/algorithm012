/**
 * 70. 爬楼梯
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 */
public class ClimbStairs {
    /**
     * 动态规划 dp[n] = dp[n-1] + dp[n-2]
     * @param n
     * @return
     */
    public int climbStairs2(int n){
        if (n == 0)
            return 0;
        int pre = 0, curr = 1;
        for (int i = 1; i <= n; i++){
            int temp = pre;
            pre = curr;
            curr  += temp;
        }
        return curr;
    }
}

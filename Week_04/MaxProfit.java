/**
 * 122. 买卖股票的最佳时机 II
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 *
 * 时间复杂度O(n) 空间复杂度O(1)
 */
public class MaxProfit {
    public int maxProfit(int[] prices){
        int sum = 0;
        if (prices == null || prices.length < 2)
            return 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1])
                sum += prices[i]-prices[i-1];
        }
        return sum;
    }
}

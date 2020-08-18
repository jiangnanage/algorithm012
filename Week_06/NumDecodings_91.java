/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class NumDecodings_91 {
    public int numDecoding(String s){
        int len = s.length();
        char[] arr = s.toCharArray();
        if (arr[0] == '0')
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < len; i++){
            if (arr[i] != '0')
                dp[i+1] = dp[i];
            int num = (arr[i-1] - '0') * 10 + (arr[i] - '0');
            if (num <= 26 && num >= 10)
                dp[i+1] += dp[i-1];
        }
        return dp[len];
    }
}

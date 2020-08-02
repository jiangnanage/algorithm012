import java.util.Arrays;

/**
 * 455. 分发饼干
 * 示例 1:
 *
 * 输入: [1,2,3], [1,1]
 *
 * 输出: 1
 */
public class FindContentChildren {
    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length){
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}

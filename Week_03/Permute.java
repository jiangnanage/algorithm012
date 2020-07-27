import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums){
        if (nums == null)
            return null;
        int[] visited = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<Integer>(),nums,visited);
        return result;
    }
    public static void backtrack(List<List<Integer>> result,ArrayList<Integer> tmpArr,int[] nums,int[] visited){
        if (tmpArr.size() == nums.length) {
            result.add(new ArrayList<>(tmpArr));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 1)
                continue;
            tmpArr.add(nums[i]);
            visited[i] = 1;
            backtrack(result,tmpArr,nums,visited);
            visited[i] = 0;
            tmpArr.remove(tmpArr.size()-1);
        }
    }
}

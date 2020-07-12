import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 */
public class MoveZeroes {
    public static void moveZeroes(int nums[]){
        int j = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                if(j != i)
                    nums[i] = 0;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

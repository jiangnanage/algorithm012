/**
 * 860. 柠檬水找零
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 时间复杂度 O(n) 空间复杂度O(1)
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills){
        int five = 0,ten = 0;
        for (int bill : bills){
            if (bill == 5)
                ++five;
            else if (bill == 10){
                if (five > 0){
                    --five;
                    ++ten;
                }else
                    return false;
            }else{
                if (ten > 0 && five > 0){
                    --ten;
                    --five;
                }else if (five >=3)
                    five -= 3;
                else
                    return  false;
            }
        }
        return  true;
    }
}

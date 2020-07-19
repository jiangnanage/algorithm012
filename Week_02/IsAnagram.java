import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  242. 有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 */
public class IsAnagram {

    /**
     * 使用排序比较
     * 时间复杂度 O(nlogn) 空间复杂度 O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s,String t){
        if (s.length() != t.length())
            return false;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }

    /**
     * 使用哈希表
     * 时间复杂度O(n)空间复杂度O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s,String t){
        int[] arr = new int[26];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int j = 0; j < arr.length; j++){
            if(arr[j] != 0)
                return false;
        }
        return true;
    }
}

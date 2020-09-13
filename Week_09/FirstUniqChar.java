import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] chars = new int[256];
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)]=chars[s.charAt(i)]+1;
        }

        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 时间复杂度 O(NKlogK)
 * 空间复杂度 O(NK)
 *
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(! map.containsKey(key))
                map.put(key , new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}

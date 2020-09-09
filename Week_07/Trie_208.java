import java.util.HashSet;
import java.util.Set;

/**
 * 208. 实现 Trie (前缀树)
 */


class TrieNode{
   TrieNode[] children;
   public TrieNode(){
      children = new TrieNode[26];
      for (TrieNode child : children){
         child = null;
      }
   }
}
public class Trie_208 {
   TrieNode root;
   Set<String> set;
   public Trie_208(){
      root = new TrieNode();
      set = new HashSet<String>();
   }
   public void insert(String word){
      if (word == null || word.length() == 0)
         return;
      TrieNode pre = root;
      char[] arr = word.toCharArray();
      for (char ch : arr){
         if (pre.children[ch - 'a'] == null)
            pre.children[ch - 'a'] = new TrieNode();
         pre = pre.children[ch - 'a'];
      }
      set.add(word);
   }
   public boolean search(String word){
      return set.contains(word);
   }
   public boolean startsWith(String prefix){
      if (prefix == null || prefix.length() == 0)
         return false;
      TrieNode pre = root;
      char[] arr = prefix.toCharArray();
      for (char ch : arr){
         if (pre.children[ch - 'a'] == null)
            return false;
         pre = pre.children[ch - 'a'];
      }
      return true;
   }
}

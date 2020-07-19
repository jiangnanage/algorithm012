import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 *递归 时间复杂度O(n) 空间复杂度O(n)
 */
public class Preorder {
    public List<Integer> preorder(Node root){
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        list.add(root.val);
        for(Node child : root.children){
            list.addAll(preorder(child));
        }
        return list;
    }
}

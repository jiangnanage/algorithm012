import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {
    /**
     * BFS
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * DFS
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        levelOrder1(0,root,result);
        return result;
    }

    public static void levelOrder1(int level,TreeNode root,List<List<Integer>> result){
        List<Integer> list = new ArrayList<>();
        if (result.size()-1 < level)
            result.add(list);
        result.get(level).add(root.val);
        if (root.left != null) {
            levelOrder1(level + 1, root.left, result);
        }
        if(root.right != null)
            levelOrder1(level + 1,root.right,result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root2.left = root3;
        root2.right = root4;
        root.left = root1;
        root.right = root2;
        levelOrder1(root);
    }
}

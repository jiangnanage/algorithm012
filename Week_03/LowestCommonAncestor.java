/**
 * 236. 二叉树的最近公共祖先
 * 面试题68 - II. 二叉树的最近公共祖先
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 时间复杂度 O(n) 空间复杂度 O(n)
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}

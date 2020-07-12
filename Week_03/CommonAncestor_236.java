

import com.leetcode.bean.TreeNode;

/**
 * 最近公共祖先
 *
 * @author ANT
 * @date 2020/7/8 11:44
 */
public class CommonAncestor_236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        // drill down
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null && left != q && left != p) {
            return left;
        }

        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

}

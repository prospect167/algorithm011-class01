import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author ANT
 * @date 2020/7/1 19:37
 */
public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(10);
        inOrderIterator(root, result);
        return result;
    }

    private void inOrderIterator(TreeNode root, List<Integer> result) {
        if (null == root) return;
        if (root.left != null) inOrderIterator(root.left, result);
        result.add(root.val);
        if (root.right != null) inOrderIterator(root.right, result);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
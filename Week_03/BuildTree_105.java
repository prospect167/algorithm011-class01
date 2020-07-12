import com.leetcode.bean.TreeNode;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author ANT
 * @date 2020/7/9 15:25
 */
public class BuildTree_105 {

    /**
     * 前序遍历  根 - 左 - 右
     * 中序遍历  左 - 根 - 右
     *
     * 找到根节点，并递归生成其左右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int size = preorder.length;
        HashMap<Integer, Integer> cache = new HashMap<>(size * 2);
        for (int i = 0; i < size; i++) {
            cache.put(inorder[i], i);
        }
        return _buildTree(preorder, inorder, cache, 0, size-1, 0, size-1);
    }


    private TreeNode _buildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> map,
                                int p_left, int p_right, int i_left, int i_right) {

        // terminator
        if (p_left > p_right) {
            return null;
        }

        // process 找到根节点(前序遍历的第一个节点就是根节点，而中序遍历的跟根节点左边是左子树，右边是右子树）
        int root = p_left;

        //  比中序遍历根节点小的为左子树，比其大的为左子树
        int i_root = map.get(preorder[root]);
        TreeNode rootNode = new TreeNode(preorder[root]);
        // 左子树节点数
        int left_b = i_root - i_left;

        // drill down
        rootNode.left = _buildTree(preorder, inorder, map, p_left+1, p_left+left_b, i_left, i_root-1);
        rootNode.right = _buildTree(preorder, inorder,map, p_left+left_b+1,p_right, i_root+1, i_right);
        //restore

        return rootNode;
    }


}

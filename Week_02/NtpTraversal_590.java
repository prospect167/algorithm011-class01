
import java.util.ArrayList;
import java.util.List;

/**
 * N叉树后序遍历
 * @author ANT
 * @date 2020/7/1 19:45
 */
public class NtpTraversal_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        _postorder(root, result);
        return result;
    }

    private void _postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            _postorder(node, result);
        }
        result.add(root.val);
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

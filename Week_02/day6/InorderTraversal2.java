import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树 中序遍历 第二遍
 */
public class InorderTraversal2 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) return list;
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            TreeNode node = deque.pop();
            list.add(node.val);
            cur = cur.right;
        }
        return list;
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/24 0024 15:30
 * 二叉树的中序遍历
 */
public class InorderTraversal3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return doInorderTraversal(list,root);
    }

    public List<Integer> doInorderTraversal(List<Integer> list,TreeNode node) {
        if (node == null) return list;
        doInorderTraversal(list,node.left);
        list.add(node.val);
        doInorderTraversal(list,node.right);
        return list;
    }
}

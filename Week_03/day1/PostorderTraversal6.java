import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 14:15
 */
public class PostorderTraversal6 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pop();
            res.addFirst(cur.val);
            if (cur.left != null) deque.push(cur.left);
            if (cur.right != null) deque.push(cur.right);
        }
        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        dfs(res,root.left);
        dfs(res,root.right);
        res.add(root.val);
    }

}

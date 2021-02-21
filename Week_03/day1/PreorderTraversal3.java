import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 11:14
 */
public class PreorderTraversal3 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pop();
            res.add(cur.val);
            if (cur.right != null) deque.push(cur.right);
            if (cur.left != null) deque.push(cur.left);
        }
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        dfs(res,root.left);
        dfs(res,root.right);
    }

}

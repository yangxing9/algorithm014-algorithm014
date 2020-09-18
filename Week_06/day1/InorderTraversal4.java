import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/14 0014 09:43
 */
public class InorderTraversal4 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return doInorderTraversal4(res,root);
    }

    private List<Integer> doInorderTraversal4(List<Integer> res, TreeNode node) {
        if (node == null){
            return res;
        }
        doInorderTraversal4(res,node.left);
        res.add(node.val);
        doInorderTraversal4(res,node.right);
        return res;
    }

}

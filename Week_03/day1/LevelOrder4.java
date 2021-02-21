import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 15:22
 */
public class LevelOrder4 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                list.add(cur.val);
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }

}

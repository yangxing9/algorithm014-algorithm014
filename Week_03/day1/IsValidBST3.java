import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 14:34
 */
public class IsValidBST3 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode cur = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        long preVal = Long.MIN_VALUE;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            if (cur.val <= preVal) return false;
            preVal = cur.val;
            cur = cur.right;
        }
        return true;
    }

}

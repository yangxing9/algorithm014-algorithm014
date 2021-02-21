import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 14:53
 */
public class MinDiffInBST {

    public static void main(String[] args) {
        MinDiffInBST minDiffInBST = new MinDiffInBST();
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        minDiffInBST.minDiffInBST(a);
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        Integer preVal = null;
        int res = Integer.MAX_VALUE;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            if (preVal == null){
                preVal = cur.val;
            }else {
                res = Math.min(res,cur.val - preVal);
            }
            preVal = cur.val;
            cur = cur.right;
        }
        return res;
    }

}

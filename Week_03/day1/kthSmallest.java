import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 14:47
 *
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class kthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        int count = 0;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            count ++;
            if (count == k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }

}

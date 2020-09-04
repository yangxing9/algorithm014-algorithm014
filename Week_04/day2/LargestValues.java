import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/1 0001 13:59
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long curLevelMax = -Long.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                curLevelMax = Math.max(curLevelMax,cur.val);
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
            result.add((int)curLevelMax);
        }
        return result;
    }

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        return doLargestValues(root,result,0);
    }

    private List<Integer> doLargestValues(TreeNode root, List<Integer> result, int index) {
        if (root == null) return result;
        if (index >= result.size()) {
            result.add(root.val);
        }else {
            int curLevelMax = Math.max(result.get(index),root.val);
            result.set(index,curLevelMax);
        }
        doLargestValues(root.left,result,index + 1);
        doLargestValues(root.right,result,index + 1);
        return result;
    }
}

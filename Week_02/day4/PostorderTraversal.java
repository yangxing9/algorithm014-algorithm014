import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/21 0021 16:25
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return doPostorderTraversal(list,root);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return list;
        }
        deque.addFirst(root);
        while (!deque.isEmpty()){
            TreeNode cur = deque.pollFirst();
            list.addFirst(cur.val);
            if (cur.left != null){
                deque.addFirst(cur.left);
            }
            if (cur.right != null){
                deque.addFirst(cur.right);
            }
        }
        return list;
    }

    /**
     * 后续遍历 左 -> 右 -> 根
     * @param list
     * @param node
     * @return
     */
    private List<Integer> doPostorderTraversal(List<Integer> list,TreeNode node) {
        if (node == null) return list;
        doPostorderTraversal(list,node.left);
        doPostorderTraversal(list,node.right);
        list.add(node.val);
        return list;
    }


}

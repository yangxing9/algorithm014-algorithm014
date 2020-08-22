import java.util.*;
import java.util.stream.Collectors;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000
 */
public class LevelOrder {

    /**
     * N叉树层序遍历
     * 广度优先，使用队列实现，深度优先则用栈实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque();
        if (root == null) return result;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                Node cur = deque.pollFirst();
                list.add(cur.val);
                deque.addAll(cur.children);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 二叉树层序遍历
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque();
        deque.addLast(root);
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList();
            int size = deque.size();
            for(int i = 0;i < size;i++){
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            result.add(list);
        }
        return result;
    }
}

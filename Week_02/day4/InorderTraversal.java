import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/20 0020 17:54、
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return doInorderTraversal(list,root);
    }

    /**
     * 循环写法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            list.add(cur.val);
            //为了解决 右节点的遍历，当cur为左节点时，无意义，跳过
            // 当cur为中节点时，发挥作用
            cur = cur.right;
        }
        return list;
    }

    /**
     * 递归写法 中序遍历 左 -> 根 -> 右
     * @param list
     * @param node
     * @return
     */
    public static List<Integer> doInorderTraversal(List<Integer> list,TreeNode node){
        if (node == null){
            return list;
        }
        doInorderTraversal(list,node.left);
        list.add(node.val);
        doInorderTraversal(list,node.right);
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/21 0021 16:00
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 通过次数154,288提交次数231,835
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 递归写法 根 -> 左 -> 右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return doPreorderTraversal(list,root);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque();
        List<Integer> list = new ArrayList<>();
        // 注意入参的判断，若root为null的操作
        if(root == null) return list;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            // 先拿到栈第一个元素，即根节点
            TreeNode cur = deque.pollFirst();
            list.add(cur.val);
            // 将根节点的右节点 压入栈，注意栈的特性，先进后出，所以先让右节点入栈
            if (cur.right != null) deque.addFirst(cur.right);
            // 将根节点的左节点 压入栈
            if (cur.left != null) deque.addFirst(cur.left);
        }
        return list;
    }

    private List<Integer> doPreorderTraversal(List<Integer> list ,TreeNode node){
        if (node == null) return list;
        list.add(node.val);
        doPreorderTraversal(list,node.left);
        doPreorderTraversal(list,node.right);
        return list;
    }

}

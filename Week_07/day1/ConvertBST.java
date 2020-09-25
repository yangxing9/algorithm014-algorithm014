import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/21 0021 09:52
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBST {

   int sum = 0;

    /**
     * 思路要点：注意给的是二叉搜索树，如果给定的树是二叉搜索树，那么一定要从二叉搜索树的特征去思考
     *         1. 若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     *         2. 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     *         3. 它的左、右子树也分别为二叉搜索树。
     *      二叉搜索树的中序遍历是一个单调递增的有序序列 (重点！！)
     *
     *      每个节点都要加上比自己大的节点，那么可以从最大的开始遍历，累加遍历的结果，赋值给当前节点即可，也就是倒着中序遍历
     *  @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
       if (root == null) return root;
       convertBST(root.right);
       sum += root.val;
       root.val = sum;
       convertBST(root.left);
       return root;
    }


    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (!deque.isEmpty() || cur != null){
            while (cur != null){
                deque.push(cur);
                cur = cur.right;
            }
            cur = deque.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }

}

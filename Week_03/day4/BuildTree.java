import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/27 0027 15:46
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inorderCache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderCache.put(inorder[i],i);
        }
        return doBuildTree(preorder,0,preorder.length,0,inorder.length,inorderCache);
    }

    private TreeNode doBuildTree(int[] preorder, int left,int left_end,int right, int right_end, Map<Integer,Integer> inorderCache) {
        if (left == left_end) return null;
        TreeNode root = new TreeNode(preorder[left]);
        int x = inorderCache.get(root.val);
        int leftNum = x - right;
        root.left = doBuildTree(preorder,left + 1,left + leftNum + 1,right,x,inorderCache);
        root.right = doBuildTree(preorder,left + leftNum + 1,left_end,x + 1,right_end,inorderCache);
        return root;
    }

}

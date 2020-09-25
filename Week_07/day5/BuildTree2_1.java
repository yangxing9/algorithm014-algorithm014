import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/25 0025 11:38
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree2_1 {

    public static void main(String[] args) {
        TreeNode node = new BuildTree2_1().buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(postorder,postorder.length - 1,0,0,inorder.length - 1,map);
    }

    /**
     *
     * @param  [ postEnd ]
     * @param  [ inLeft ]
     */
    private TreeNode build(int[] postorder, int postLeft, int postEnd, int inLeft, int inEnd, Map<Integer, Integer> map) {
        if (postLeft < postEnd) return null;
        TreeNode root = new TreeNode(postorder[postLeft]);
        int rootIndex = map.get(root.val);
        int rightNum = inEnd - rootIndex;
        root.right = build(postorder,postLeft - 1,postLeft - rightNum,rootIndex + 1,inEnd,map);
        root.left = build(postorder,postLeft - rightNum - 1,postEnd,inLeft,rootIndex - 1,map);
        return root;
    }

}

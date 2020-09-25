import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/25 0025 11:29
 *  * 105. 从前序与中序遍历序列构造二叉树
 *  * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *  *
 *  * 注意:
 *  * 你可以假设树中没有重复的元素。
 *  *
 *  * 例如，给出
 *  *
 *  * 前序遍历 preorder = [3,9,20,15,7]
 *  * 中序遍历 inorder = [9,3,15,20,7]
 *  * 返回如下的二叉树：
 *  *
 *  *     3
 *  *    / \
 *  *   9  20
 *  *     /  \
 *  *    15   7
 *
 */
public class BuildTree1_2 {

    public static void main(String[] args) {
        TreeNode node = new BuildTree1_2().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length - 1,0,inorder.length - 1,map);
    }

    private TreeNode build(int[] preorder, int preLeft, int preEnd, int inLeft, int inEnd, Map<Integer, Integer> map) {
        if (preLeft > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = map.get(root.val);
        int leftNum = rootIndex - inLeft;
        root.left = build(preorder,preLeft + 1,preLeft + leftNum,inLeft,rootIndex - 1,map);
        root.right = build(preorder,preLeft + 1 + leftNum,preEnd,rootIndex + 1,inEnd,map);
        return root;
    }

}

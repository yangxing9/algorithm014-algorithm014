import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/17 0017 10:40
 * 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class IncreasingBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(new IncreasingBST().increasingBST2(root));
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root,list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
        return list.get(0);
    }

    private void dfs(TreeNode root,List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }

    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode dummy = new TreeNode(-1);
        TreeNode res = dummy;
        while (!deque.isEmpty() || cur != null){
            while (cur != null){
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.poll();
            res.right = cur;
            res.left = null;
            res = res.right;
            cur = cur.right;
        }
        return dummy.right;
    }

}

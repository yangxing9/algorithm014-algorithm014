import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/24 0024 14:55
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println(Arrays.toString(new FindMode().findMode(a)));
    }

    int pre = 0;
    int maxCount = 1;
    int count = 0;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        return list.stream().mapToInt(a -> a).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (root.val == pre){
            count++;
        }else{
            count = 1;
            pre = root.val;
        }
        if (count == maxCount){
            list.add(root.val);
        }else if(count > maxCount){
            list.clear();
            list.add(root.val);
            maxCount = count;
        }
        dfs(root.right);
    }

}

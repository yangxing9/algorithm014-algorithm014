import java.util.*;
import java.util.zip.CRC32;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/26 0026 17:15
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        Codec codec = new Codec();
        String ser = codec.serialize(root);
        TreeNode result = codec.deserialize(ser);
        System.out.println();
    }

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        return preOrder(root,sb).toString();
    }

    private StringBuilder preOrder(TreeNode node,StringBuilder sb){
        if (node == null){
            sb.append("#,");
            return sb;
        }
        sb.append(node.val + ",");
        preOrder(node.left,sb);
        preOrder(node.right,sb);
        return sb;
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strings = data.split(",");
        Queue<TreeNode> nodes = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            String tmp = strings[i];
            if (tmp.equals("#")){
                nodes.offer(null);
            }else {
                nodes.offer(new TreeNode(Integer.parseInt(tmp)));
            }
        }
        return doDeserialize(nodes);
    }

    private TreeNode doDeserialize(Queue<TreeNode> nodes){
        if (nodes.isEmpty()) return null;
        TreeNode root = nodes.poll();
        if (root == null) return root;
        root.left = doDeserialize(nodes);
        root.right = doDeserialize(nodes);
        return root;
    }
}

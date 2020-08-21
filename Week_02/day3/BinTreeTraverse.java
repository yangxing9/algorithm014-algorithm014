import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/19 0019 17:33
 */
public class BinTreeTraverse {

    public static void main(String[] args) {
        List<ListNode> list = creatTree(new int[]{1, 2, 3, 4, 5, 6});
        list.stream().forEach(a -> System.out.print(a.val + " "));
//        System.out.println();
//        System.out.print("前序遍历：");
//        preOrderTraverse(list.get(0));
        System.out.println();
        System.out.print("中序遍历：");
        inOrderTraverse(list.get(0));
        System.out.println();
//        System.out.print("后序遍历：");
//        postOrderTraverse(list.get(0));
//        System.out.println();
        List < Integer > res = new ArrayList< >();
        Stack< ListNode > stack = new Stack < > ();
        ListNode curr = list.get(0);
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        res.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    public static List<ListNode> creatTree(int[] arr){
        List<ListNode> nodeList = new LinkedList<ListNode>();
        for (int i = 0; i < arr.length; i++) {
            nodeList.add(new ListNode(arr[i]));
        }
        for (int i = 0; i < arr.length / 2 - 1; i++) {
            nodeList.get(i).left = nodeList.get(i * 2 + 1);
            nodeList.get(i).right = nodeList.get(i * 2 + 2);
        }
        int lastIndex = arr.length / 2 - 1;
        nodeList.get(lastIndex).left = nodeList.get(lastIndex * 2 + 1);
        if (arr.length % 2 == 1){
            nodeList.get(lastIndex).right = nodeList.get(lastIndex * 2 + 2);
        }
        return nodeList;
    }

    /**
     * 前序遍历： 根 -> 左 -> 右
     * @param node
     */
    public static void preOrderTraverse(ListNode node){
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历： 左 -> 根 -> 右
     * @param node
     */
    public static void inOrderTraverse(ListNode node){
        if (node == null) return;
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历： 左 -> 右 -> 根
     * @param node
     */
    public static void postOrderTraverse(ListNode node){
        if (node == null) return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + " ");
    }

}

class ListNode{
    ListNode left;
    ListNode right;
    int val;
    ListNode(int val){
        this.val = val;
    }
}
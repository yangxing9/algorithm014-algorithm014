import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/15 0015 15:55
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 */
public class Connect2 {

    public Node1 connect(Node1 root) {
        Deque<Node1> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            Node1 last = null;
            for (int i = 0; i < size; i++) {
                Node1 cur = deque.poll();
                if (cur.right != null) deque.offer(cur.right);
                if (cur.left != null) deque.offer(cur.left);
                cur.next = last;
                last = cur;
            }
        }
        return root;
    }

    public Node1 connect2(Node1 root) {
        if (root == null) return root;
        Node1 dummy = new Node1(-1);
        Node1 cur = root;
        while (cur != null){
            dummy.next = null;
            Node1 pre = dummy;
            while (cur != null){
                if (cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

    public Node1 connect3(Node1 root) {
        if (root == null) return root;
        Node1 cur = root;
        Node1 pre = new Node1(-1);
        while (cur != null){
            if (cur.left != null){
                pre.next = cur.left;
                pre = pre.next;
            }
            if (cur.right != null){
                pre.next = cur.right;
                pre = pre.next;
            }
            cur = cur.next;
        }
        connect3(root.left);
        return root;
    }

    public static void main(String[] args) {
        Node1 a = new Node1(1);
        Node1 b = new Node1(2);
        Node1 c = new Node1(3);
        Node1 d = new Node1(4);
        Node1 e = new Node1(5);
        Node1 f = new Node1(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        Node1 res = new Connect2().connect3(a);
        System.out.println();
    }
}

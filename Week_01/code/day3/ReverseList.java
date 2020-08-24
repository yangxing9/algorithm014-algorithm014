package day3;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/12 0012 13:40
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode result = reverseList(a);
        System.out.println(result);
    }

    /**
     * 反转链表 -- 递归写法
     * 时间复杂度：O（n）
     * 空间复杂度：O（n），由于使用递归，会使用隐式栈空间
     *
     * 分析：递归的方式，就是到达最后，然后反转
     *      关键点在于怎么将后一个元素指向自己，自己的下一个再指向前一个
     */
    public static ListNode reverseList(ListNode head) {
        // 递归结束，开始反转
        if (head == null || head.next == null) {
            return head;
        }
        // 不需要关心返回值怎么用，这里递归只是为了到达最后，然后反转
        ListNode p = reverseList(head.next);
        // 最后一个元素直接return后，此时 head 为倒数第二个元素
        // 核心在这，head.next.next 意思就是 倒数第二个元素的 下一个元素head.next（即最后一个元素） 要开始反转了，
        // 怎么反转呢？就是让他的下一个为当前元素,即 head.next.next = head
        head.next.next = head;
        // 注意，这个也很关键，因为当前元素等会要把他的下个元素指向前一个元素（在上一层递归完成），按理说不将其置为null，等会也会改变当前元素的next,
        // 那么为什么还要将其置为null呢？因为我们的头结点 最后要变成 尾结点，尾结点的next为null，所以干脆直接全部先置为null，非第一个元素还会再改变,
        // 如果这里不写，注释掉，那么最终会形成 4 -> 3 -> 2 -> 1 -> 2 -> 3 -> 4 的环，就是因为没有将 1 的next置为null导致的
        head.next = null;
        return p;
    }

    /**
     * 循环写法
     * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) return head;
        // 引入新节点，表示前一个节点的值，方便当前节点指向前一个节点，定义为null，是因为首元素的前置节点为null
        ListNode node = null;
        while(head != null){
            // 保存当前节点的下一个节点信息，因为下面会将当前节点的指针改掉，不保存就无法找到链表的链了，无法迭代下去
            ListNode tmp = head.next;
            // 当前节点指向前一个节点
            head.next = node;
            // 前一个节点状态改为当前节点
            node = head;
            // 继续迭代，将当前节点改为上面保存的下一个节点，因为node保存了反转后的节点，所以不用担心重置head会丢失元素链
            head = tmp;
        }
        // 返回node
        return node;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
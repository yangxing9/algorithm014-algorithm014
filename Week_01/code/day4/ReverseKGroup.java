package day4;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/13 0013 19:38
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        ListNode result = reverseKGroup(a,3);
        System.out.println(result);
    }

    /**
     * 整体思路：循环来做的话，和两两反转链表一样，需要一个前置的节点用来将每k个数组相连
     *          定义一个首，循环k次得到一个尾，将这k个元素，使用反转链表实现反转，再讲反转后的链表与剩余的接上
     *          首尾重置下一波循环
     *          如k次循环后，尾为null，代表剩余元素不足以满足k个元素，此时结束循环，
     *
     *   时间复杂度为 O(n + k) 最好的情况为 O(n) 最差的情况未 O(n * 2)
     *   空间复杂度为 O（1）
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 定义一个假节点，用来最后找到反转后链表的头
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义前置节点，和反转链表一样，作用就是用来接上反转后的链表的头
        ListNode pre = dummy;
        // 因为k个一组，所以需要找到k个元素的尾部，初始化和前置结点一致，因为要循环k次
        ListNode end = dummy;

        // end.next ！= null代表了刚好k的倍数的情况，end的下一个元素为null，则代表已经遍历完了
        while (end.next != null) {
            // 循环k次，得到k个元素的尾部，注意这里 end 不能为null，如果为null，则代表不足k个元素
            for (int i = 0; i < k && end != null; i++) end = end.next;
            // 此时说明总元素不是k的整数倍，最后的元素不足k个，即可以结束了
            if (end == null) break;
            // start表示 k 个元素的开头元素
            ListNode start = pre.next;
            // next表示下一波k个元素的第一个，记录下来为了等会将反转后的k个元素跟后面连起来
            ListNode next = end.next;
            // 注意点，这里要将end的末尾置为null，因为反转k个元素，要有结束
            end.next = null;
            // 反转后的返回值为反转之前的最后一个元素，也是反转后的第一个元素，也就是下一个k个元素的前置节点，注意这里会将前置节点与翻转好了的k个元素接上
            pre.next = reverse(start);
            // 这里是将反转好了的元素与未反转的接上，与上面是不一样的，相当于翻转好了的元素的头和尾都要再接上
            // 举个例子 1234567的链表，k为3，定义的前置节点为0，那么 123反转后就要 将0 指向 321 再将1指向 4567 的4
            // 下一轮的话就是 0321 中的 1 指向 654 的 6，654中的4指向下一个k个元素的第一个，也就是7
            start.next = next;

            // 移动pre 和end 的位置，此时位置应该是反转之前的第一个元素，反转后就变成k个元素的最后一个了，也就是下一轮的前一个元素
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}

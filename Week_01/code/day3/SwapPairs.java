package day3;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/12 0012 16:29
 *
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

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
        ListNode result = swapPairs(a);
        System.out.println(result.val);
    }


    /**
     * 递归写法：思路，因为要反转连续两个元素，所以递归传入下一次肯定是 当前元素的下一个的下一个，
     * 然后搞明白最后return的值是什么，反转下元素就行了
     * 时间复杂度：O(N)，其中 N 指的是链表的节点数量。
     * 空间复杂度：O(N)，递归过程使用的堆栈空间。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            // 这里需要return 原值，当奇数时，head为最后一个元素，偶数时，head为null
            return head;
        }
        ListNode second = head.next;
        ListNode node = swapPairs(second.next);
        // 后一个元素 的 下一个置为当前元素
        second.next = head;
        // 当前元素的下一个 置为最后一个return的元素，当偶数时，就是null，当奇数时，就是最后一个元素
        head.next = node;
        // 下一次递归时，需要的值为当前层的 第一个值，也就是反转后的第一个元素（即原本的第二个元素，反转后就变成第一个了）
        return second;
    }

    /**
     * 循环解法：思路，因为从头开始，前面两个交换很容易，交换后的后一个元素指向就成问题了，因为后面可能还有交换，这个指向是不定的
     * 所以需要一个前置节点来处理这个问题，也就是 3个元素一组，去处理，首元素前面是没有值的，就需要先额外申请一个节点，最后再去掉
     * 还有一个注意点就是，要记录下来开头节点信息，不然最后返回找不到首元素了。。。
     *
     * 时间复杂度：O(N)，其中 N 指的是链表的节点数量。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        // 构造首元素，值随便写，不重要
        ListNode dummy = new ListNode(-1);
        // 放在首位
        dummy.next = head;
        // 重新指向一个变量，原来的变量用来最后定位首元素，返回结果用
        ListNode pre = dummy;
        // 注意是 且 的关系，不要写错了
        while (head != null && head.next != null){
            // 先取出第一个，第二个元素，加上我们定义的 pre前置节点，就构成3个元素一组来处理了
            ListNode first = head;
            ListNode second = head.next;

            // 前置节点的下一个指向3个元素的最后一个
            pre.next = second;
            // 首元素 指向 下一个 3元素组的第一个元素，注意：此处可能会想到，下次循环还要重新指向别的元素，是不是可以省略
            // 其实这个和反转链表那一题是一个套路，省略是可以省略，就是最后会形成环，也就是这一行代码就是为了结尾用的
            first.next = second.next;
            // 第二个元素指向第一个元素，即反转，注意顺序别写反了，因为first元素的下一个要指向second的下一个，这一行放上面了，就成环了
            second.next = first;

            // 前置节点需要移动，注意要移动到哪，这里前置即为下一个元素组的前面一个，也就是本3元素组的末尾一个，也就是现在的first（因为first已经跳到后面了）
            pre = first;
            // 同理，head向前移动，也是当前元素组的下一个，
            head = first.next;
        }
        // 返回之前保留指针的next
        return dummy.next;
    }

}

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/23 0023 17:14
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome3 {

    public static void main(String[] args) {
        IsPalindrome3 p = new IsPalindrome3();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(p.isPalindrome(a));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // 找到前半部分链表的尾节点
        ListNode halfEnd = endOfFirstHalf(head);

        ListNode firstHalfEnd = head;
        // 并反转后半部分链表
        ListNode second = reverse(halfEnd.next);
        boolean flag = true;
        while (flag && second != null){
            if (firstHalfEnd.val != second.val) flag = false;
            firstHalfEnd = firstHalfEnd.next;
            second = second.next;
        }
        // 还原链表并返回结果
        halfEnd.next = reverse(second);
        return flag;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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

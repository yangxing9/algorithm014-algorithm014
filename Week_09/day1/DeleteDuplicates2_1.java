/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/12 0012 17:29
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class DeleteDuplicates2_1 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        System.out.println(new DeleteDuplicates2_1().deleteDuplicates(a));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode last = null;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            ListNode tmp = cur.next;
            if (cur.val != cur.next.val){
                if (last == null || cur.val != last.val){
                    cur.next = null;
                    pre.next = cur;
                    pre = pre.next;
                }
            }
            last = cur;
            cur = tmp;
        }
        if (cur != null && cur.val != last.val) pre.next = cur;
        return dummy.next;
    }

}

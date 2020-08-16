package day5;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/14 0014 21:53
 *
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
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

        d.next = e;
        e.next = f;
        f.next = g;
        ListNode result = mergeTwoLists2(a,d);
        System.out.println(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                first.next = l1;
                l1 = l1.next;
            }else {
                first.next = l2;
                l2 = l2.next;
            }
            first = first.next;
        }
        first.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/20 0020 17:41
 */
public class AddTwoNumbers4 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int remained = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null){
            int p = l1 == null ? 0 : l1.val;
            int q = l2 == null ? 0 : l2.val;
            int sum = p + q + remained;
            remained = sum / 10;
            int target = sum % 10;
            cur.next = new ListNode(target);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (remained > 0){
            cur.next = new ListNode(remained);
        }
        return dummy.next;
    }

}

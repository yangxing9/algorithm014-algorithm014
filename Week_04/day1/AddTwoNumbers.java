/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/31 0031 15:21
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers3 demo = new AddTwoNumbers3();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next = l3;
        demo.addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        // 自己的思路用一个boolean变量表示是否需要进一，实际上直接用余数表示更直接
        int remainder = 0;
        // 用或的关系，当一个为null，另一个还要继续处理
        while (l1 != null || l2 != null) {
            // 如果为null了，就用0表示
            int p = l1 == null ? 0 : l1.val;
            int q = l2 == null ? 0 : l2.val;
            int sum = p + q + remainder;
            // 更新余数
            remainder = sum / 10;
            // 添加新节点
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 当余数大于0时，代表仍需进一
        if (remainder > 0){
            pre.next = new ListNode(remainder);
        }
        return dummy.next;
    }
}

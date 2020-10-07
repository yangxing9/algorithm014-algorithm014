/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headAA= headA;
        ListNode headBB= headB;
        while (headA != headB){
            if (headA != null){
                headA = headA.next;
            }else {
                headA = headBB;
            }
            if (headB != null){
                headB = headB.next;
            }else {
                headB = headAA;
            }
        }
        return headA;
    }

}

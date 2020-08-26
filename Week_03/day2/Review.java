
/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/25 0025 15:19
 */
public class Review {

    public static void main(String[] args) {
        ReviewNode a = new ReviewNode(1);
        ReviewNode b = new ReviewNode(2);
        ReviewNode c = new ReviewNode(3);
        ReviewNode d = new ReviewNode(4);
        ReviewNode e = new ReviewNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReviewNode result = reverseKGroup(a,3);
        System.out.println(result);
    }

    /**
     * 反转链表 - 递归写法
     * @param head
     * @return
     */
    public static ReviewNode reverseList(ReviewNode head) {
        if (head == null || head.next == null) return head;
        ReviewNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 反转链表 - 循环写法
     * @param head
     * @return
     */
    public static ReviewNode reverseList2(ReviewNode head) {
        if (head == null || head.next == null) return head;
        ReviewNode pre = null;
        ReviewNode cur = head;
        while (cur != null){
            ReviewNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 24. 两两交换链表中的节点 - 递归写法
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 注意，交换的是当前节点和后一个节点，而不是后一个节点和后后个节点
     * @param head
     * @return
     */
    public static ReviewNode swapPairs(ReviewNode head) {
        if (head == null || head.next == null) return head;
        ReviewNode next = head.next;
        ReviewNode p = swapPairs(next.next);
        next.next = head;
        head.next = p;
        return next;
    }

    /**
     * 24. 两两交换链表中的节点 - 循环写法
     * @param head
     * @return
     */
    public static ReviewNode swapPairs2(ReviewNode head) {
        if (head == null || head.next == null) return head;
        ReviewNode dutty = new ReviewNode(-1);
        ReviewNode pre = dutty;
        pre.next = head;
        ReviewNode cur = head;
        while (cur != null && cur.next != null){
            ReviewNode tmp = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
        }
        return dutty.next;
    }

    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */
    public static ReviewNode reverseKGroup(ReviewNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ReviewNode dutty = new ReviewNode(-1);
        ReviewNode pre = dutty;
        pre.next = head;
        ReviewNode cur = head;
        while (cur != null && cur.next != null){
            int count = 1;
            ReviewNode tmp = cur;
            while (count < k && tmp != null && tmp.next != null){
                count++;
                tmp = tmp.next;
            }
            ReviewNode next = tmp.next;
            tmp.next = null;
            if (count == k){
                ReviewNode node = reverseList(cur);
                pre.next = node;
                cur.next = next;
                pre = cur;
            }else {
                break;
            }
            cur = next;
        }
        return dutty.next;
    }

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ReviewNode mergeTwoLists(ReviewNode l1, ReviewNode l2) {
        ReviewNode dummy = new ReviewNode(-1);
        ReviewNode first = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
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

    public ReviewNode mergeTwoLists2(ReviewNode l1, ReviewNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,j = n - 1,newIndex = m + n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[newIndex--] = nums1[i--];
            }else{
                nums1[newIndex--] = nums2[j--];
            }
        }
        if (i < 0 && j >= 0){
            System.arraycopy(nums2,0,nums1,0,j + 1);
        }
    }

}

class ReviewNode {
    int val;
    ReviewNode next;
    ReviewNode(int x) { val = x; }
}
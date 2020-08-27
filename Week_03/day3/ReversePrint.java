import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/26 0026 15:05
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            result[index++] = list.get(i);
        }
        return result;
    }

    public int[] reversePrint2(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null){
            deque.push(head.val);
            head = head.next;
        }
        int[] result = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()){
            result[index++] = deque.pop();
        }
        return result;
    }

    public int[] reversePrint3(ListNode head) {
        if (head == null) return new int[0];
        int[] result = new int[length(head)];
        return doReversePrint3(result,head,length(head) - 1);
    }

    //计算链表的长度
    public int length(ListNode head) {
        int cout = 0;
        ListNode dummy = head;
        while (dummy != null) {
            cout++;
            dummy = dummy.next;
        }
        return cout;
    }

    public int[] doReversePrint3(int[] nums,ListNode head,int index){
        if (head == null) return nums;
        doReversePrint3(nums,head.next,index - 1);
        nums[index] = head.val;
        return nums;
    }

    /**
     * 两个迭代，空间复杂度最优
     */
    public static int[] reversePrint4(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            length ++;
            cur = cur.next;
        }
        int[] result = new int[length];
        int index = length - 1;
        while (head != null){
            result[index--] = head.val;
            head = head.next;
        }
        return result;
    }

    private int[] resultNum;
    private int length;

    /**
     * 一次递归，空间复杂度最优
     * @param head
     * @return
     */
    public int[] reversePrint5(ListNode head) {
        if (head == null) return new int[0];
        doReversePrint5(head);
        return resultNum;
    }

    public void doReversePrint5(ListNode head) {
        if (head == null) return;
        length++;
        doReversePrint5(head.next);
        if (resultNum == null){
            resultNum = new int[length];
            length = 0;
        }
        resultNum[length++] = head.val;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        int[] result = reversePrint4(n1);
        System.out.println(Arrays.toString(result));
    }

}

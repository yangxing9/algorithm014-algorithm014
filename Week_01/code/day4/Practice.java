package day4;


import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/13 0013 09:38
 */
public class Practice {

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
        ListNode result = practiceReverseList3(a);
        System.out.println(result.val);
    }

    /**
     * 第二遍，复习三数之和
     * 三重暴力法
     * @param nums
     * @return
     */
    public List<List<Integer>> practiceThreeSum(int[] nums) {
        // 第二遍错的点：少加了入参校验
        if (nums == null || nums.length == 0){
            return Collections.emptyList();
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> list = new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
                        list.sort((a,b) -> a - b);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 第二遍，复习三数之和
     * 二重循环 + hash
     * @param nums
     * @return
     */
    public List<List<Integer>> practiceThreeSum2(int[] nums) {
        if (nums == null || nums.length == 0){
            return Collections.emptyList();
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            Map<Integer,Integer> cache = new HashMap<>(nums.length);
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                if (cache.containsKey(target)){
                    ArrayList<Integer> list = new ArrayList(Arrays.asList(nums[i],nums[j],target));
                    list.sort((a,b) -> a - b);
                    set.add(list);
                }else {
                    cache.put(nums[j],nums[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 第二遍，复习三数之和
     * 排序 + 双重循环 + 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> practiceThreeSum3(int[] nums) {
        if (nums == null || nums.length == 0){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i -1]) continue;
            for (int j = i + 1,k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] < 0){
                    while (j < k && nums[j] == nums[++j]);
                } else if (nums[i] + nums[j] + nums[k] > 0){
                    while (j < k && nums[k] == nums[--k]);
                }else{
                    result.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }
        return result;
    }

    /**
     * 第二遍复习 反转链表
     * 1，递归写法
     * @param head
     * @return
     */
    public static ListNode practiceReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        practiceReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return null;
    }

    /**
     * 第二遍复习 反转链表
     * 2，循环遍历写法
     * @param head
     * @return
     */
    public static ListNode practiceReverseList2(ListNode head) {
        ListNode pre = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        // 第二遍写错的点，返回错了，写的head
        return pre;
    }

    /**
     * 第二遍复习 反转链表
     * 2，尾递归
     * @param head
     * @return
     */
    public static ListNode practiceReverseList3(ListNode head) {
        return doPracticeReverseList3(head,null);
    }

    public static ListNode doPracticeReverseList3(ListNode head,ListNode pre) {
        if (head == null){
            return pre;
        }
        ListNode next = head.next;
        head.next = pre;
        return doPracticeReverseList3(next,head);
    }

    /**
     * 复习第二遍 24. 两两交换链表中的节点
     * 1.递归写法
     *  给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     *  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  示例:
     *
     *  给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public static ListNode practiceSwapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        ListNode node = practiceSwapPairs(second.next);
        second.next = head;
        head.next = node;
        return second;
    }

    /**
     * 复习第二遍
     * 2，遍历写法
     */
    public static ListNode practiceSwapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode pre = tmp;
        // 第二遍写错的点，少了一个条件
        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            head = first.next;
        }

        return tmp.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
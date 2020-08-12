package day3;

import java.util.*;

/**
 *  @author yangxing
 *  @date 2020-8-12
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    
    public static void main(String[] args) {
        
    }

    /**
     * 三重暴力法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        // 使用set去重
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
                        // 元素的顺序影响 set 是否唯一，所以排下序
                        list.sort((a, b) -> a - b);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 两重循环 + hash
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        // 使用set去重
        Set<List<Integer>> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 注意要缓存的值从哪开始
            HashMap<Integer,Integer> cache = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                if(cache.containsKey(target)){
                    List<Integer> list = new ArrayList(Arrays.asList(nums[i],nums[j],target));
                    // 元素的顺序影响 set 是否唯一，所以排下序
                    list.sort((a, b) -> a - b);
                    set.add(list);
                }else{
                    // 缓存从 j 开始
                    cache.put(nums[j],nums[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 排序 + 双指针，终极方案
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        if(nums == null || nums.length < 3){
            return Collections.emptyList();
        }
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 优化1：当考察的元素 > 0，则后面的元素肯定相加 > 0，直接退出
            if (nums[i] > 0) break;
            // 优化2，从第二个元素开始，若与上一个元素相同，则不需要考察了，此处优化的是第一个元素，与下面优化相同元素不是同一个地方
            // 下面的左右指针同样也优化了相同值
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = nums.length - 1,k = i + 1; k < j; ) {
                if (nums[i] + nums[j] + nums[k] < 0){
                    // 如果和小于0，则表示左指针太小了，需要大一点，即k需要自增，同时，注意 自增不能超过 j，所以需要两个条件
                    // 优化3：遇到相同的元素，跳过该元素
                    while(k < j && nums[k] == nums[++k]){}
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    // 同理 和大于o，j需要自减
                    while(k < j && nums[j] == nums[--j]){}
                }else{
                    // 元素已经排序，所以不用去重复
                    result.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                    // 注意，虽然已经找到了目标值，但是不要太高兴，忘了左右指针是需要移动的，假如移动左指针
                    // 右指针移动是因为此时已经 三个数和为0，左指针自增后变大，那么当前的右指针必然不符合和为0，需要变小，即j自减
                    // 这里优化的是若下个元素为同样的值，则跳过，同样，不要忘记 k < j 的条件
                    while(k < j && nums[k] == nums[++k]){}
                    while(k < j && nums[j] == nums[--j]){}
                }
            }
        }
        return result;
    }


}

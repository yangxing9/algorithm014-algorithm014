package day3;

import java.util.*;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/2 0002 14:38
 */
public class ThreeSum5 {

    public static void main(String[] args) {


    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Set<List<Integer>> res = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            HashSet set = new HashSet();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                if (set.contains(target)){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],target));
                    list.sort((a,b) -> a - b);
                    res.add(list);
                }else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1,k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                } else if (nums[i] + nums[j] + nums[k] < 0){
                    while (j < k && nums[j] == nums[++j]);
                } else {
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }
        return res;
    }

}
